package arraysandstring;

import scoring.Score;

public class BuyAndSellStockTwice {

  public int solution(int[] arr) {
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

  //solved in 23min
  public static void main(String[] args) {
    var stock = new BuyAndSellStockTwice();
    int[] arr = {310,315, 275, 295, 260, 270, 290, 230, 255, 250};
    System.out.println(stock.solution(arr));
    System.out.println(Score.scoreSolution(3,4,1,2));
  }
}

