import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TokenWriter {
	String path = "scanner_result/";
	String fileName;
	
	public TokenWriter() {
		// When there is not dir, make it
		File dir = new File(path);
		
		if (!dir.exists()) {
			try {
				dir.mkdir();
				} 
		        catch(Exception e){
			    e.getStackTrace();
			}
		}
		
		this.path += "result.txt";
	}
	
	public TokenWriter(String fileName) {
		// When there is not dir, make it
		File dir = new File(path);
		
		if (!dir.exists()) {
			try {
				dir.mkdir();
				} 
		        catch(Exception e){
			    e.getStackTrace();
			}
		}
		
		this.fileName = fileName;
		this.path += fileName.split("\\.")[0] + "_result.txt";
	}
	
	public void run(AnalyzedTokenList tokenList) {
		File file = new File(path);
		FileWriter fw = null;
		
		try {
            fw = new FileWriter(file, false);
	    	for (Token token : tokenList)
	        	fw.write(token.toString() + "\n");
            
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw != null) fw.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
	}
}
