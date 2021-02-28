
public class leetcode_122 {
	public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int total = 0;
        for (int i = 0; i < prices.length-1 ; i++) {
            int diff = prices[i+1] - prices[i];
            if(diff > 0){
                total += diff;
            }
        }
        return total;
    }
}
