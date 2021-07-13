package arraysandstring;

import java.util.List;

public class MultiplyTwoArbitraryInt {
  public static int[] solution(int[] arr1, int[] arr2) {
    int size = (arr1.length + arr2.length)-1;
    int[] sol = new int[arr1.length + arr2.length];

    int carry = 0;
    int rem1 = 0;
    int carr2 = 0;
    int rem2 = 0;


    for (int i = arr1.length-1; i >= 0; i--) {
      int j = arr2.length -1;
      int k = j-1;
      var multi = arr2[j] * arr1[i] + carry;
      rem1 = multi%10;
      var total= findSum(arr2,k,arr1,i++,carr2);
      carr2 = total/10;
      var sum = rem1 +  total%10;
      carry = multi/10 +sum/10;
      rem2 = sum%10;
      sol[size] = rem2;
      size = size  -1;
    }
    return sol;
  }


  public static int findSum(int[] arr2, int index2, int[] arr1, int index1, int carry) {
    int arr2Value;
    if (index2 < 0) {
      return 0;
    } else {
      arr2Value = arr2[index2];
    }
    int arr1Value;
    if (index1 >= arr1.length) {
      arr1Value = 0;
    } else {
      arr1Value = arr1[index1];
    }
    var multiplication = (arr2Value * arr1Value) + carry;
    var newCarry = multiplication/10;
    var remainder = multiplication%10;
    index1++;
    index2--;



    return remainder + findSum(arr2, index2,arr1, index1, carry);
  }
}
