package arraysandstring;

import scoring.Score;

import java.util.HashMap;

public class ConvertStringToInt {

  public static int solution(String number) {
    var map = new HashMap<Character, Integer>();
    int ans = 0;
    map.put('1',1);
    map.put('2',2);
    map.put('3',3);
    map.put('4',4);
    map.put('5',5);
    map.put('6',6);
    map.put('7',7);
    map.put('8',8);
    map.put('9',9);
    map.put('0',0);

    for (int i = 0; i <  number.length() ; i++) {
      ans = (ans * 10) + map.get(number.charAt(i));
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(solution("1235"));
    System.out.println(Score.scoreSolution(4,4,4,4));
  }
}
