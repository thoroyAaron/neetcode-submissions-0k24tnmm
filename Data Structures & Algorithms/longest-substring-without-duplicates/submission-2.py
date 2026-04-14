class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        maxLen: int = 0
        left: int = 0
        containedChar = set()
        
        for right in range(len(s)):
            # 一直收缩左边，直到窗口内没有重复
            while s[right] in containedChar:
                containedChar.remove(s[left])
                left += 1
            
            containedChar.add(s[right])
            maxLen = max(maxLen, right - left + 1)
        
        return maxLen