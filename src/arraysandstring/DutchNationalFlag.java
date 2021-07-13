package arraysandstring;

import scoring.Score;

import java.util.Arrays;

public  class  DutchNationalFlag {

  public int[] solveDutchNationalFlag(int[] A, int index) {
    int pivot = A[index];
    int[] store = new int[A.length];
    int lastIndex = 0;;
    for (int j : A) {
      if (j < pivot) {
        store[lastIndex] = j;
        lastIndex++;
      }
    }

    for (int j : A) {
      if (j == pivot) {
        store[lastIndex] = j;
        lastIndex++;
      }
    }

    for (int j : A) {
      if (j > pivot) {
        store[lastIndex] = j;
        lastIndex++;
      }
    }

    return store;
  }

  //solved in 32 min
  //did you need hints
  //optimal solutions
  //how many bugs
  public static void main(String[] args) {
    var d = new DutchNationalFlag();
    int[] A = {12,3,13,0,8,14,8,15,13};
    int index = 2;

    var answer = d.solveDutchNationalFlag(A, index);
    System.out.println(Arrays.toString(answer));
    System.out.println(Score.scoreSolution(1,2,3,2));
  }
}
