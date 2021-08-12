package stacksandqueues;

import scoring.Score;

import java.util.HashMap;
import java.util.Stack;

public class WellFormedNess {
  public static boolean solution(String formed) {
    var s = new Stack<Character>();
    s.push(formed.charAt(0));

    for (int i = 1; i < formed.length() ; i++) {
      if (check(s, formed.charAt(i))) {
        s.pop();
      } else {
        s.push(formed.charAt(i));
      }

    }
    return s.isEmpty();
  }

  public static boolean check(Stack<Character> stack ,Character toCheck) {
    if (stack.isEmpty()) {
      return false;
    }
    var map = new HashMap<Character, Character>();
    map.put('[',']');
    map.put('(',')');
    map.put('{','}');

    return map.get(stack.peek()).equals(toCheck);
  }

  public static void main(String[] args) {
    var s = new Stack<Character>();
    System.out.println(solution("[()[]{()()"));
    System.out.println(Score.scoreSolution(3,4,3,3));
  }
}
