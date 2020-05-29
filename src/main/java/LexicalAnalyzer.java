public class LexicalAnalyzer {
	private int idx;
	private int line;
	private String src;
	private String fileName;
	private AnalyzedTokenList tokenList = new AnalyzedTokenList();
	private int illegalFlag = 0;
	private int illegalIdx;
	
	public LexicalAnalyzer(String src, String fileName) {
		idx = 0;
		line = 1;
		this.src = src;
		this.fileName = fileName;
	}
	
	public AnalyzedTokenList run() {
		while(idx < src.length()) {
			// keyword check
			KeywordTable keywordType = KeywordTable.find(src.substring(idx));
			
			if (keywordType != null) {
				Token token = new Token(Token.TokenType.KEYWORD, keywordType.getKeyword(), line);
				
				tokenList.add(token);
				idx += token.length();
			} else {
				// DFA check
				Token token = checkDFA(States.Q0, idx, idx);
				if (token == null) {
//					Token lastToken = tokenList.get(tokenList.size()-1);
					tokenList.add(new Token(Token.TokenType.ERROR, src.substring(idx, illegalIdx + 1), line));
					return null;
				}
				else tokenList.add(token);
			}
		}
		
		return tokenList;
	}
	

	private Token checkDFA(States curr_state, int start_idx, int r_idx) {
		do {
			curr_state = curr_state.transition(src.charAt(r_idx++));
		} while (curr_state != null && curr_state != States.ERROR && !curr_state.isAccept());
		
		if (curr_state == null) {
			illegalIdx = r_idx-1;
			LexicalAnalysisException lException = new LexicalAnalysisException(line, fileName, src.charAt(illegalIdx));
			System.err.print(lException.getMessage(LexicalAnalysisException.LexicalErrorCode.ILLEGAL_CODE));
			return null;
		} else if (curr_state == States.ERROR) {
			illegalFlag = 1;
			illegalIdx = r_idx-1;
			return null;
		} else {
			Token token = null;
			
			if (isMoreChar(curr_state.getTokenType())) {
				token = checkDFA(curr_state, start_idx, r_idx);
			}
			
			if (token == null) {
				token = new Token(curr_state.getTokenType(), src.substring(start_idx, r_idx), line);
				if (token.getTokenType() == Token.TokenType.NEW_LINE) line++;
				idx = r_idx;
				
				return token;
			} else return token;
		}
	}
	
	private boolean isMoreChar(Token.TokenType type) {
		switch(type) {
			case PLUS: case MINUS: case TIMES: case DIVIDE: case REMAINDER: 
				case GREATER_THAN: case LESS_THAN: case ASSIGNMENT: case NOT:
				case ID: case NUMBER_LITERAL: case LINE_COMMENTS:
				return true;
			default:
				return false;
		}
	}
	
	public int getLine() {
		return line;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public int getIllegalFlag() {
		return illegalFlag;
	}
	
	public AnalyzedTokenList getTokenList() {
		return tokenList;
	}
}
