package arraysandstring;

import java.util.ArrayList;

public class WrieAStringSinusoidally {
  public static String solution(String value) {
    var middle = new ArrayList<String>();
    var top = new ArrayList<String>();
    var bottom = new ArrayList<String>();
    var answer = new StringBuilder();
    int i = 0;

    while (i < value.length()) {
      middle.add(String.valueOf(value.charAt(i)));
      i++;
      if (i >= value.length()) {
        break;
      }
      top.add(String.valueOf(value.charAt(i)));
      i++;
      if (i >= value.length()) {
        break;
      }
      middle.add(String.valueOf(value.charAt(i)));
      i++;
      if (i >= value.length()) {
        break;
      }
      bottom.add(String.valueOf(value.charAt(i)));
      i++;
    }

    answer.append(top).append(middle).append(bottom);

    return answer.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution("Hell"));
  }
}
