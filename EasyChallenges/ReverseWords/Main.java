import java.io.*;

public class Main {
  public static void main (String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader buffer = new BufferedReader(new FileReader(file));
    String line;
    while ((line = buffer.readLine()) != null) {
      line = line.trim();
      String[] splitSen = line.split(" ");
      for(int i = splitSen.length - 1; i > 0; i--) {
        System.out.print(splitSen[i] + " ");
      }
      System.out.print(splitSen[0] + "\n");
    }
  }
}
