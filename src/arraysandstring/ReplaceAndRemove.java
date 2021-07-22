package arraysandstring;

import scoring.Score;

import java.util.ArrayList;
import java.util.List;

public class ReplaceAndRemove {

  public static List<Character> solution(Character[] arr, int size ) {
    var ans = new ArrayList<Character>();
    int operationCount = 0;

    for(Character value : arr) {
      if (operationCount == size) {
        break;
      }
      if (value == 'a') {
        operationCount++;
        addTwoD(ans);
        continue;
      }
      if (value == 'b') {
        operationCount++;
        continue;
      }

      ans.add(value);
    }

    return ans;
  }

  private static void addTwoD(ArrayList<Character> ans) {
    ans.add('d');
    ans.add('d');
  }

  public static void main(String[] args) {
    var arr = new Character[]{'a','c','d','b','b','c','a'};
    System.out.println(solution(arr,4));
    System.out.println(Score.scoreSolution(4,4,3,3));
  }
}
