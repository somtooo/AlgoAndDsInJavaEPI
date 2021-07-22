package arraysandstring;

public class TheLookAndSayProblem {
  public static String solution(int n) {
    return "1 ".concat(solve("1", n));
  }

  private static String solve(String s, int n) {

    var ans = "";
    var count = 1;
    for (int i = 0; i < s.length(); i++) {
      var index = s.charAt(i);
      char next;
      if (i +1 >= s.length()) {
        next = 'q';
      } else {
        next = s.charAt(i +1);
      }
      if (index ==next) {
        count++;
      } else {
        ans = ans.concat(String.valueOf(count).concat(String.valueOf(index)));
        count = 1;
      }
    }
    n--;
    if (n ==0) {
      return "";
    }
    return ans.concat(" ").concat(solve(ans,n));
  }

  public static void main(String[] args) {
    System.out.println(solution(8));
  }
}
