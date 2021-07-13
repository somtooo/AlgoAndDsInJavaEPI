package arraysandstring;

import scoring.Score;

import java.util.HashSet;

public class SudokuChecker {
  public static boolean solution(int[][] arr) {
    for (int i = 0; i < 3 ; i++) {
      for (int j = 0; j <3; j++) {
        var set = new HashSet<Integer>();


        int k = 3 * i +3;
        int p = 3 * j + 3;

        for (int l = k -3; l < k ; l++) {
          for (int m = p -3; m < p ; m++) {
            if (set.contains(arr[l][m])) {
              return false;
            }

            set.add(arr[l][m]);
          }
        }
        //
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[][] array = {
        {0, 1, 2, 3, 4, 5, 6, 7, 8},
        {9, 10, 11, 12, 13, 14, 15, 16, 17},
        {18, 19, 20, 21, 22, 23, 24, 25, 26},
        {27, 28, 29, 30, 31, 32, 33, 34, 35},
        {36, 37, 38, 39, 40, 41, 42, 43, 44},
        {45, 46, 47, 48, 49, 50, 51, 52, 53},
        {54, 55, 56, 57, 58, 59, 60, 61, 62},
        {63, 64, 65, 66, 67, 68, 69, 70, 71},
        {72, 73, 74, 75, 76, 77, 78, 79, 0}
    };
    System.out.println(solution(array));
    System.out.println(Score.scoreSolution(2,4,2,3));
  }
}
