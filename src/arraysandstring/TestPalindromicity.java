package arraysandstring;

public class TestPalindromicity {

  public static boolean solution(String test) {
    //ROTATOR
    //ABBA
    int divisor;
    int back = test.length() -1;
    if (test.length()%2 == 0) {
      divisor = test.length()/2;
    } else {
      divisor  = test.length()/2 + 1;
    }

    for (int i = 0; i < divisor; i++) {
      if (test.charAt(i) != test.charAt(back)) {
        return false;
      }
      back--;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(solution("google"));
  }
}
