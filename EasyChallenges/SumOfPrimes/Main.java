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
    System.out.println("Sum : " + sum + " count : " + primeCount);
  }
  private static boolean isPrime(int n) {
    if(n%2 == 0) {
      return false;
    }
    for(int i=3; i < n; i += 2) {
      if(n%i == 0) {
        return false;
      }
    }
    return true;
  }
}
