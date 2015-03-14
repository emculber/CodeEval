public class Main {
  public static void main(String[] args) {
    int primeCount = 0;
    int number = 0;
    int sum = 0;
    while(primeCount != 1000) {
      number++;
      if(isPrime(number)) {
        sum += number;
        primeCount++;
      }
    }
    System.out.println(sum + "");
  }
  public static boolean isPrime(long n) {
    if (n <= 3) {
      return n > 1;
    } else if (n % 2 == 0 || n % 3 == 0) {
      return false;
    } else {
      double sqrtN = Math.floor(Math.sqrt(n));
      for (int i = 5; i <= sqrtN; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) {
          return false;
        }
      }
      return true;
    }
  }
}
