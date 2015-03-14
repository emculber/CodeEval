import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(line.equals("")) {
            	continue;
            }
            line = line.replace(" ", "");
            String[] splitLine = line.split(";");
            
            int currentCheck = 0;
            int currentLength = 0;
            String subString = "";
            
            int finalLength = 0;
            String finalSubString = "";
            for(int i = 0; i < splitLine[0].length(); i++){
	            for(int y = i; y < splitLine[0].length(); y++) {
	            	for(int x = currentCheck; x < splitLine[1].length(); x++) {
	            		if(splitLine[0].charAt(y) == splitLine[1].charAt(x)) {
	            			currentCheck = x;
	            			subString += splitLine[0].charAt(y);
	            			currentLength++;
	            		}
	            	}
	            }
	            if(currentLength > finalLength) {
	            	finalSubString = subString;
	            	finalLength = currentLength;
	            }
	            currentCheck = 0;
	            currentLength = 0;
	            subString = "";
            }
            System.out.println(finalSubString);
        }
    }
}