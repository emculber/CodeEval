import java.io.*;
public class Main {
  public static void main (String[] args) throws IOException {
    int x = 0;
    int y = 0;
    int n = 0;
    File file = new File(args[0]);
    BufferedReader buffer = new BufferedReader(new FileReader(file));
    String line;
    while ((line = buffer.readLine()) != null) {
      line = line.trim();

      String[] splitLine = line.split(" ");
      x = Integer.parseInt(splitLine[0]);
      y = Integer.parseInt(splitLine[1]);
      n = Integer.parseInt(splitLine[2]);

      for(int i = 1; i <= n; i++) {
        if(i % x == 0 && i % y == 0)
          System.out.print("FB ");
        else if(i % x == 0)
          System.out.print("F ");
        else if(i % y == 0)
          System.out.print("B ");
        else
          System.out.print(i+" ");
      }
      System.out.print("\n");
    }
  }
}
