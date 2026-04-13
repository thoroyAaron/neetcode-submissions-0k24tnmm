class Solution:
    def trap(self, height: List[int]) -> int:
        water: int = 0
        for i in range(1, len(height) - 1):
            leftMax: int = 0
            rightMax: int = 0
            for j in range(0, i + 1):
                leftMax = max(leftMax, height[j])
            for k in range(i, len(height)):
                rightMax = max(rightMax, height[k])
            water += min(leftMax, rightMax) - height[i]
        return water
