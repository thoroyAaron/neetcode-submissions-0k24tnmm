class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0: return 0
        maxLen: int = 1
        left: int = 0
        right: int = 1
        containedChar: Set = set()
        lens: int = 1
        containedChar.add(s[left])
        while right < len(s):
            s1 = s[right]
            if s1 in containedChar:
                containedChar.remove(s[left])
                left += 1
                lens -= 1 
            else:
                containedChar.add(s1)
                lens += 1
                right += 1
                if lens > maxLen:
                    maxLen = lens
        return maxLen


