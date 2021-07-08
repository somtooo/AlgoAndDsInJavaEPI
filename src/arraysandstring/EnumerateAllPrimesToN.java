package arraysandstring;

import java.util.ArrayList;
import java.util.List;

public class EnumerateAllPrimesToN {

  public List<Integer> solution(int number) {
    var arr = new ArrayList<Integer>();
    for (int i = 2; i <number; i++) {
      if (isPrime(i)) {
        arr.add(i);
      }
    }

    return arr;
  }

  public boolean isPrime(int number) {
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number%i == 0) {
        return false;
      }
    }
    return true;
  }

  //solved in 22min
  public static void main(String[] args) {
    var sol = new EnumerateAllPrimesToN();
    System.out.println(sol.solution(18));
  }
}
