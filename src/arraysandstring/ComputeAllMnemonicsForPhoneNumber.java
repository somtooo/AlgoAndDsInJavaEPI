package arraysandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComputeAllMnemonicsForPhoneNumber {
  //2276696 ACRONYM OR ABPOMZN

  public static List<String> solution(String num) {
    String myPart;
    String rem;
    List<String> rList;
    List<String> combination = new ArrayList<>();
    if (num.length() == 1) {
      myPart = num.substring(0,1);
      rem = num.substring(1);
    } else {
      myPart = num.substring(0,2);
      rem = num.substring(2);
    }

    if (rem.length()!=0) {
      rList = solution(rem);
    } else {
      return buildTheList(myPart);
    }

    var builtList = buildTheList(myPart);

    for (String s : builtList) {
      for (String value : rList) {
        combination.add(s.concat(value));
      }
      //
    }

    return combination;
  }



  private static List<String> buildTheList(String num) {
    var map = new HashMap<Character, String>();
    map.put('2',"ABC");
    map.put('3',"DEF");
    map.put('4',"GHI");
    map.put('5',"JKL");
    map.put('6',"MNO");
    map.put('7',"PQRS");
    map.put('8',"TUV");
    map.put('9',"WXYZ");
    var list = new ArrayList<String>();
    // 22 is ABC ABC how many combinations

    var first =  map.get(num.charAt(0));

    if (num.length() ==1) {
      for (int i = 0; i < first.length() ; i++) {
        list.add(String.valueOf(first.charAt(i)));
      }
      return list;
    }
    var second =  map.get(num.charAt(1));
    for (int i = 0; i < first.length() ; i++) {
      for (int j = 0; j < second.length(); j++) {
        list.add(String.valueOf(first.charAt(i)) + second.charAt(j));
      }
    }

    return list;
  }

  public static void main(String[] args) {
    var s = "2";
    System.out.println(s.substring(1));
  }
}


