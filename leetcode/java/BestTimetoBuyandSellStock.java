public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (minPrice < price) {
                maxProfit = Math.max(maxProfit, price - minPrice);
            } else {
                minPrice = price;
            }
        }
        return maxProfit;
    }
}