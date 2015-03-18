import java.io.*;
public class Main {
  public static void main (String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader buffer = new BufferedReader(new FileReader(file));
    String line;
    while ((line = buffer.readLine()) != null) {
      line = line.trim();
      System.out.print(line + "   ----");
      String[] splitLine = line.split(",");
      int x = Integer.parseInt(splitLine[0]);
      int n = Integer.parseInt(splitLine[1]);
      while(n < x) {
        n = n<<1;
      }
      System.out.println(n);
    }
  }
}
