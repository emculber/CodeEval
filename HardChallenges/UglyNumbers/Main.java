import java.io.*;
import java.lang.Math;
import java.util.LinkedList;

public class Main {
  public static void main (String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader buffer = new BufferedReader(new FileReader(file));
    String line;
    while ((line = buffer.readLine()) != null) {
      line = line.trim();
      String testNumber = line;
      int count = 0;
      int[] iteration = new int[testNumber.length() - 1];
      LinkedList<String> linkedList = new LinkedList<String>();

      for(int i = 0; i < Math.pow(3, testNumber.length() - 1); i++) {
        String rollOver = "";
        for(int x = 0; x < iteration.length; x++) {
          if(iteration[x] == 3) {
            iteration[x] = 0;
            if((x+1) != iteration.length) {
              iteration[x+1]++;
            }
          }

          char current = testNumber.charAt(x);
          if(iteration[x] == 0) {
            rollOver += current;
          }
          else if(iteration[x] == 1) {
            linkedList.add(rollOver + current);
            linkedList.add("+");
            rollOver = "";
          }
          else if(iteration[x] == 2) {
            linkedList.add(rollOver + current);
            linkedList.add("-");
            rollOver = "";
          }
        }
        rollOver += testNumber.charAt(testNumber.length() - 1);
        if(!rollOver.equals("")) {
          linkedList.add(rollOver);
          rollOver = "";
        }
        if(iteration.length != 0) {
          iteration[0]++;
        }

        long finalNum = Long.parseLong(linkedList.poll());
        String arg = "";
        long num2 = 0;
        while(!linkedList.isEmpty()) {
          arg = linkedList.poll();
          num2 = Long.parseLong(linkedList.poll());
          if(arg.equals("+")) {
            finalNum += num2;
          }
          if(arg.equals("-")) {
            finalNum -= num2;
          }
        }
        if(finalNum%2==0 || finalNum%3== 0 || finalNum%5==0 || finalNum%7==0) {
          count++;
        }
      }
      System.out.println("" + count);
    }
  }
}
