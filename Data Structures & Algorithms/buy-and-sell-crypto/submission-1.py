class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l: int = 0
        r: int = 1
        maxP:int = 0
        while r < len(prices):
            buyPrice = prices[l]
            sellPrice = prices[r]
            if buyPrice < sellPrice:
                maxP = max(sellPrice - buyPrice, maxP)
            else:
                l = r
            r += 1
        return maxP
