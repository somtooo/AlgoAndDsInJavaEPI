package stacksandqueues;

import scoring.Score;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class NormalizePathname {
  public static String solution(String path) {
    Deque<String> stack = new LinkedList<>();
    var builder = new StringBuilder();

    for (int i = 0; i < path.length() ; i++) {
      if (path.charAt(i) == '/') {
        if (i == 0) {
          stack.addLast("/");
        }
        if (builder.length() != 0) {
          if (builder.toString().equals(".")) {
            if (i == 1) {
              stack.addLast(builder.toString());
            }
            builder.setLength(0);
          } else if (builder.toString().equals("..")) {
            if (i == 2) {
              stack.addLast(builder.toString());
            } else {
              stack.removeLast();
            }
            builder.setLength(0);
          } else {
            stack.addLast(builder.toString());
            builder.setLength(0);
          }
        }
      } else {
        builder.append(path.charAt(i));
      }
    }
    if (builder.length() != 0) {
      stack.addLast(builder.toString());
      builder.setLength(0);
    }

    for (String value : stack ) {
     builder.append( (value.equals("/") ? "/" : value + "/") );
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution("../scripts//./../scripts/awkscripts/././"));
    System.out.println(Score.scoreSolution(1,4,4,3));
  }
}
