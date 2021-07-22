package arraysandstring;

public class ConvertRomanToDecimal {
  public static String solution(String romanNumber, String lastIndex) {
    String answer = "";
    String firstTwo;
    String rem;
    String first;
    String second;


    if (romanNumber.length() == 1) {
      firstTwo = romanNumber.substring(0,1);
      rem = romanNumber.substring(1);
      first = String.valueOf(firstTwo.charAt(0));
      second = "";
    } else {
      firstTwo = romanNumber.substring(0,2);
      rem = romanNumber.substring(2);
      first = String.valueOf(firstTwo.charAt(0));
      second = String.valueOf(firstTwo.charAt(1));
    }



    if (!lastIndex.equals("")) {
      if (lastIndex != first) {
        throw new IllegalArgumentException("Invalid roman argument");
      }
    }

    if (second.isEmpty()) {
      return first;
    }


    if (first == second) {
      if (rem.isEmpty()) {
        return first + second;
      }
      answer = answer + first + solution(romanNumber.substring(1),"");
    } else if (first == second) {
      if (rem.isEmpty()) {
        return second + first;
      }
      answer = answer + second + first + solution(rem, second);
    }

    return answer;


  }
}
