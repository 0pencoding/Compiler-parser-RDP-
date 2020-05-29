public enum KeywordTable {
	// Keywords
	IF("if"), ELSE_IF("else if"), ELSE("else"), FOR("for"), WHILE("while"), // Control keyword
	CLASS("class"), INT("int"), MAIN("main"),// Data type
	OUT_PRINTLN("out.println"); // Special keyword
	
	final private String keyword;
	
	private KeywordTable(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return this.keyword;
	}
	
	public static KeywordTable find(String src) {
		for (KeywordTable keywordType : KeywordTable.values()) {
			if (src.startsWith(keywordType.getKeyword()))
				return keywordType;
		}

		return null;
	}
}
