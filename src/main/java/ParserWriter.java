import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ParserWriter {
	String path = "parser_result/";
	String fileName;
	
	FileWriter fw;
	File file;
	
	public ParserWriter(String fileName) {
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
	
	public void init() {
		file = new File(path);
		fw = null;
		
        try {
			fw = new FileWriter(file, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void write(String str) {
		try {
			fw.write(str + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void close() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
