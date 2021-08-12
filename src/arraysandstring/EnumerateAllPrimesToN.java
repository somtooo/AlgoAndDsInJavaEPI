package arraysandstring;

import scoring.Score;

import java.util.ArrayList;
import java.util.Arrays;
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
    solution2(18);
//    System.out.println(Score.scoreSolution(3,1,2,2));
  }


  public static void solution2(int number) {
    //previous solution gave On^3/2 need to go faster
    //number is 10
    var candidates = new boolean[number+1];
    var ans = new ArrayList<Integer>();
    Arrays.fill(candidates,Boolean.TRUE);
    candidates[0] = false;
    candidates[1] = false;

    for (int i = 2; i < candidates.length ; i++) {
      if (candidates[i]) {
        ans.add(i);
        for (int j = i; j < candidates.length; j+=i) {
          candidates[j] = false;
        }
      }

    }
    System.out.println(ans);
  }
}
