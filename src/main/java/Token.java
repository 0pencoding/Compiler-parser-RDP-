public class Token {
	public enum TokenType {
		// Keyword
		KEYWORD, // if, else if, else, for, while, class, int, out.println
		
		// Identifiers
		ID, // $ , $_ , __ , ...
		
		// Literals
		NUMBER_LITERAL, // 0, -3.4, 5E3, ...
		STRING_LITERAL, // ".*"
		
		// Special symbols
		LEFT_PARENTHESIS, RIGHT_PARENTHESIS, LEFT_CURLY_BRACE, RIGHT_CURLY_BRACE, LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET, // Brackets: (, ), {, }, [, ]
		PLUS, MINUS, TIMES, DIVIDE, REMAINDER, PLUS_ASSIGNMENT, MINUS_ASSIGNMENT, TIMES_ASSIGNMENT, DIVIDE_ASSIGNMENT, REMAINDER_ASSIGNMENT, 
		INCREMENT, DECREMENT, // Arithmetic operator: +, -, *, /, %, +=, -=, *=, /=, %=, ++, --
		GREATER_THAN, LESS_THAN, EQUAL, GTE, LTE, NEQ, // Comparison operator: >, <, ==, >=, <=, !=
		AND, OR, NOT, // Logical operator: &&, ||, !
		ASSIGNMENT, // =
		TERMINATOR, // ;
		
		// White space
		LINE_COMMENTS, // //
		SPACE, // ' '
		NEW_LINE, // \n
		TAB, // \t
		
		// Error
		ERROR;
	}
	
	private TokenType type;
	private String value;
	private int line;
	
	public Token(TokenType type, String value, int line) {
		this.type = type;
		this.value = value;
		this.line = line;
	}
	
	public TokenType getTokenType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}
	
	public int length() {
		return value.length();
	}
	
	public int getLine() {
		return line;
	}
	
	public String toString() {
		if (type == TokenType.ERROR) 
			return "exception.LexicalAnalysisException:\n\tToken is illegal ";
		else return value + "\t" + type;
	}
 }
