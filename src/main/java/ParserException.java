@SuppressWarnings("serial")
public class ParserException extends Exception {
	private String fileName; // 오류 프로젝트
	
	public enum ParserErrorCode {
		STATEMENT, STRING_ID, EXP_LIST,
		CONDITIONAL_OP, ADD_OP, MULDIV_OP,
		FACTOR, KEYWORD_MATCH, TOKENTYPE_MATCH;
	}
	
	public ParserException() {
		this.fileName = null;
	}

	public ParserException(String fileName) {
		this.fileName = fileName;
	}
	
	public String getMessage(ParserErrorCode code) {
		String msg = "exception.ParserException:";
		
		switch(code) {
			case STATEMENT:
				return msg + "\n\t" + fileName + ": Parsing Error in statement_func()\n";
			case STRING_ID:
				return msg + "\n\t\" + fileName + \": Parsing Error in string_id_func()\n";
			case EXP_LIST:
				return msg + "\n\t\" + fileName + \": Parsing Error in exp_list_func()\n";
			case CONDITIONAL_OP:
				return msg + "\n\t\" + fileName + \": Parsing Error in conditional_op_func()\n";
			case ADD_OP:
				return msg + "\n\t\" + fileName + \": Parsing Error in add_op_func()\n";
			case MULDIV_OP:
				return msg + "\n\t\" + fileName + \": Parsing Error in muldiv_op_func()\n";
			case FACTOR:
				return msg + "\n\t\" + fileName + \": Parsing Error in factor_func()\n";
			case KEYWORD_MATCH:
				return msg + "\n\t\" + fileName + \": Parsing Error in keyword_match_func()\n";
			case TOKENTYPE_MATCH:
				return msg + "\n\t\" + fileName + \": Parsing Error in tokentype_match_func()\n";
			default: 
				return msg + "\n\t\" + fileName + \": An error occurred in parser with no explanation\n"; 
		}
	}
}
