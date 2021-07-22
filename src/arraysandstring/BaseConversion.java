package arraysandstring;

public class BaseConversion {

  public static String solution(String number, int base, int newBase) {
    int base10 = convertToBase10(number, base);
    return convertToNewBase(base10, newBase);
  }

  private static String convertToNewBase(int base10, int base) {
    var coef = base10/base;
    var rem = base10%base;
    var newBase = "";

    if (coef == 0) {
      return String.valueOf(rem);
    }
    newBase = newBase.concat(convertToNewBase(coef, base));
    return newBase.concat(String.valueOf(rem));

  }

  private static int convertToBase10(String number, int base) {
    int base10 = 0;
    int index = number.length();
    for (int i = 0; i < number.length() ; i++) {
      index--;
      base10 = (int) (base10 + (Character.getNumericValue(number.charAt(i))) * Math.pow(base,index));
    }
    return base10;
  }

  public static void main(String[] args) {
    System.out.println(solution("127",8,4));
  }
}
