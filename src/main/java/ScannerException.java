@SuppressWarnings("serial")
public class ScannerException extends Exception {
	private String fileName; // 오류 프로젝트
	
	public enum ScannerErrorCode {
		NO_ARGUMENT, FILE_NOT_FOUND;
	}
	
	public ScannerException() {
		this.fileName = null;
	}

	public ScannerException(String fileName) {
		this.fileName = fileName;
	}
	
	public String getMessage(ScannerErrorCode code) {
		String msg = "exception.ScannerException:";
		
		switch(code) {
			case NO_ARGUMENT:
				return msg + "\n\tPlease enter the file path for scanner (into arg[0])";
			case FILE_NOT_FOUND:
				return msg + "\n\tFile not found: Please check the file" +  " \'" + fileName + "\'";
			default:
				return msg + "\n\tAn error occurred with no explanation";
		}
	}
}
