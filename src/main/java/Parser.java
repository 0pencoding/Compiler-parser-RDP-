public class Parser {
	private AnalyzedTokenList tokenList = new AnalyzedTokenList();
	private Scanner scanner = new Scanner();
	private ParserWriter writer;
	private String fileName;
	
	public void run(String[] args) {
		runScanner(args);
		fileName = scanner.getFileName();
		
		try {
			writer = new ParserWriter(fileName);
			writer.init();
			
			class_func();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void runScanner(String[] args) {
		scanner.run(args);
		tokenList = scanner.getTokenList(false);
	}
	
	private void class_func() throws ParserException {
		match("class");
		match(Token.TokenType.ID);
		match(Token.TokenType.LEFT_CURLY_BRACE);
		
		if(tokenList.getCurrentType() == Token.TokenType.LINE_COMMENTS)
			match(Token.TokenType.LINE_COMMENTS);
		
		main_func();
		match(Token.TokenType.RIGHT_CURLY_BRACE);
	}
	
	private void main_func() throws ParserException{
		match("main");
		match(Token.TokenType.LEFT_PARENTHESIS);
		match(Token.TokenType.RIGHT_PARENTHESIS);
		match(Token.TokenType.LEFT_CURLY_BRACE);
		
		if(tokenList.getCurrentType() == Token.TokenType.LINE_COMMENTS)
			match(Token.TokenType.LINE_COMMENTS);
		
		body_func();
		match(Token.TokenType.RIGHT_CURLY_BRACE);
	}
	
	private void body_func() throws ParserException {
		if(tokenList.getCurrentValue() == "if") {
			if_statement_func();
			body_func();
		} else if(tokenList.getCurrentValue() == "while") {
			while_loop_func();
			body_func();
		} else if(tokenList.getCurrentValue() == "for") {
			for_loop_func();
			body_func();
		} else if(tokenList.getCurrentType() == Token.TokenType.LINE_COMMENTS) {
			match(Token.TokenType.LINE_COMMENTS);
			body_func();
		} else if(tokenList.getCurrentValue() == "int" 
				|| tokenList.getCurrentValue() == "out.println" 
				|| tokenList.getCurrentType() == Token.TokenType.ID) {
			stmt_sequence_func();
			body_func();
		}
	}
	
	private void if_statement_func() throws ParserException {
		match("if");
		match(Token.TokenType.LEFT_PARENTHESIS);
		condition_func();
		match(Token.TokenType.RIGHT_PARENTHESIS);
		match(Token.TokenType.LEFT_CURLY_BRACE);
		body_func();
		match(Token.TokenType.RIGHT_CURLY_BRACE);
		
		while(tokenList.getCurrentValue() == "else if") {
			match("else if");
			match(Token.TokenType.LEFT_PARENTHESIS);
			condition_func();
			match(Token.TokenType.RIGHT_PARENTHESIS);
			match(Token.TokenType.LEFT_CURLY_BRACE);
			body_func();
			match(Token.TokenType.RIGHT_CURLY_BRACE);
		}
		
		if(tokenList.getCurrentValue() == "else") {
			match("else");
			match(Token.TokenType.LEFT_CURLY_BRACE);
			body_func();
			match(Token.TokenType.RIGHT_CURLY_BRACE);
		}
	}
	
	private void while_loop_func() throws ParserException {
		match("while");
		match(Token.TokenType.LEFT_PARENTHESIS);
		condition_func();
		match(Token.TokenType.RIGHT_PARENTHESIS);
		match(Token.TokenType.LEFT_CURLY_BRACE);
		body_func();
		match(Token.TokenType.RIGHT_CURLY_BRACE);
	}
	
	private void for_loop_func() throws ParserException {
		match("for");
		match(Token.TokenType.LEFT_PARENTHESIS);
		init_stmt_func();
		match(Token.TokenType.TERMINATOR);
		condition_func();
		match(Token.TokenType.TERMINATOR);
		assignment_stmt_func();
		match(Token.TokenType.RIGHT_PARENTHESIS);
		match(Token.TokenType.LEFT_CURLY_BRACE);
		body_func();
		match(Token.TokenType.RIGHT_CURLY_BRACE);
	}
	
	private void stmt_sequence_func() throws ParserException {
		if(tokenList.getCurrentValue() == "int" 
				|| tokenList.getCurrentValue() == "out.println" 
				|| tokenList.getCurrentType() == Token.TokenType.ID) {
			statement_func();
			match(Token.TokenType.TERMINATOR);
			stmt_sequence_func();
		}
	}
	
	private void statement_func() throws ParserException {
		if(tokenList.getCurrentValue() == "int")
			init_stmt_func();
		else if(tokenList.getCurrentValue() == "out.println") {
			match("out.println");
			match(Token.TokenType.LEFT_PARENTHESIS);
			string_id_func();
			match(Token.TokenType.RIGHT_PARENTHESIS);
		} else if(tokenList.getCurrentType() == Token.TokenType.ID) {
			match(Token.TokenType.ID);
			exp_list_func();
		} else {
			System.out.println("Parsing Error");
			writer.write("Parsing Error");
			writer.close();
			throw new ParserException(fileName);
		}
	}
	
	private void string_id_func() throws ParserException {
		switch(tokenList.getCurrentType()) {
			case STRING_LITERAL:
				match(Token.TokenType.STRING_LITERAL);
				break;
			case ID:
				match(Token.TokenType.ID);
				break;
			default:
				System.out.println("Parsing Error");
				writer.write("Parsing Error");
				writer.close();
				throw new ParserException(fileName);
		}
	}
	
	private void exp_list_func() throws ParserException {
		switch(tokenList.getCurrentType()) {
			case ASSIGNMENT:
				match(Token.TokenType.ASSIGNMENT);
				expression_func();
				break;
			case INCREMENT:
				match(Token.TokenType.INCREMENT);
				break;
			default:
				System.out.println("Parsing Error");
				writer.write("Parsing Error");
				writer.close();
				throw new ParserException(fileName);
		}
	}

	private void init_stmt_func() throws ParserException {
		match("int");
		assignment_stmt_func();
	}
	
	private void assignment_stmt_func() throws ParserException {
		match(Token.TokenType.ID);
		match(Token.TokenType.ASSIGNMENT);
		expression_func();
	}
	
	private void condition_func() throws ParserException {
		expression_func();
		conditional_op_func();
		expression_func();
	}
	
	private void conditional_op_func() throws ParserException {
		switch(tokenList.getCurrentType()) {
			case LESS_THAN:
				match(Token.TokenType.LESS_THAN);
				break;
			case GREATER_THAN:
				match(Token.TokenType.GREATER_THAN);
				break;
			case LTE:
				match(Token.TokenType.LTE);
				break;
			case GTE:
				match(Token.TokenType.GTE);
				break;
			case EQUAL:
				match(Token.TokenType.EQUAL);
				break;
			case NEQ:
				match(Token.TokenType.NEQ);
				break;
			default:
				System.out.println("Parsing Error");
				writer.write("Parsing Error");
				writer.close();
				throw new ParserException(fileName);
		}
	}
	 
	private void expression_func() throws ParserException {
		term_func();
		
		if(tokenList.getCurrentType() == Token.TokenType.PLUS
			|| tokenList.getCurrentType() == Token.TokenType.MINUS) {
			add_op_func();
			expression_func();
		}
	}
	
	private void term_func() throws ParserException {
		factor_func();
		
		if(tokenList.getCurrentType() == Token.TokenType.TIMES
			|| tokenList.getCurrentType() == Token.TokenType.DIVIDE) {
			muldiv_op_func();
			term_func();
		}
	}
	
	private void add_op_func() throws ParserException {
		switch(tokenList.getCurrentType()) {
			case PLUS:
				match(Token.TokenType.PLUS);
				break;
			case MINUS:
				match(Token.TokenType.MINUS);
				break;
			default:
				System.out.println("Parsing Error");
				writer.write("Parsing Error");
				writer.close();
				throw new ParserException(fileName);
		}
	}
	
	private void muldiv_op_func() throws ParserException {
		switch(tokenList.getCurrentType()) {
			case TIMES:
				match(Token.TokenType.TIMES);
				break;
			case DIVIDE:
				match(Token.TokenType.DIVIDE);
				break;
			default:
				System.out.println("Parsing Error");
				writer.write("Parsing Error");
				writer.close();
				throw new ParserException(fileName);
		}
	}
	
	private void factor_func() throws ParserException {
		if(tokenList.getCurrentType() == Token.TokenType.LEFT_PARENTHESIS) {
			match(Token.TokenType.LEFT_PARENTHESIS);
			expression_func();
			match(Token.TokenType.RIGHT_PARENTHESIS);
		} else if(tokenList.getCurrentType() == Token.TokenType.NUMBER_LITERAL)
			match(Token.TokenType.NUMBER_LITERAL);
		else if(tokenList.getCurrentType() == Token.TokenType.ID)
			match(Token.TokenType.ID);
		else {
			System.out.println("Parsing Error");
			writer.write("Parsing Error");
			writer.close();
			throw new ParserException(fileName);
		}
	}
	
	private void match(Token.TokenType expectedToken) throws ParserException {
		if(tokenList.getCurrentType() == expectedToken) {
			// write output File
			System.out.println(tokenList.getCurrentValue());
			writer.write(tokenList.getCurrentValue());
			if(!tokenList.next()) {
				System.out.println("Parsing OK");
				writer.write("Parsing OK");
				writer.close();
			}
		} else {
			System.out.println("Parsing Error");
			writer.write("Parsing Error");
			writer.close();
			throw new ParserException(fileName);
		}
	}
	
	private void match(String expectedToken) throws ParserException {
		if(tokenList.getCurrentValue() == expectedToken) {
			// write output File
			System.out.println(tokenList.getCurrentValue());
			writer.write(tokenList.getCurrentValue());
			if(!tokenList.next()) {
				System.out.println("Parsing OK");
				writer.write("Parsing OK");
				writer.close();
			}
		} else {
			System.out.println("Parsing Error");
			writer.write("Parsing Error");
			writer.close();
			throw new ParserException(fileName);
		}
	}
}
