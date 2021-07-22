package arraysandstring;

import scoring.Score;

import java.util.Arrays;

public class ReverseWords {

  public static String solution(String reverseMe) {
    var arr = reverseMe.split(" ");
    String ans = "";
    for (int i = arr.length - 1; i >= 0 ; i--) {
      ans = ans.concat(arr[i]).concat(" ");
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(solution("Alice likes Bob"));
    System.out.println(Score.scoreSolution(4,5,3,3));
  }
}
