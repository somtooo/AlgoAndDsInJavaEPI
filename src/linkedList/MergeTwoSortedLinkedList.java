package linkedList;

import scoring.Score;

import java.util.LinkedList;

public class MergeTwoSortedLinkedList {

  public static LinkedList<Integer> solution(LinkedList<Integer> list1, LinkedList<Integer> list2) {

    var ans = new LinkedList<Integer>();
    int index1 = 0;
    int index2 = 0;
    while (index1 < list1.size()) {
      if (list1.get(index1) < list2.get(index2)) {
        if (index1 == list1.size()-1) {
          ans.add(list1.get(index1));
          ans.add(list2.get(index2));
        } else {
          ans.add(list1.get(index1));
        }
        index1++;
      } else if (list1.get(index1) > list2.get(index2)) {
        if (index1 == list1.size()-1) {
          ans.add(list2.get(index2));
          ans.add(list1.get(index1));
          index1++;
        }else {
          ans.add(list2.get(index2));
        }

        index2++;

      } else if (list1.get(index1).equals(list2.get(index2))) {
        ans.add(list2.get(index2));
        index2++;
      }


    }
    return ans;
  }

  public static void main(String[] args) {
    var s = new LinkedList<Integer>();
    var p = new LinkedList<Integer>();
    s.add(2);
    s.add(3);
    p.add(5);
    p.add(7);

    System.out.println(solution(s,p));
    System.out.println(Score.scoreSolution(2,5,1,1));

  }
}
