public class Scanner {
	private String src;
	private String path;
	private String fileName;
	private AnalyzedTokenList tokenList = new AnalyzedTokenList();
	private AnalyzedTokenList noFakeTokenList = new AnalyzedTokenList();
	
	private LexicalAnalysisException lException;
	private ScannerException sException;
	
	public void run(String[] args) {
		if (args[0] == null) {
			sException = new ScannerException();
			System.err.print(sException.getMessage(ScannerException.ScannerErrorCode.NO_ARGUMENT));
			return;
		}
		
		getInfos(args[0]);
		readSource();
		
		if (src == "") {
			sException = new ScannerException(path);
			System.err.print(sException.getMessage(ScannerException.ScannerErrorCode.FILE_NOT_FOUND));
		}
		
		
		int flag = analysisTokens();
		if (flag == -1) {
			System.err.print(lException.getMessage(LexicalAnalysisException.LexicalErrorCode.ILLEGAL_CODE));
		}
		
		getNoFakeTokenList();
//		writeTokens();
	}
	
	private void getInfos(String path) {
		String[] strs = path.split("/");
		
		this.path = path;
		this.fileName = strs[strs.length - 1];
	}
	
	private void readSource() {
		SourceReader sourceReader = new SourceReader();
		src = sourceReader.run(path);
	}
	
	private int analysisTokens() {
		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(src, fileName);
		tokenList = lexicalAnalyzer.run();
		
		if (tokenList == null && lexicalAnalyzer.getIllegalFlag() == 1) {
			lException = new LexicalAnalysisException(lexicalAnalyzer.getLine(), fileName, src.charAt(lexicalAnalyzer.getIdx()));
			tokenList = lexicalAnalyzer.getTokenList();
			return -1;
		} else if (tokenList == null) {
			tokenList = lexicalAnalyzer.getTokenList();
			return 0;
		} else return 1;
	}
	
	private void getNoFakeTokenList() {
		for (Token token : tokenList) {
        	switch(token.getTokenType()) {
        		// Fake token 일 경우
        		case SPACE: case NEW_LINE: case TAB:
        			continue;
        		default:
        			noFakeTokenList.add(token);
        	}
        }
	}
	
	private void writeTokens() {
		TokenWriter tokenWriter = new TokenWriter(fileName);
		tokenWriter.run(noFakeTokenList);
	}
	
	public AnalyzedTokenList getTokenList(boolean containWhiteSpace) {
		return containWhiteSpace? tokenList : noFakeTokenList;
	}
	
	public String getFileName() {
		return this.fileName;
	}
}
