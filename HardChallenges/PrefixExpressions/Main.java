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
            	double num = 0;
            	if(current.equals("+")) {
            		num = Double.parseDouble(prefixNotation.pop());
            		num += Double.parseDouble(prefixNotation.pop());
            		prefixNotation.push(Double.toString(num));
            	}
            	else if(current.equals("*")) {
            		num = Double.parseDouble(prefixNotation.pop());
            		num *= Double.parseDouble(prefixNotation.pop());
            		prefixNotation.push(Double.toString(num));
            	}
            	else if(current.equals("/")) {
            		num = Double.parseDouble(prefixNotation.pop());
            		num /= Double.parseDouble(prefixNotation.pop());
            		prefixNotation.push(Double.toString(num));
            	}
            	else if(current.equals("-")) {
            		num = Double.parseDouble(prefixNotation.pop());
            		num -= Double.parseDouble(prefixNotation.pop());
            		prefixNotation.push(Double.toString(num));
            	}
            	else {
            		prefixNotation.push(current);
            	}
            }
            System.out.print((int)Math.round(Double.parseDouble(prefixNotation.pop())) + "\n");
        }
    }
}