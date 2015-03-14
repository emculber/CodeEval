import java.io.*;
import java.util.Stack;

public class Main {
	
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] splitLine = line.split(" ");
            Stack<String> prefixNotation = new Stack<String>();
            
            for(int i = splitLine.length - 1; i > -1; i--) {
            	String current = splitLine[i];
            	int num = 0;
            	if(current.equals("+")) {
            		num = Integer.parseInt(prefixNotation.pop());
            		num += Integer.parseInt(prefixNotation.pop());
            		prefixNotation.push(Integer.toString(num));
            	}
            	else if(current.equals("*")) {
            		num = Integer.parseInt(prefixNotation.pop());
            		num *= Integer.parseInt(prefixNotation.pop());
            		prefixNotation.push(Integer.toString(num));
            	}
            	else if(current.equals("/")) {
            		num = Integer.parseInt(prefixNotation.pop());
            		num /= Integer.parseInt(prefixNotation.pop());
            		prefixNotation.push(Integer.toString(num));
            	}
            	else if(current.equals("-")) {
            		num = Integer.parseInt(prefixNotation.pop());
            		num -= Integer.parseInt(prefixNotation.pop());
            		prefixNotation.push(Integer.toString(num));
            	}
            	else {
            		prefixNotation.push(current);
            	}
            }
            System.out.println(prefixNotation.pop());
        }
    }
}