package linkedList;

import scoring.Score;

public class TestForCyclicity {

  public static LinkedList1.Node solution() {
    //loop through the list and store nodes in a set the first node that repeats return it if no nodes repeat return null
    //nice brute force solution
    return new LinkedList1.Node(1);
  }

  public static void main(String[] args) {
    System.out.println(Score.scoreSolution(4,5,3,4));
  }
}
