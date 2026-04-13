class Solution:
    def maxArea(self, heights: List[int]) -> int:
        maxWater: int = 0
        left: int = 0
        right: int = len(heights) - 1
        while left < right:
            leftHeight = heights[left]
            rightHeight = heights[right]
            water = min(leftHeight, rightHeight) * (right - left)
            if water > maxWater:
                maxWater = water
            if leftHeight >= rightHeight:
                right -= 1
            else:
                left += 1
        return maxWater


