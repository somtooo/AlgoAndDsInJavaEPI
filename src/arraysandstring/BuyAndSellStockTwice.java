package arraysandstring;

import scoring.Score;

public class BuyAndSellStockTwice {

  public static int solution(int[] arr) {
    var profit = 0;
    var profit2 = 0;
    var buy = 0;
    var sell = 0;

    for (int i = 0; i < arr.length ; i++) {
      for (int j = i; j < arr.length; j++) {
        if (Math.max(profit, arr[j] - arr[i]) > profit) {
          profit = Math.max(profit, arr[j] - arr[i]);
          buy = i;
          sell = j;
        }

      }
    }

    for (int i = 0; i < arr.length ; i++) {
      for (int j = i; j < arr.length; j++) {
        if ((i < buy | i > sell) & (j < buy | j > sell)) {
          profit2 = Math.max(profit2, arr[j] - arr[i]);
        }
      }
    }
    return profit2 + profit;
  }


  public static int solution2(int[] arr) {
    int profit = 0;
    int buy = 0;
    int sell = 0;
    int profit2 = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length ; j++) {
        var temp = (arr[j]) - (arr[i]);
        if (temp > profit) {
          profit = temp;
          buy = i;
          sell = j;
        }
      }
    }


    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length ; j++) {
        if ((i < buy | i > sell) | (j < buy | j > sell) ) {
          var temp = (arr[j]) - (arr[i]);
          if (temp > profit2) {
            profit2 = temp;
          }
        }

      }
    }

    return profit + profit2;
  }

  public static double thirdAttempt(int[] prices) {
    double min = Double.MAX_VALUE, max = 0.0, cache = max;
    double sMin = Double.MAX_VALUE, sMax = 0.0;
    int secondBuyIndex =1;


    for (int i = 0; i < prices.length ; i++) {
      max = Math.max(max, (prices[i] - min));
      min = Math.min(min, prices[i]);
      if (max > cache) {
        sMin = prices[i+1];
        secondBuyIndex = i +1;
        cache = max;
      }

      sMax = Math.max(sMax, (prices[secondBuyIndex] - sMin));
      sMin = Math.min(min, prices[secondBuyIndex]);
      secondBuyIndex++;

    }


    return max + sMax;
  }

  //solved in 23min
  public static void main(String[] args) {
    int[] arr = {310,315, 275, 295, 260, 270, 290, 230, 255, 250};
    System.out.println(solution2(arr));
    System.out.println(Score.scoreSolution(3,4,1,2));
  }
}

