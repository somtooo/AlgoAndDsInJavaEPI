package arraysandstring;

import java.util.*;

public class MultiplyTwoArbitraryInt {


  public static int solution(int[] arr1, int[] arr2) {
    int carry = 0;
    int coeff = 0;
    int multiplier = 1;
    int ans = 0;
    int headMultiplier = 1;
    for (int i = arr2.length -1; i >= 0; i--) {
      for (int j = arr1.length -1; j >=0; j--) {
        int multiplication = arr2[i] * arr1[j] + carry;
        coeff = (j == arr1.length-1) ? multiplication%10 : (multiplication%10 * multiplier) + coeff;
        carry = multiplication/10;
        multiplier*=10;

        if (j == 0) {
          coeff = ((carry * multiplier) + coeff ) * headMultiplier;
          ans+=coeff;
          headMultiplier*=10;
          coeff = 0;
          carry = 0;
          multiplier = 1;

        }
      }
    }

    return ans;
  }

  //Trying to combine addition and multiplication using recursion.
  public static List<Integer> solution2(List<Integer> arr1 , List<Integer> arr2) {

    int runTime = arr1.size() + arr2.size();
    int carry = 0;
    int sumCarry = 0;
    int current = 1;
    var tracker = new Tracker();
    List<Integer> ans = new ArrayList<>();

    int i = arr1.size()-1;
    int j = arr2.size()-1;
    while (current <= runTime) {
      var multi = (i < 0) ? carry: arr2.get(j) * arr1.get(i) + carry;
      carry = multi/10;
      int sum = multi%10 + sumCarry+ multiply(arr1, arr2, current, tracker, 0);
      sumCarry =  sum/10;
      if (current == runTime & sum%10 == 0) {
        break;
      } else {
        ans.add(sum%10);
      }
      i--;
      current++;
    }
    Collections.reverse(ans);
    return ans;
  }



  private static int multiply(List<Integer> arr1, List<Integer> arr2, int current, Tracker tracker, int carryIndex) {
    List<Integer> ar1 = new ArrayList<>(arr1);
    List<Integer> ar2 = new ArrayList<>(arr2);
    ar1.add(0);
    ar2.remove(ar2.size()-1);
    if (ar2.size() == 0) {
      return 0;
    }
    int i = ar1.size()-current;
    int j = ar2.size()-1;
    var mult = (i < 0) ? tracker.getCarry(carryIndex) : ar2.get(j) * ar1.get(i) + tracker.getCarry(carryIndex);

    tracker.updateCarry(carryIndex, mult/10);
    carryIndex++;
    return mult%10 + multiply(ar1, ar2, current,tracker,carryIndex);
  }

  public static class Tracker {
    private final List<Integer> carry;
    public Tracker() {
      this.carry = new ArrayList<>();
    }
    public void updateCarry(int index, int element) {
      if ((index < this.carry.size())) {
        this.carry.set(index, element);
      } else {
        this.carry.add(element);
      }
    }
    public int getCarry(int index) {
      return (index >= this.carry.size()) ? 0 : this.carry.get(index);
    }
  }

  public static void main(String[] args) {
    var ar1 = new int[]{7,6,1,8,3,8};
    var ar2 = new int[]{1,9};
    List<Integer> a = new ArrayList<>();
    Collections.addAll(a,7,6,1,8,3,8,2,5,7,2,8,7); //12
    List<Integer> q = new ArrayList<>();
    Collections.addAll(q,1,9,3, 7,0,7,7, 2,1); //9
    long startTime = System.currentTimeMillis();
    System.out.println(solution(ar1,ar2));
    long endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime-startTime) + "ms");
  }


}
