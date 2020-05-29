import java.util.ArrayList;

@SuppressWarnings("serial")
public class AnalyzedTokenList extends ArrayList<Token> {
	private int idx = 0;
	
	public Token.TokenType getCurrentType() {
		return this.get(idx).getTokenType();
	}
	
	public String getCurrentValue() {
		return this.get(idx).getValue();
	}
	
	public boolean next() {
		if (this.size() > idx + 1) {
			idx++;
			return true;
		} else return false;
	}
}
