package arraysandstring;

import scoring.Score;

import java.util.Arrays;

public class RotateA2DArray {
  public static int[][] solution(int[][]arr) {
    var returnedArr = new int[arr.length][arr[0].length];
    int k = returnedArr[0].length;
    for (int i = 0; i < arr.length ; i++) {
      k--;
      for (int j = 0; j <arr[0].length; j++) {
        returnedArr[j][k] = arr[i][j];
      }
    }
    return returnedArr;
  }

  public static void main(String[] args) {
    int[][] array = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16},
    };

    System.out.println(Arrays.deepToString(solution(array)));
    System.out.println(Score.scoreSolution(1,5,2,3));
  }
}
