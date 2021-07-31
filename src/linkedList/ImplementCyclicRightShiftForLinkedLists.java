package linkedList;


import scoring.Score;

import java.util.LinkedList;

public class ImplementCyclicRightShiftForLinkedLists {
  public static LinkedList<Integer> solution(LinkedList<Integer> list, Integer shift) {
    for (int i = 0; i <shift ; i++) {
      shiftByOne(list);
    }
    return list;
  }

  private static void shiftByOne(LinkedList<Integer> list) {
    var prev = list.get(0);
    for (int i = 0; i < list.size(); i++) {
      var current = list.get(i);
      list.set(i, prev);
      prev = current;
    }
    list.set(0, prev);
  }

  public static void main(String[] args) {
    var list = new LinkedList<Integer>();
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    System.out.println(solution(list,2));
    System.out.println(Score.scoreSolution(3,4,2,4));
  }
}
