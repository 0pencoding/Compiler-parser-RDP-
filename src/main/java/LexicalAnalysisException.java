@SuppressWarnings("serial")

public class LexicalAnalysisException extends Exception {
	private int errorPosition; // 오류가 발생한 위치 (line)
	private String fileName; // 오류 프로젝트
	private String errorToken; // 오류 token
	private char errorChar; // 오류 character
	
	public enum LexicalErrorCode {
		WRONG_INPUT, ILLEGAL_CODE, ILLEGAL_TOKEN;
	}
	
	public LexicalAnalysisException(int errorPosition, String fileName, String errorToken) {
		this.errorPosition = errorPosition;
		this.fileName = fileName;
		this.errorToken = errorToken;
	}
	
	public LexicalAnalysisException(int errorPosition, String fileName, char errorChar) {
		this.errorPosition = errorPosition;
		this.fileName = fileName;
		this.errorChar = errorChar;
	}

	public int getErrorPosition() {
		return errorPosition;
	}
	
	public String getMessage(LexicalErrorCode code) {
		String msg = "exception.LexicalAnalysisException:";
		
		switch(code) {
			case WRONG_INPUT:
				return msg + "\n\tThere is wrong input \'" + errorChar + "\', Please check it.";
			case ILLEGAL_CODE:
				return msg + "\n\tToken is null by illegal code \'" + errorChar + "\' (" + fileName + ":" + errorPosition + ")";
			case ILLEGAL_TOKEN:
				return msg + "\n\tToken is illegal \'" + errorToken + "\' (" + fileName + ":" + errorPosition + ")";
			default:
				return msg + "\n\tAn error occurred with no explanation \'" + fileName + ":" + errorPosition + "\')";
		}
	}
}
