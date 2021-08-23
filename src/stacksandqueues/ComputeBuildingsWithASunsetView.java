package stacksandqueues;

import java.util.Deque;
import java.util.LinkedList;

public class ComputeBuildingsWithASunsetView {

  public static String soulution(int[] buildingSize) {
    Deque<Integer> set = new LinkedList<>();
    set.addFirst(buildingSize[0]);

    for (int i = 1; i < buildingSize.length; i++) {
      //
      var building = buildingSize[i];
      while (set.peekFirst() != null && building >= set.peekFirst()) {
        set.removeFirst();
      }
      set.addFirst(building);

    }

    return set.toString();
  }

  public static void main(String[] args) {
    var d = new int[]{12,14,11,9,8,7,10};
    System.out.println(soulution(d));
  }
}
