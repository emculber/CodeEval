import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
        	ArrayList<Integer> pattern = new ArrayList<Integer>();
            line = line.trim();
        	String[] splitLine = line.split(" ");
            boolean setPattern = false;
            boolean foundPattern = false;
            int beginPattern = 0;
            int globalBeginPattern = 0;
            for(int i = 0; i < splitLine.length; i++) {
            	int current = Integer.parseInt(splitLine[i]);
            	for(int x = 0; x < pattern.size(); x++) {
            		if(current == pattern.get(x)) {
            			globalBeginPattern = beginPattern = x;
                		setPattern = true;
            			break;
            		}
            	}
            	while(beginPattern != 0) {
            		pattern.remove(0);
            		beginPattern--;
            	}
            	if(!setPattern) {
            		pattern.add(Integer.parseInt(splitLine[i]));
            	}
            	if(setPattern) {
            		boolean removeRest = false;
            		for(int x = 0; x < pattern.size(); x++) {
            			if(removeRest) {
            				pattern.remove(x);
            			}
            			else if(pattern.get(x) != Integer.parseInt(splitLine[globalBeginPattern + pattern.size() + x])) {
                			pattern.remove(x);
                		}
                	}
            		foundPattern = true;
            	}
            	if(foundPattern) {
            		for(int x = 0; x < pattern.size(); x++) {
                		System.out.print(pattern.get(x));
                		if(x != pattern.size()-1) {
                    		System.out.print(" ");
                		}
                	}
            		System.out.print("\n");
            		break;
            	}
            }
        }
    }
}
