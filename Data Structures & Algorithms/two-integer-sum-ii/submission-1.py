class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left: int = 0
        right: int = len(numbers) - 1
        while left < right:
            temp: int = numbers[left] + numbers[right]
            if temp == target:
                return [left + 1, right + 1]
            elif temp > target:
                right -= 1
            else:
                left += 1
        return []
