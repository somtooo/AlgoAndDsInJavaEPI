package arraysandstring;

import java.util.Arrays;

public class PermuteElementsOfAnArray {
  public static String[] solution(String[] arr, int[]permutation ) {
    var finalArr = new String[arr.length];
    for (int i = 0; i <arr.length; i++) {
      var pIndex = permutation[i];

      finalArr[pIndex] = arr[i];
      //
    }
    return finalArr;
  }

  public static void main(String[] args) {
    var arr = new String[]{"a","b","c","d"};
    var pArr = new int[]{2,0,1,3};

    var ans = PermuteElementsOfAnArray.solution(arr,pArr);
    System.out.println(Arrays.toString(ans));
  }
}
