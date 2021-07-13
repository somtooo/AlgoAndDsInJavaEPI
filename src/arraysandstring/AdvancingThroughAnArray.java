package arraysandstring;

import scoring.Score;

public class AdvancingThroughAnArray {
  public static boolean solution(int[] arr, int pos) {
    int k = pos;
    if (arr[pos] == 0) {
      return false;
    }
    if (pos == arr.length-1) {
      return true;
    }

    for (int i = 0; i < arr[pos]; i++) {
      k = k + 1;
      var ans =  solution(arr,k);
      if (ans) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    var arr = new int[]{3,3,1,0, 2,0,1};
    System.out.println(solution(arr,0));
    System.out.println(Score.scoreSolution(2,4,3,3));
  }
}
