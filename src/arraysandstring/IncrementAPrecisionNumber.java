package arraysandstring;

import scoring.Score;

import java.util.Arrays;

public class IncrementAPrecisionNumber {
  public int[] solution(int[] A) {
    int[] ans = new int[A.length];
    int carry = 1;
    for (int i = A.length - 1; i >= 0; i--) {
      var coef = carry + A[i];
      var rem = coef%10;
      carry = coef/10;
      ans[i] = rem;
    }

    return ans;
  }


  //Solved in 20min
  public static void main(String[] args) {
    int[] arr = {1,2,3};
    var add = new IncrementAPrecisionNumber();
    System.out.println(Arrays.toString(add.solution(arr)));
    
    System.out.println(Score.scoreSolution(3,4,2,3));
  }
}
