class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minBuy: int = prices[0]
        maxP: int = 0
        for i in range(1, len(prices)):
            sellPrice = prices[i]
            maxP = max(sellPrice - minBuy, maxP)
            if sellPrice < minBuy:
                minBuy = sellPrice
        
        return maxP