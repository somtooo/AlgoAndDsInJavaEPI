package arraysandstring;

public class RunLengthEncoding {
  public static String encode(String value) {
    var ans = "";
    int count = 1;
    for (int i = 0; i < value.length() ; i++) {
    if ((i + 1) < value.length() &&(value.charAt(i) == value.charAt(i +1))) {
      count ++;
    } else {
      ans = ans.concat(String.valueOf(count)).concat(String.valueOf(value.charAt(i)));
      count = 1;
    }
    }

    return ans;
  }

  public static String decode(String value) {
    var ans = "";
    for (int i = 0; i < value.length() ; i+=2) {
      ans = ans.concat(String.valueOf(value.charAt(i+1)).repeat(Character.getNumericValue(value.charAt(i))));
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(encode("aaaabcccaa"));
    System.out.println(decode("4a1b3c2a"));
  }
}
