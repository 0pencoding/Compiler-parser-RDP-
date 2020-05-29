public enum States {
	Q0(false, null), Q1(false, null), Q2(true, Token.TokenType.ID), Q3(true, Token.TokenType.PLUS), Q4(true, Token.TokenType.NUMBER_LITERAL), Q5(false, null), 
	Q6(true, Token.TokenType.NUMBER_LITERAL), Q7(false, null), Q8(false, null), Q9(true, Token.TokenType.NUMBER_LITERAL), Q10(true, Token.TokenType.MINUS), 
	Q11(false, null), Q12(false, null), Q13(false, null), Q14(true, Token.TokenType.NEW_LINE), Q15(true, Token.TokenType.DIVIDE), 
	Q16(true, Token.TokenType.LINE_COMMENTS), Q17(true, Token.TokenType.DIVIDE_ASSIGNMENT), Q18(true, Token.TokenType.INCREMENT), Q19(true, Token.TokenType.PLUS_ASSIGNMENT), 
	Q20(true, Token.TokenType.DECREMENT), Q21(true, Token.TokenType.MINUS_ASSIGNMENT), Q22(true, Token.TokenType.STRING_LITERAL), Q23(true, Token.TokenType.OR), 
	Q24(true, Token.TokenType.AND), Q25(true, Token.TokenType.TIMES), Q26(true, Token.TokenType.REMAINDER), Q27(true, Token.TokenType.ASSIGNMENT), 
	Q28(true, Token.TokenType.GREATER_THAN), Q29(true, Token.TokenType.LESS_THAN), Q30(true, Token.TokenType.NOT), Q31(true, Token.TokenType.TIMES_ASSIGNMENT), 
	Q32(true, Token.TokenType.REMAINDER_ASSIGNMENT), Q33(true, Token.TokenType.EQUAL), Q34(true, Token.TokenType.GTE), Q35(true, Token.TokenType.LTE), 
	Q36(true, Token.TokenType.NEQ), Q37(true, Token.TokenType.LEFT_PARENTHESIS), Q38(true, Token.TokenType.RIGHT_PARENTHESIS), Q39(true, Token.TokenType.LEFT_CURLY_BRACE), 
	Q40(true, Token.TokenType.RIGHT_CURLY_BRACE), Q41(true, Token.TokenType.LEFT_SQUARE_BRACKET), Q42(true, Token.TokenType.RIGHT_SQUARE_BRACKET), 
	Q43(true, Token.TokenType.TERMINATOR), Q44(true, Token.TokenType.TAB), Q45(true, Token.TokenType.SPACE),
	ERROR(false, null);
	
	States plus, minus, underbar, id_char, zeroTo9, assign, or, and, double_quotes, E, dot, 
	times, remainder, gt, lt, not, left_paren, right_paren, left_curly, rigth_curly, 
	left_square, right_square, terminator, tab, space, new_line, divide;
	
	static {
		Q0.plus = Q3; Q0.minus = Q10; Q0.underbar = Q1; Q0.id_char = Q2; Q0.zeroTo9 = Q4; Q0.assign = Q27; Q0.or = Q12; Q0.and = Q13;
		Q0.double_quotes = Q11; Q0.E = Q2; Q0.dot = ERROR; Q0.times = Q25; Q0.remainder = Q16; Q0.gt = Q28; Q0.lt = Q29; Q0.not = Q30;
		Q0.left_paren = Q37; Q0.right_paren = Q38; Q0.left_curly = Q39; Q0.rigth_curly = Q40; Q0.left_square = Q41; Q0.right_square = Q42; 
		Q0.terminator = Q43; Q0.tab = Q44; Q0.space = Q45; Q0.new_line = Q14; Q0.divide = Q15;
		
		Q1.plus = ERROR; Q1.minus = ERROR; Q1.underbar = Q2; Q1.id_char = Q2; Q1.zeroTo9 = Q2; Q1.assign = ERROR; Q1.or = ERROR; Q1.and = ERROR;
		Q1.double_quotes = ERROR; Q1.E = Q2; Q1.dot = ERROR; Q1.times = ERROR; Q1.remainder = ERROR; Q1.gt = ERROR; Q1.lt = ERROR; Q1.not = ERROR;
		Q1.left_paren = ERROR; Q1.right_paren = ERROR; Q1.left_curly = ERROR; Q1.rigth_curly = ERROR; Q1.left_square = ERROR; Q1.right_square = ERROR; 
		Q1.terminator = ERROR; Q1.tab = ERROR; Q1.space = ERROR; Q1.new_line = ERROR; Q1.divide = ERROR;
		
		Q2.plus = ERROR; Q2.minus = ERROR; Q2.underbar = Q2; Q2.id_char = Q2; Q2.zeroTo9 = Q2; Q2.assign = ERROR; Q2.or = ERROR; Q2.and = ERROR;
		Q2.double_quotes = ERROR; Q2.E = Q2; Q2.dot = ERROR; Q2.times = ERROR; Q2.remainder = ERROR; Q2.gt = ERROR; Q2.lt = ERROR; Q2.not = ERROR;
		Q2.left_paren = ERROR; Q2.right_paren = ERROR; Q2.left_curly = ERROR; Q2.rigth_curly = ERROR; Q2.left_square = ERROR; Q2.right_square = ERROR; 
		Q2.terminator = ERROR; Q2.tab = ERROR; Q2.space = ERROR; Q2.new_line = ERROR; Q2.divide = ERROR;
		
		Q3.plus = Q18; Q3.minus = ERROR; Q3.underbar = ERROR; Q3.id_char = ERROR; Q3.zeroTo9 = Q4; Q3.assign = Q19; Q3.or = ERROR; Q3.and = ERROR;
		Q3.double_quotes = ERROR; Q3.E = ERROR; Q3.dot = ERROR; Q3.times = ERROR; Q3.remainder = ERROR; Q3.gt = ERROR; Q3.lt = ERROR; Q3.not = ERROR;
		Q3.left_paren = ERROR; Q3.right_paren = ERROR; Q3.left_curly = ERROR; Q3.rigth_curly = ERROR; Q3.left_square = ERROR; Q3.right_square = ERROR; 
		Q3.terminator = ERROR; Q3.tab = ERROR; Q3.space = ERROR; Q3.new_line = ERROR; Q3.divide = ERROR;
		
		Q4.plus = ERROR; Q4.minus = ERROR; Q4.underbar = ERROR; Q4.id_char = ERROR; Q4.zeroTo9 = Q4; Q4.assign = ERROR; Q4.or = ERROR; Q4.and = ERROR;
		Q4.double_quotes = ERROR; Q4.E = Q7; Q4.dot = Q5; Q4.times = ERROR; Q4.remainder = ERROR; Q4.gt = ERROR; Q4.lt = ERROR; Q4.not = ERROR;
		Q4.left_paren = ERROR; Q4.right_paren = ERROR; Q4.left_curly = ERROR; Q4.rigth_curly = ERROR; Q4.left_square = ERROR; Q4.right_square = ERROR; 
		Q4.terminator = ERROR; Q4.tab = ERROR; Q4.space = ERROR; Q4.new_line = ERROR; Q4.divide = ERROR;
		
		Q5.plus = ERROR; Q5.minus = ERROR; Q5.underbar = ERROR; Q5.id_char = ERROR; Q5.zeroTo9 = Q6; Q5.assign = ERROR; Q5.or = ERROR; Q5.and = ERROR;
		Q5.double_quotes = ERROR; Q5.E = ERROR; Q5.dot = ERROR; Q5.times = ERROR; Q5.remainder = ERROR; Q5.gt = ERROR; Q5.lt = ERROR; Q5.not = ERROR;
		Q5.left_paren = ERROR; Q5.right_paren = ERROR; Q5.left_curly = ERROR; Q5.rigth_curly = ERROR; Q5.left_square = ERROR; Q5.right_square = ERROR; 
		Q5.terminator = ERROR; Q5.tab = ERROR; Q5.space = ERROR; Q5.new_line = ERROR; Q5.divide = ERROR;
		
		Q6.plus = ERROR; Q6.minus = ERROR; Q6.underbar = ERROR; Q6.id_char = ERROR; Q6.zeroTo9 = Q6; Q6.assign = ERROR; Q6.or = ERROR; Q6.and = ERROR;
		Q6.double_quotes = ERROR; Q6.E = Q7; Q6.dot = ERROR; Q6.times = ERROR; Q6.remainder = ERROR; Q6.gt = ERROR; Q6.lt = ERROR; Q6.not = ERROR;
		Q6.left_paren = ERROR; Q6.right_paren = ERROR; Q6.left_curly = ERROR; Q6.rigth_curly = ERROR; Q6.left_square = ERROR; Q6.right_square = ERROR; 
		Q6.terminator = ERROR; Q6.tab = ERROR; Q6.space = ERROR; Q6.new_line = ERROR; Q6.divide = ERROR;
		
		Q7.plus = Q8; Q7.minus = Q8; Q7.underbar = ERROR; Q7.id_char = ERROR; Q7.zeroTo9 = Q9; Q7.assign = ERROR; Q7.or = ERROR; Q7.and = ERROR;
		Q7.double_quotes = ERROR; Q7.E = ERROR; Q7.dot = ERROR; Q7.times = ERROR; Q7.remainder = ERROR; Q7.gt = ERROR; Q7.lt = ERROR; Q7.not = ERROR;
		Q7.left_paren = ERROR; Q7.right_paren = ERROR; Q7.left_curly = ERROR; Q7.rigth_curly = ERROR; Q7.left_square = ERROR; Q7.right_square = ERROR; 
		Q7.terminator = ERROR; Q7.tab = ERROR; Q7.space = ERROR; Q7.new_line = ERROR; Q7.divide = ERROR;
		
		Q8.plus = ERROR; Q8.minus = ERROR; Q8.underbar = ERROR; Q8.id_char = ERROR; Q8.zeroTo9 = Q9; Q8.assign = ERROR; Q8.or = ERROR; Q8.and = ERROR;
		Q8.double_quotes = ERROR; Q8.E = ERROR; Q8.dot = ERROR; Q8.times = ERROR; Q8.remainder = ERROR; Q8.gt = ERROR; Q8.lt = ERROR; Q8.not = ERROR;
		Q8.left_paren = ERROR; Q8.right_paren = ERROR; Q8.left_curly = ERROR; Q8.rigth_curly = ERROR; Q8.left_square = ERROR; Q8.right_square = ERROR; 
		Q8.terminator = ERROR; Q8.tab = ERROR; Q8.space = ERROR; Q8.new_line = ERROR; Q8.divide = ERROR;
		
		Q9.plus = ERROR; Q9.minus = ERROR; Q9.underbar = ERROR; Q9.id_char = ERROR; Q9.zeroTo9 = Q9; Q9.assign = Q21; Q9.or = ERROR; Q9.and = ERROR;
		Q9.double_quotes = ERROR; Q9.E = ERROR; Q9.dot = ERROR; Q9.times = ERROR; Q9.remainder = ERROR; Q9.gt = ERROR; Q9.lt = ERROR; Q9.not = ERROR;
		Q9.left_paren = ERROR; Q9.right_paren = ERROR; Q9.left_curly = ERROR; Q9.rigth_curly = ERROR; Q9.left_square = ERROR; Q9.right_square = ERROR; 
		Q9.terminator = ERROR; Q9.tab = ERROR; Q9.space = ERROR; Q9.new_line = ERROR; Q9.divide = ERROR;
		
		Q10.plus = ERROR; Q10.minus = Q20; Q10.underbar = ERROR; Q10.id_char = ERROR; Q10.zeroTo9 = Q4; Q10.assign = Q17; Q10.or = ERROR; Q10.and = ERROR;
		Q10.double_quotes = ERROR; Q10.E = ERROR; Q10.dot = ERROR; Q10.times = ERROR; Q10.remainder = ERROR; Q10.gt = ERROR; Q10.lt = ERROR; Q10.not = ERROR;
		Q10.left_paren = ERROR; Q10.right_paren = ERROR; Q10.left_curly = ERROR; Q10.rigth_curly = ERROR; Q10.left_square = ERROR; Q10.right_square = ERROR; 
		Q10.terminator = ERROR; Q10.tab = ERROR; Q10.space = ERROR; Q10.new_line = ERROR; Q10.divide = ERROR;
		
		Q11.plus = Q11; Q11.minus = Q11; Q11.underbar = Q11; Q11.id_char = Q11; Q11.zeroTo9 = Q11; Q11.assign = Q11; Q11.or = Q11; Q11.and = Q11;
		Q11.double_quotes = Q22; Q11.E = Q11; Q11.dot = Q11; Q11.times = Q11; Q11.remainder = Q11; Q11.gt = Q11; Q11.lt = Q11; Q11.not = Q11;
		Q11.left_paren = Q11; Q11.right_paren = Q11; Q11.left_curly = Q11; Q11.rigth_curly = Q11; Q11.left_square = Q11; Q11.right_square = Q11; 
		Q11.terminator = Q11; Q11.tab = Q11; Q11.space = Q11; Q11.new_line = Q11; Q11.divide = Q11;
		
		Q12.plus = ERROR; Q12.minus = ERROR; Q12.underbar = ERROR; Q12.id_char = ERROR; Q12.zeroTo9 = ERROR; Q12.assign = ERROR; Q12.or = Q23; Q12.and = ERROR;
		Q12.double_quotes = ERROR; Q12.E = ERROR; Q12.dot = ERROR; Q12.times = ERROR; Q12.remainder = ERROR; Q12.gt = ERROR; Q12.lt = ERROR; Q12.not = ERROR;
		Q12.left_paren = ERROR; Q12.right_paren = ERROR; Q12.left_curly = ERROR; Q12.rigth_curly = ERROR; Q12.left_square = ERROR; Q12.right_square = ERROR; 
		Q12.terminator = ERROR; Q12.tab = ERROR; Q12.space = ERROR; Q12.new_line = ERROR; Q12.divide = ERROR;
		
		Q13.plus = ERROR; Q13.minus = ERROR; Q13.underbar = ERROR; Q13.id_char = ERROR; Q13.zeroTo9 = ERROR; Q13.assign = ERROR; Q13.or = ERROR; Q13.and = Q24;
		Q13.double_quotes = ERROR; Q13.E = ERROR; Q13.dot = ERROR; Q13.times = ERROR; Q13.remainder = ERROR; Q13.gt = ERROR; Q13.lt = ERROR; Q13.not = ERROR;
		Q13.left_paren = ERROR; Q13.right_paren = ERROR; Q13.left_curly = ERROR; Q13.rigth_curly = ERROR; Q13.left_square = ERROR; Q13.right_square = ERROR; 
		Q13.terminator = ERROR; Q13.tab = ERROR; Q13.space = ERROR; Q13.new_line = ERROR; Q13.divide = ERROR;
		
		Q14.plus = ERROR; Q14.minus = ERROR; Q14.underbar = ERROR; Q14.id_char = ERROR; Q14.zeroTo9 = ERROR; Q14.assign = ERROR; Q14.or = ERROR; Q14.and = ERROR;
		Q14.double_quotes = ERROR; Q14.E = ERROR; Q14.dot = ERROR; Q14.times = ERROR; Q14.remainder = ERROR; Q14.gt = ERROR; Q14.lt = ERROR; Q14.not = ERROR;
		Q14.left_paren = ERROR; Q14.right_paren = ERROR; Q14.left_curly = ERROR; Q14.rigth_curly = ERROR; Q14.left_square = ERROR; Q14.right_square = ERROR; 
		Q14.terminator = ERROR; Q14.tab = ERROR; Q14.space = ERROR;
		
		Q15.plus = ERROR; Q15.minus = ERROR; Q15.underbar = ERROR; Q15.id_char = ERROR; Q15.zeroTo9 = ERROR; Q15.assign = Q17; Q15.or = ERROR; Q15.and = ERROR;
		Q15.double_quotes = ERROR; Q15.E = ERROR; Q15.dot = ERROR; Q15.times = ERROR; Q15.remainder = ERROR; Q15.gt = ERROR; Q15.lt = ERROR; Q15.not = ERROR;
		Q15.left_paren = ERROR; Q15.right_paren = ERROR; Q15.left_curly = ERROR; Q15.rigth_curly = ERROR; Q15.left_square = ERROR; Q15.right_square = ERROR; 
		Q15.terminator = ERROR; Q15.tab = ERROR; Q15.space = ERROR; Q15.new_line = ERROR; Q15.divide = Q16;
		
		Q16.plus = Q16; Q16.minus = Q16; Q16.underbar = Q16; Q16.id_char = Q16; Q16.zeroTo9 = Q16; Q16.assign = Q16; Q16.or = Q16; Q16.and = Q16;
		Q16.double_quotes = Q16; Q16.E = Q16; Q16.dot = Q16; Q16.times = Q16; Q16.remainder = Q16; Q16.gt = Q16; Q16.lt = Q16; Q16.not = Q16;
		Q16.left_paren = Q16; Q16.right_paren = Q16; Q16.left_curly = Q16; Q16.rigth_curly = Q16; Q16.left_square = Q16; Q16.right_square = Q16; 
		Q16.terminator = Q16; Q16.tab = Q16; Q16.space = Q16; Q16.new_line = ERROR; Q16.divide = Q16;
		
		Q17.plus = ERROR; Q17.minus = ERROR; Q17.underbar = ERROR; Q17.id_char = ERROR; Q17.zeroTo9 = ERROR; Q17.assign = ERROR; Q17.or = ERROR; Q17.and = Q24;
		Q17.double_quotes = ERROR; Q17.E = ERROR; Q17.dot = ERROR; Q17.times = ERROR; Q17.remainder = ERROR; Q17.gt = ERROR; Q17.lt = ERROR; Q17.not = ERROR;
		Q17.left_paren = ERROR; Q17.right_paren = ERROR; Q17.left_curly = ERROR; Q17.rigth_curly = ERROR; Q17.left_square = ERROR; Q17.right_square = ERROR; 
		Q17.terminator = ERROR; Q17.tab = ERROR; Q17.space = ERROR;
		
        Q18.plus = ERROR; Q18.minus = ERROR; Q18.underbar = ERROR; Q18.id_char = ERROR; Q18.zeroTo9 = ERROR; Q18.assign = ERROR; Q18.or = ERROR; Q18.and = Q24;
		Q18.double_quotes = ERROR; Q18.E = ERROR; Q18.dot = ERROR; Q18.times = ERROR; Q18.remainder = ERROR; Q18.gt = ERROR; Q18.lt = ERROR; Q18.not = ERROR;
		Q18.left_paren = ERROR; Q18.right_paren = ERROR; Q18.left_curly = ERROR; Q18.rigth_curly = ERROR; Q18.left_square = ERROR; Q18.right_square = ERROR; 
		Q18.terminator = ERROR; Q18.tab = ERROR; Q18.space = ERROR;
		
		Q19.plus = ERROR; Q19.minus = ERROR; Q19.underbar = ERROR; Q19.id_char = ERROR; Q19.zeroTo9 = ERROR; Q19.assign = ERROR; Q19.or = ERROR; Q19.and = Q24;
		Q19.double_quotes = ERROR; Q19.E = ERROR; Q19.dot = ERROR; Q19.times = ERROR; Q19.remainder = ERROR; Q19.gt = ERROR; Q19.lt = ERROR; Q19.not = ERROR;
		Q19.left_paren = ERROR; Q19.right_paren = ERROR; Q19.left_curly = ERROR; Q19.rigth_curly = ERROR; Q19.left_square = ERROR; Q19.right_square = ERROR; 
		Q19.terminator = ERROR; Q19.tab = ERROR; Q19.space = ERROR;

        Q20.plus = ERROR; Q20.minus = ERROR; Q20.underbar = ERROR; Q20.id_char = ERROR; Q20.zeroTo9 = ERROR; Q20.assign = ERROR; Q20.or = ERROR; Q20.and = Q24;
		Q20.double_quotes = ERROR; Q20.E = ERROR; Q20.dot = ERROR; Q20.times = ERROR; Q20.remainder = ERROR; Q20.gt = ERROR; Q20.lt = ERROR; Q20.not = ERROR;
		Q20.left_paren = ERROR; Q20.right_paren = ERROR; Q20.left_curly = ERROR; Q20.rigth_curly = ERROR; Q20.left_square = ERROR; Q20.right_square = ERROR; 
		Q20.terminator = ERROR; Q20.tab = ERROR; Q20.space = ERROR;

        Q21.plus = ERROR; Q21.minus = ERROR; Q21.underbar = ERROR; Q21.id_char = ERROR; Q21.zeroTo9 = ERROR; Q21.assign = ERROR; Q21.or = ERROR; Q21.and = Q24;
		Q21.double_quotes = ERROR; Q21.E = ERROR; Q21.dot = ERROR; Q21.times = ERROR; Q21.remainder = ERROR; Q21.gt = ERROR; Q21.lt = ERROR; Q21.not = ERROR;
		Q21.left_paren = ERROR; Q21.right_paren = ERROR; Q21.left_curly = ERROR; Q21.rigth_curly = ERROR; Q21.left_square = ERROR; Q21.right_square = ERROR; 
		Q21.terminator = ERROR; Q21.tab = ERROR; Q21.space = ERROR;

        Q22.plus = ERROR; Q22.minus = ERROR; Q22.underbar = ERROR; Q22.id_char = ERROR; Q22.zeroTo9 = ERROR; Q22.assign = ERROR; Q22.or = ERROR; Q22.and = Q24;
		Q22.double_quotes = ERROR; Q22.E = ERROR; Q22.dot = ERROR; Q22.times = ERROR; Q22.remainder = ERROR; Q22.gt = ERROR; Q22.lt = ERROR; Q22.not = ERROR;
		Q22.left_paren = ERROR; Q22.right_paren = ERROR; Q22.left_curly = ERROR; Q22.rigth_curly = ERROR; Q22.left_square = ERROR; Q22.right_square = ERROR; 
		Q22.terminator = ERROR; Q22.tab = ERROR; Q22.space = ERROR;

        Q23.plus = ERROR; Q23.minus = ERROR; Q23.underbar = ERROR; Q23.id_char = ERROR; Q23.zeroTo9 = ERROR; Q23.assign = ERROR; Q23.or = ERROR; Q23.and = Q24;
		Q23.double_quotes = ERROR; Q23.E = ERROR; Q23.dot = ERROR; Q23.times = ERROR; Q23.remainder = ERROR; Q23.gt = ERROR; Q23.lt = ERROR; Q23.not = ERROR;
		Q23.left_paren = ERROR; Q23.right_paren = ERROR; Q23.left_curly = ERROR; Q23.rigth_curly = ERROR; Q23.left_square = ERROR; Q23.right_square = ERROR; 
		Q23.terminator = ERROR; Q23.tab = ERROR; Q23.space = ERROR;

        Q24.plus = ERROR; Q24.minus = ERROR; Q24.underbar = ERROR; Q24.id_char = ERROR; Q24.zeroTo9 = ERROR; Q24.assign = ERROR; Q24.or = ERROR; Q24.and = Q24;
		Q24.double_quotes = ERROR; Q24.E = ERROR; Q24.dot = ERROR; Q24.times = ERROR; Q24.remainder = ERROR; Q24.gt = ERROR; Q24.lt = ERROR; Q24.not = ERROR;
		Q24.left_paren = ERROR; Q24.right_paren = ERROR; Q24.left_curly = ERROR; Q24.rigth_curly = ERROR; Q24.left_square = ERROR; Q24.right_square = ERROR; 
		Q24.terminator = ERROR; Q24.tab = ERROR; Q24.space = ERROR;

        Q25.plus = ERROR; Q25.minus = ERROR; Q25.underbar = ERROR; Q25.id_char = ERROR; Q25.zeroTo9 = ERROR; Q25.assign = ERROR; Q25.or = ERROR; Q25.and = Q24;
		Q25.double_quotes = ERROR; Q25.E = ERROR; Q25.dot = ERROR; Q25.times = ERROR; Q25.remainder = ERROR; Q25.gt = ERROR; Q25.lt = ERROR; Q25.not = ERROR;
		Q25.left_paren = ERROR; Q25.right_paren = ERROR; Q25.left_curly = ERROR; Q25.rigth_curly = ERROR; Q25.left_square = ERROR; Q25.right_square = ERROR; 
		Q25.terminator = ERROR; Q25.tab = ERROR; Q25.space = ERROR;
        
        Q26.plus = ERROR; Q26.minus = ERROR; Q26.underbar = ERROR; Q26.id_char = ERROR; Q26.zeroTo9 = ERROR; Q26.assign = ERROR; Q26.or = ERROR; Q26.and = Q24;
		Q26.double_quotes = ERROR; Q26.E = ERROR; Q26.dot = ERROR; Q26.times = ERROR; Q26.remainder = ERROR; Q26.gt = ERROR; Q26.lt = ERROR; Q26.not = ERROR;
		Q26.left_paren = ERROR; Q26.right_paren = ERROR; Q26.left_curly = ERROR; Q26.rigth_curly = ERROR; Q26.left_square = ERROR; Q26.right_square = ERROR; 
		Q26.terminator = ERROR; Q26.tab = ERROR; Q26.space = ERROR;

        Q27.plus = ERROR; Q27.minus = ERROR; Q27.underbar = ERROR; Q27.id_char = ERROR; Q27.zeroTo9 = ERROR; Q27.assign = ERROR; Q27.or = ERROR; Q27.and = Q24;
		Q27.double_quotes = ERROR; Q27.E = ERROR; Q27.dot = ERROR; Q27.times = ERROR; Q27.remainder = ERROR; Q27.gt = ERROR; Q27.lt = ERROR; Q27.not = ERROR;
		Q27.left_paren = ERROR; Q27.right_paren = ERROR; Q27.left_curly = ERROR; Q27.rigth_curly = ERROR; Q27.left_square = ERROR; Q27.right_square = ERROR; 
		Q27.terminator = ERROR; Q27.tab = ERROR; Q27.space = ERROR;

        Q28.plus = ERROR; Q28.minus = ERROR; Q28.underbar = ERROR; Q28.id_char = ERROR; Q28.zeroTo9 = ERROR; Q28.assign = ERROR; Q28.or = ERROR; Q28.and = Q24;
		Q28.double_quotes = ERROR; Q28.E = ERROR; Q28.dot = ERROR; Q28.times = ERROR; Q28.remainder = ERROR; Q28.gt = ERROR; Q28.lt = ERROR; Q28.not = ERROR;
		Q28.left_paren = ERROR; Q28.right_paren = ERROR; Q28.left_curly = ERROR; Q28.rigth_curly = ERROR; Q28.left_square = ERROR; Q28.right_square = ERROR; 
		Q28.terminator = ERROR; Q28.tab = ERROR; Q28.space = ERROR;

        Q29.plus = ERROR; Q29.minus = ERROR; Q29.underbar = ERROR; Q29.id_char = ERROR; Q29.zeroTo9 = ERROR; Q29.assign = Q35; Q29.or = ERROR; Q29.and = Q24;
		Q29.double_quotes = ERROR; Q29.E = ERROR; Q29.dot = ERROR; Q29.times = ERROR; Q29.remainder = ERROR; Q29.gt = ERROR; Q29.lt = ERROR; Q29.not = ERROR;
		Q29.left_paren = ERROR; Q29.right_paren = ERROR; Q29.left_curly = ERROR; Q29.rigth_curly = ERROR; Q29.left_square = ERROR; Q29.right_square = ERROR; 
		Q29.terminator = ERROR; Q29.tab = ERROR; Q29.space = ERROR;

        Q30.plus = ERROR; Q30.minus = ERROR; Q30.underbar = ERROR; Q30.id_char = ERROR; Q30.zeroTo9 = ERROR; Q30.assign = ERROR; Q30.or = ERROR; Q30.and = Q24;
		Q30.double_quotes = ERROR; Q30.E = ERROR; Q30.dot = ERROR; Q30.times = ERROR; Q30.remainder = ERROR; Q30.gt = ERROR; Q30.lt = ERROR; Q30.not = ERROR;
		Q30.left_paren = ERROR; Q30.right_paren = ERROR; Q30.left_curly = ERROR; Q30.rigth_curly = ERROR; Q30.left_square = ERROR; Q30.right_square = ERROR; 
		Q30.terminator = ERROR; Q30.tab = ERROR; Q30.space = ERROR;

        Q31.plus = ERROR; Q31.minus = ERROR; Q31.underbar = ERROR; Q31.id_char = ERROR; Q31.zeroTo9 = ERROR; Q31.assign = ERROR; Q31.or = ERROR; Q31.and = Q24;
		Q31.double_quotes = ERROR; Q31.E = ERROR; Q31.dot = ERROR; Q31.times = ERROR; Q31.remainder = ERROR; Q31.gt = ERROR; Q31.lt = ERROR; Q31.not = ERROR;
		Q31.left_paren = ERROR; Q31.right_paren = ERROR; Q31.left_curly = ERROR; Q31.rigth_curly = ERROR; Q31.left_square = ERROR; Q31.right_square = ERROR; 
		Q31.terminator = ERROR; Q31.tab = ERROR; Q31.space = ERROR;

        Q32.plus = ERROR; Q32.minus = ERROR; Q32.underbar = ERROR; Q32.id_char = ERROR; Q32.zeroTo9 = ERROR; Q32.assign = ERROR; Q32.or = ERROR; Q32.and = Q24;
		Q32.double_quotes = ERROR; Q32.E = ERROR; Q32.dot = ERROR; Q32.times = ERROR; Q32.remainder = ERROR; Q32.gt = ERROR; Q32.lt = ERROR; Q32.not = ERROR;
		Q32.left_paren = ERROR; Q32.right_paren = ERROR; Q32.left_curly = ERROR; Q32.rigth_curly = ERROR; Q32.left_square = ERROR; Q32.right_square = ERROR; 
		Q32.terminator = ERROR; Q32.tab = ERROR; Q32.space = ERROR;

        Q33.plus = ERROR; Q33.minus = ERROR; Q33.underbar = ERROR; Q33.id_char = ERROR; Q33.zeroTo9 = ERROR; Q33.assign = ERROR; Q33.or = ERROR; Q33.and = Q24;
		Q33.double_quotes = ERROR; Q33.E = ERROR; Q33.dot = ERROR; Q33.times = ERROR; Q33.remainder = ERROR; Q33.gt = ERROR; Q33.lt = ERROR; Q33.not = ERROR;
		Q33.left_paren = ERROR; Q33.right_paren = ERROR; Q33.left_curly = ERROR; Q33.rigth_curly = ERROR; Q33.left_square = ERROR; Q33.right_square = ERROR; 
		Q33.terminator = ERROR; Q33.tab = ERROR; Q33.space = ERROR;

        Q34.plus = ERROR; Q34.minus = ERROR; Q34.underbar = ERROR; Q34.id_char = ERROR; Q34.zeroTo9 = ERROR; Q34.assign = ERROR; Q34.or = ERROR; Q34.and = Q24;
		Q34.double_quotes = ERROR; Q34.E = ERROR; Q34.dot = ERROR; Q34.times = ERROR; Q34.remainder = ERROR; Q34.gt = ERROR; Q34.lt = ERROR; Q34.not = ERROR;
		Q34.left_paren = ERROR; Q34.right_paren = ERROR; Q34.left_curly = ERROR; Q34.rigth_curly = ERROR; Q34.left_square = ERROR; Q34.right_square = ERROR; 
		Q34.terminator = ERROR; Q34.tab = ERROR; Q34.space = ERROR;

        Q35.plus = ERROR; Q35.minus = ERROR; Q35.underbar = ERROR; Q35.id_char = ERROR; Q35.zeroTo9 = ERROR; Q35.assign = ERROR; Q35.or = ERROR; Q35.and = Q24;
		Q35.double_quotes = ERROR; Q35.E = ERROR; Q35.dot = ERROR; Q35.times = ERROR; Q35.remainder = ERROR; Q35.gt = ERROR; Q35.lt = ERROR; Q35.not = ERROR;
		Q35.left_paren = ERROR; Q35.right_paren = ERROR; Q35.left_curly = ERROR; Q35.rigth_curly = ERROR; Q35.left_square = ERROR; Q35.right_square = ERROR; 
		Q35.terminator = ERROR; Q35.tab = ERROR; Q35.space = ERROR;

        Q36.plus = ERROR; Q36.minus = ERROR; Q36.underbar = ERROR; Q36.id_char = ERROR; Q36.zeroTo9 = ERROR; Q36.assign = ERROR; Q36.or = ERROR; Q36.and = Q24;
		Q36.double_quotes = ERROR; Q36.E = ERROR; Q36.dot = ERROR; Q36.times = ERROR; Q36.remainder = ERROR; Q36.gt = ERROR; Q36.lt = ERROR; Q36.not = ERROR;
		Q36.left_paren = ERROR; Q36.right_paren = ERROR; Q36.left_curly = ERROR; Q36.rigth_curly = ERROR; Q36.left_square = ERROR; Q36.right_square = ERROR; 
		Q36.terminator = ERROR; Q36.tab = ERROR; Q36.space = ERROR;

        Q37.plus = ERROR; Q37.minus = ERROR; Q37.underbar = ERROR; Q37.id_char = ERROR; Q37.zeroTo9 = ERROR; Q37.assign = ERROR; Q37.or = ERROR; Q37.and = Q24;
		Q37.double_quotes = ERROR; Q37.E = ERROR; Q37.dot = ERROR; Q37.times = ERROR; Q37.remainder = ERROR; Q37.gt = ERROR; Q37.lt = ERROR; Q37.not = ERROR;
		Q37.left_paren = ERROR; Q37.right_paren = ERROR; Q37.left_curly = ERROR; Q37.rigth_curly = ERROR; Q37.left_square = ERROR; Q37.right_square = ERROR; 
		Q37.terminator = ERROR; Q37.tab = ERROR; Q37.space = ERROR;

        Q38.plus = ERROR; Q38.minus = ERROR; Q38.underbar = ERROR; Q38.id_char = ERROR; Q38.zeroTo9 = ERROR; Q38.assign = ERROR; Q38.or = ERROR; Q38.and = Q24;
		Q38.double_quotes = ERROR; Q38.E = ERROR; Q38.dot = ERROR; Q38.times = ERROR; Q38.remainder = ERROR; Q38.gt = ERROR; Q38.lt = ERROR; Q38.not = ERROR;
		Q38.left_paren = ERROR; Q38.right_paren = ERROR; Q38.left_curly = ERROR; Q38.rigth_curly = ERROR; Q38.left_square = ERROR; Q38.right_square = ERROR; 
		Q38.terminator = ERROR; Q38.tab = ERROR; Q38.space = ERROR;

        Q39.plus = ERROR; Q39.minus = ERROR; Q39.underbar = ERROR; Q39.id_char = ERROR; Q39.zeroTo9 = ERROR; Q39.assign = ERROR; Q39.or = ERROR; Q39.and = Q24;
		Q39.double_quotes = ERROR; Q39.E = ERROR; Q39.dot = ERROR; Q39.times = ERROR; Q39.remainder = ERROR; Q39.gt = ERROR; Q39.lt = ERROR; Q39.not = ERROR;
		Q39.left_paren = ERROR; Q39.right_paren = ERROR; Q39.left_curly = ERROR; Q39.rigth_curly = ERROR; Q39.left_square = ERROR; Q39.right_square = ERROR; 
		Q39.terminator = ERROR; Q39.tab = ERROR; Q39.space = ERROR;

        Q40.plus = ERROR; Q40.minus = ERROR; Q40.underbar = ERROR; Q40.id_char = ERROR; Q40.zeroTo9 = ERROR; Q40.assign = ERROR; Q40.or = ERROR; Q40.and = Q24;
		Q40.double_quotes = ERROR; Q40.E = ERROR; Q40.dot = ERROR; Q40.times = ERROR; Q40.remainder = ERROR; Q40.gt = ERROR; Q40.lt = ERROR; Q40.not = ERROR;
		Q40.left_paren = ERROR; Q40.right_paren = ERROR; Q40.left_curly = ERROR; Q40.rigth_curly = ERROR; Q40.left_square = ERROR; Q40.right_square = ERROR; 
		Q40.terminator = ERROR; Q40.tab = ERROR; Q40.space = ERROR;

        Q41.plus = ERROR; Q41.minus = ERROR; Q41.underbar = ERROR; Q41.id_char = ERROR; Q41.zeroTo9 = ERROR; Q41.assign = ERROR; Q41.or = ERROR; Q41.and = Q24;
		Q41.double_quotes = ERROR; Q41.E = ERROR; Q41.dot = ERROR; Q41.times = ERROR; Q41.remainder = ERROR; Q41.gt = ERROR; Q41.lt = ERROR; Q41.not = ERROR;
		Q41.left_paren = ERROR; Q41.right_paren = ERROR; Q41.left_curly = ERROR; Q41.rigth_curly = ERROR; Q41.left_square = ERROR; Q41.right_square = ERROR; 
		Q41.terminator = ERROR; Q41.tab = ERROR; Q41.space = ERROR;

        Q42.plus = ERROR; Q42.minus = ERROR; Q42.underbar = ERROR; Q42.id_char = ERROR; Q42.zeroTo9 = ERROR; Q42.assign = ERROR; Q42.or = ERROR; Q42.and = Q24;
		Q42.double_quotes = ERROR; Q42.E = ERROR; Q42.dot = ERROR; Q42.times = ERROR; Q42.remainder = ERROR; Q42.gt = ERROR; Q42.lt = ERROR; Q42.not = ERROR;
		Q42.left_paren = ERROR; Q42.right_paren = ERROR; Q42.left_curly = ERROR; Q42.rigth_curly = ERROR; Q42.left_square = ERROR; Q42.right_square = ERROR; 
		Q42.terminator = ERROR; Q42.tab = ERROR; Q42.space = ERROR;

        Q43.plus = ERROR; Q43.minus = ERROR; Q43.underbar = ERROR; Q43.id_char = ERROR; Q43.zeroTo9 = ERROR; Q43.assign = ERROR; Q43.or = ERROR; Q43.and = Q24;
		Q43.double_quotes = ERROR; Q43.E = ERROR; Q43.dot = ERROR; Q43.times = ERROR; Q43.remainder = ERROR; Q43.gt = ERROR; Q43.lt = ERROR; Q43.not = ERROR;
		Q43.left_paren = ERROR; Q43.right_paren = ERROR; Q43.left_curly = ERROR; Q43.rigth_curly = ERROR; Q43.left_square = ERROR; Q43.right_square = ERROR; 
		Q43.terminator = ERROR; Q43.tab = ERROR; Q43.space = ERROR;

        Q44.plus = ERROR; Q44.minus = ERROR; Q44.underbar = ERROR; Q44.id_char = ERROR; Q44.zeroTo9 = ERROR; Q44.assign = ERROR; Q44.or = ERROR; Q44.and = Q24;
		Q44.double_quotes = ERROR; Q44.E = ERROR; Q44.dot = ERROR; Q44.times = ERROR; Q44.remainder = ERROR; Q44.gt = ERROR; Q44.lt = ERROR; Q44.not = ERROR;
		Q44.left_paren = ERROR; Q44.right_paren = ERROR; Q44.left_curly = ERROR; Q44.rigth_curly = ERROR; Q44.left_square = ERROR; Q44.right_square = ERROR; 
		Q44.terminator = ERROR; Q44.tab = ERROR; Q44.space = ERROR;

        Q45.plus = ERROR; Q45.minus = ERROR; Q45.underbar = ERROR; Q45.id_char = ERROR; Q45.zeroTo9 = ERROR; Q45.assign = ERROR; Q45.or = ERROR; Q45.and = Q24;
		Q45.double_quotes = ERROR; Q45.E = ERROR; Q45.dot = ERROR; Q45.times = ERROR; Q45.remainder = ERROR; Q45.gt = ERROR; Q45.lt = ERROR; Q45.not = ERROR;
		Q45.left_paren = ERROR; Q45.right_paren = ERROR; Q45.left_curly = ERROR; Q45.rigth_curly = ERROR; Q45.left_square = ERROR; Q45.right_square = ERROR; 
		Q45.terminator = ERROR; Q45.tab = ERROR; Q45.space = ERROR;
		
		
	}
	
	private boolean accept;
	private Token.TokenType type;
	
	States(boolean accept, Token.TokenType type) {
		this.accept = accept;
		this.type = type;
	}
	
	public States transition(char ch) {
		switch(ch) {
			case '+':
				return this.plus;
			case '-':
				return this.minus;
			case '_':
				return this.underbar;
			case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
	    	  case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p': 
	    	  case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x': case 'y': case 'z':
	    	  case 'A': case 'B': case 'C': case 'D': case 'F': case 'G': case 'H': 
	    	  case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': 
	    	  case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': case 'Z':
	    	  case '$':
	    		  return this.id_char;
	    	case '0': case '1': case '2': case '3': case '4': 
	    		case '5': case '6': case '7': case '8': case '9':
	    			return this.zeroTo9;
    		case '=':
    			return this.assign;
    		case '|':
    			return this.or;
    		case '&':
    			return this.and;
    		case '"':
    			return this.double_quotes;
    		case 'E':
    			return this.E;
    		case '.':
    			return this.dot;
    		case '*':
    			return this.times;
    		case '%':
    			return this.remainder;
    		case '>':
    			return this.gt;
    		case '<':
    			return this.lt;
    		case '!':
    			return this.not;
    		case '(':
    			return this.left_paren;
    		case ')':
    			return this.right_paren;
    		case '{':
    			return this.left_curly;
    		case '}':
    			return this.rigth_curly;
    		case '[':
    			return this.left_square;
    		case ']':
    			return this.right_square;
    		case ';':
    			return this.terminator;
    		case ' ':
    			return this.space;
    		case '\t':
    			return this.tab;
    		case '\n':
    			return this.new_line;
    		case '/':
    			return this.divide;
    		default:
    			return null;
		}
		
	}
	
	public boolean isAccept() {
		return accept;
	}
	
	public Token.TokenType getTokenType() {
		return type;
	}
}