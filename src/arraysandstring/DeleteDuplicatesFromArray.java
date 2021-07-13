package arraysandstring;

import scoring.Score;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class DeleteDuplicatesFromArray {

  public static int[] Solution(int[] arr) {
    var rArr = new int[arr.length];
    var set = new HashSet<Integer>();
    for (int j : arr) {
      set.add(j);
    }
    int i = 0;
    for (Integer keyValue : set ) {
      rArr[i] = keyValue;
      i++;
    }
    return rArr;
  }


  public static void main(String[] args) {
    var arr = new int[]{2,3,5,5,7,11,11,11,13};
    System.out.println(Arrays.toString(DeleteDuplicatesFromArray.Solution(arr)));
    System.out.println(Score.scoreSolution(3,4,3,3));
  }
}
