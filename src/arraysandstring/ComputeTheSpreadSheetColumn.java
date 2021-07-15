package arraysandstring;

import scoring.Score;

import java.util.HashMap;

public class ComputeTheSpreadSheetColumn {
  // formula is alphabetNumber x 26^index.

  public static int solution(String encoding) {
    var map = new HashMap<Character, Integer>();
    int value = 1;
    int ans = 0;
    for (char ch = 'A'; ch <= 'Z'; ++ch) {
      map.put(ch, value);
      value++;
    }

    var reversed = new StringBuilder().append(encoding).reverse();

    for(int i=0; i < reversed.length(); i++) {
      ans = (int) (ans + (map.get(reversed.charAt(i)) * Math.pow(26, i)));
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(solution("XS"));
    System.out.println(Score.scoreSolution(1,5,4,4));
  }
}
