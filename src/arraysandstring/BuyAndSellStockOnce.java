package arraysandstring;

import scoring.Score;

public class BuyAndSellStockOnce {


  public int solution(int[]arr) {
    var profit = 0;
    var buy = 0;
    var sell = 0;

    for (int i = 0; i < arr.length ; i++) {
      for (int j = i; j < arr.length; j++) {
         profit = Math.max(profit,arr[j] - arr[i]);
        buy = i;
        sell = j;
      }
    }
    return profit;
  }


  //Fastest Utilizes the idea that the max is informed by the minimum of the past O(n)
  public static double thirdAttempt(int[] prices) {
    double min = Double.MAX_VALUE, max = 0.0;
    for (int price: prices) {
      max = Math.max(max, (price -min));
      min = Math.min(price, min);
    }

    return max;
  }

  //solved in 13min
  public static void main(String[] args) {
    var stock = new BuyAndSellStockOnce();
    int[] arr = {310,315, 275, 295, 260, 270, 290, 230, 255, 250};
    System.out.println(thirdAttempt(arr));

   System.out.println(Score.scoreSolution(4,4,1,3));

  }
}
