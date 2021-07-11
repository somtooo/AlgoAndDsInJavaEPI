package arraysandstring;

import scoring.Score;

import java.util.Arrays;

public class ComputeTheNextPermutation {
  public static int[] solution(int[] arr) {
    var inPlace = inPlaceIndex(arr);
    var nextPlace = inPlace+1;
    if (inPlace < 0) {
      return new int[1];
    }
    var inc = 1;
    var times = 0;
    var btw = ((arr.length) - (nextPlace+1) + 1);

    while (times < btw/2) {
      var temp = arr[nextPlace];
      arr[nextPlace] = arr[arr.length - inc];
      arr[arr.length - inc] = temp;
      nextPlace++;
      times++;
      inc++;
    }

    var temp = arr[inPlace];
    arr[inPlace] = arr[inPlace +1];
    arr[inPlace +1] = temp;

    return arr;
  }

  private static int inPlaceIndex(int[] arr) {
    int index = -1;
    for (int i = 0; i < arr.length ; i++) {
      if (i+1 != arr.length ) {
        if (arr[i] < arr[i+1]) {
          index = i;
        }
      }
    }
    return index;
  }

  public static void main(String[] args) {
    var arr = new int[]{0,5,4,3,2};
    var ans = ComputeTheNextPermutation.solution(arr);
    System.out.println(Arrays.toString(ans));

    System.out.println(Score.scoreSolution(1,4,4,3));
  }
}
