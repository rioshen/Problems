class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if not prices:
            return 0
        minprice = 1 << 31
        maxprofit = 0
        for price in prices:
            minprice = min(minprice, price)
            maxprofit = max(maxprofit, price-minprice)
        return maxprofit