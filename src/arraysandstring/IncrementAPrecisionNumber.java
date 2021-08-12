package arraysandstring;

import scoring.Score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    int[] arr = {9,9,9};
    var add = new IncrementAPrecisionNumber();
    System.out.println(Arrays.toString(add.solution(arr)));
    var l = new ArrayList<Integer>();
    l.add(9);
    l.add(9);
    l.add(9);
    System.out.println(solution2(l));

    
    System.out.println(Score.scoreSolution(3,4,2,3));
  }



  //7/30/2021 fixed overflow issue
  public static List<Integer> solution2(List<Integer> number) {
    int carry = 1;
    for (int i = number.size()-1; i >= 0 ; i--) {
      var value = number.get(i) + carry;
      var rem = value %10;
      carry = value /10;
      number.set(i, rem);
    }
    if (carry != 0) {
      number.add(0,carry);
    }
    return number;

  }
}
