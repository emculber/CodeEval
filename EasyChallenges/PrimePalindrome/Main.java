import java.lang.Math;
public class Main {
  public static void main(String[] args) {
    for(int i = 999; i > 1; i-=2) {
      if(isPalindrome(i)) {
        if(isPrime(i)) {
          System.out.print(i + "\n");
          break;
        }
      }
    }
  }
  private static boolean isPrime(int n) {
    if(n%2 == 0) {
      return false;
    }
    for(int i=3; i < Math.sqrt(n); i += 2) {
      if(n%i == 0) {
        return false;
      }
    }
    return true;
  }
  private static boolean isPalindrome(int n) {
    String number = Integer.toString(n);
    if(number.equals(new StringBuilder(number).reverse().toString())) {
      return true;
    }
    return false;
  }
}
