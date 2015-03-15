import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            line = line.replace(" ", "");
            System.out.println(line + "      --");
            String[] splitLine = line.split(";");
            String LCS = "";
            int[][] table = new int[splitLine[0].length()+1][splitLine[1].length()+1];
            for(int i = 0; i < table.length; i++) {
            	for(int x = 0; x < table[i].length; x++) {
            		if(i == 0 || x == 0) {
            			table[i][x] = 0;
            		}
            		else if(splitLine[0].charAt(i-1) == splitLine[1].charAt(x-1)) {
            			table[i][x] = table[i-1][x-1] + 1;
            		}
            		else {
            			table[i][x] = Math.max(table[i][x-1], table[i-1][x]);
            		}
            	}
            }
            int y = table.length-1;
            int z = table[0].length-1;
            while(y != 0) {
            	while(z != 0) {
            		if(y == 0 || z == 0) {
            			LCS += "";
            		}
            		else if(splitLine[0].charAt(y-1) == splitLine[1].charAt(z-1)) {
            			LCS = splitLine[0].charAt(y-1) + LCS;
            			y--;
            			z--;
            		}
            		else {
            			if(table[y][z-1] > table[y-1][z]) {
            				z--;
            			}
            			else {
            				y--;
            			}
            		}
                	if(y == 0) {
                		z = 0;
                	}
            	}
            	if(z == 0) {
            		y = 0;
            	}
            }
            System.out.print(LCS + "\n");
        }
    }
}