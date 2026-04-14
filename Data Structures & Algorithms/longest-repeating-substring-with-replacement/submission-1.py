class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        if len(s) == 0: return 0
        numCharMap = {}
        left: int = 0
        numCharMap[s[left]] = 1
        replaceTime: int = 1
        res: int = 0
        for right in range(1, len(s)):
            maxSame = 0
            charNow = s[right]
            if charNow in numCharMap.keys():
                numCharMap[charNow] += 1
            else:
                numCharMap[charNow] = 1
            
            for v in numCharMap.values():
                if v > maxSame:
                    maxSame = v
            
            windowsLength = right - left + 1
            if windowsLength - maxSame > k:
                charLeft = s[left]
                numCharMap[charLeft] -= 1
                left += 1
            else:
                right += 1
            if right - left > res:
                res = right - left
        return res

            

                






