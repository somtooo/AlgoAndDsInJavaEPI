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















  //7/14/2021
  public static int[] solution2(int[] arr, int pivot) {
    if (pivot != 0) {
      var temp = arr[0];
      arr[0] = arr[pivot];
      arr[pivot] = temp;
    }
    System.out.println(Arrays.toString(arr));

    return pivot(arr);

  }

  private static int[] pivot(int[] arr) {
    var pivot = arr[0];
    var numOfLessThan = 0;
    var swapIndex = 1;
    for (int i = 1; i < arr.length ; i++) {
      if (arr[i] < pivot) {
        var temp = arr[swapIndex];
        arr[swapIndex] = arr[i];
        arr[i] = temp;
        swapIndex++;
        numOfLessThan++;
      }
    }
    var temp = arr[numOfLessThan];
    arr[numOfLessThan] = arr[0];
    arr[0] = temp;

    for (int i = numOfLessThan + 1; i < arr.length ; i++) {
      if (arr[i] == pivot) {
        var i1 = arr[swapIndex];
        arr[swapIndex] = arr[i];
        arr[i] = i1;
        swapIndex++;
      }
    }
    return arr;
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
    System.out.println(Arrays.toString(DutchNationalFlag.solution2(A, 2)));
    System.out.println(Score.scoreSolution(4,4,4,4));
//    System.out.println(Arrays.toString(answer));
//    System.out.println(Score.scoreSolution(1,2,3,2));
  }
}
