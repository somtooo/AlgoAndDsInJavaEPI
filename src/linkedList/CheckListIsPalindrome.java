package linkedList;

import scoring.Score;

import java.util.LinkedList;

public class CheckListIsPalindrome {
  public static boolean solution(LinkedList<Integer> list) {
    int newHeadIndex;
    if (list.size()%2 == 0) {
      newHeadIndex = list.size()/2;
    } else {
      newHeadIndex = list.size()/2 +1;
    }

    reverseSubList(list, newHeadIndex);
    // [baab] -> [baba]

    var count  = newHeadIndex;
    for (int i = 0; i < list.size() - newHeadIndex;i++) {
      if (list.get(i) != list.get(count)) {
        return false;
      }
      count++;
    }
    return true;
  }

  private static void reverseSubList(LinkedList<Integer> list, int newHeadIndex) {
  }

  public static void main(String[] args) {
    System.out.println(Score.scoreSolution(4,4,3,4));
  }
}
