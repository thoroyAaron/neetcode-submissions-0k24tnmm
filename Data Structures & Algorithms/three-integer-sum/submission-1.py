class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        answer: List[List[int]] = []
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            temp = nums[i]
            left = i + 1
            right = len(nums) - 1
            while left < right:
                leftNum = nums[left]
                rightNum = nums[right]
                if leftNum + rightNum + temp == 0:
                    answer.append([temp, leftNum, rightNum])
                    while left < right and nums[left] == leftNum:
                        left += 1
                    while left < right and nums[right] == rightNum:
                        right -= 1
                elif leftNum + rightNum + temp > 0:
                    right -= 1
                else:
                    left += 1
        return answer