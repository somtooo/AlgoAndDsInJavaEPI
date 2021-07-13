package arraysandstring;

import scoring.Score;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ComputeARandomSubset {

  public int[] solution(int num, int size) {
    var arr = new int[size];
    var hashMap = new HashSet<Integer>();
    var rand = new Random();
    int i = 0;
    while (i < arr.length) {
      var randNum = rand.nextInt(num);
      if (!hashMap.contains(randNum)) {
        hashMap.add(randNum);
        arr[i] = randNum;
        i++;
      }
      }


    return arr;
  }

  public static void main(String[] args) {
    var obj = new ComputeARandomSubset();
    var ans = obj.solution(8,5);
    System.out.println(Arrays.toString(ans));
    System.out.println(Score.scoreSolution(4,4,3,5));
  }
}
