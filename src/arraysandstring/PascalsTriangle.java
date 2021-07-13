package arraysandstring;

import scoring.Score;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PascalsTriangle {
  public static Collection<Integer> solution(int n) {
    int rowNum = 1;
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.addAll(solve(list,n,rowNum));
    return list;
  }



  private static Collection<Integer> solve(List<Integer> list, int n, int rowNum) {
    if (rowNum == n) {
      return new ArrayList<>();
    }
    var updatedRow = new ArrayList<Integer>();

    for (int i = 0; i < list.size() ; i++) {
      if (i == 0) {
        updatedRow.add(1);
      }else {
        var value = list.get(i) + list.get(i-1);
        updatedRow.add(value);
      }
    }
    updatedRow.add(1);
    rowNum++;
    updatedRow.addAll(solve(updatedRow, n, rowNum));
    return updatedRow;
  }

  public static void main(String[] args) {
    System.out.println(solution(5));
    System.out.println(Score.scoreSolution(3,5,4,4));
  }
}
