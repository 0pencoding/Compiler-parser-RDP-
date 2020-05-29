import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SourceReader {
	public String run(String path) {
		StringBuffer sb = new StringBuffer();
		List<String> lines = null;
		
		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return "";
		}
		
		for(String line: lines)
            sb.append(line + "\n");
        
		return sb.toString();
	}
}
