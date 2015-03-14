import java.io.*;
import java.util.ArrayList;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> list = new ArrayList<String>();
        int listCount = -1;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(listCount == -1) {
            	listCount = Integer.parseInt(line);
            }
            boolean added = false;
            for(int i = 0; i < list.size(); i++) {
                if(line.length() > list.get(i).length()) {
                	list.add(i, line);
                	added = true;
                	break;
                }
            }
            if(!added) {
            	list.add(line);
            }
        }
        for(int i = 0; i < listCount; i++) {
        	System.out.println(list.get(i));
        }
    }
}