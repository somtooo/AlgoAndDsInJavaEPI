package linkedList;

import scoring.Score;

import java.util.LinkedList;

public class TestForOverlappingList {
  public static boolean solution(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    var count = 0;

    for (int i = 0; i < list1.size() ; i++) {
      if (list1.get(i).equals(list2.get(i))) {
        count++;
      } else {
        count = 0;
      }
    }

    return count != 0;
  }

  public static void main(String[] args) {
    var s = new LinkedList<Integer>();
    s.add(9);
    s.add(2);
    s.add(3);
    s.add(4);
    s.add(5);
    s.add(6);
    var p = new LinkedList<Integer>();
    p.add(9);
    p.add(2);
    p.add(3);
    p.add(10);
    p.add(11);
    p.add(90);

    System.out.println(solution(s,p));
    System.out.println(Score.scoreSolution(4,5,5,5));
  }
}
