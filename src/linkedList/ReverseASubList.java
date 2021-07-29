package linkedList;

import scoring.Score;

import java.util.LinkedList;

public class ReverseASubList {
  public static LinkedList<Integer> solution(LinkedList1 list, int num1, int num2) {
//    var head = list.getNode(num1);
//    var tail = list.getNode(num2);
//    var temp = head;
//    head.next = tail.next;
//    list.insert(tail,atHeadIndex);// this will solve prev to connect to tail and tail.next = head;
//    while (temp.next!=tail) {
//      var rTemp = tail.next; //2
//      var nextNode = temp.next;//3
//      temp = temp.next;//3
//      tail.next = nextNode;//3
//      nextNode.next = rTemp;
//
    return new LinkedList<Integer>();
    }

  public static void main(String[] args) {
    System.out.println(Score.scoreSolution(2,5,5,4));
  }
}

