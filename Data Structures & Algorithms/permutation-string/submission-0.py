class Solution:

    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        containedChar: Dict[str, int] = {}
        windowsChar: Dict[str, int] = {}
        for ch in s1:
            containedChar[ch] = containedChar.get(ch, 0) + 1
        
        for j in range(len(s1)):
            windowsChar[s2[j]] = windowsChar.get(s2[j], 0) + 1

        if containedChar == windowsChar: return True

        left = 0
        right = len(s1) - 1 

        while right < len(s2) - 1:
            windowsChar[s2[left]] -= 1
            if windowsChar[s2[left]] == 0:
                del windowsChar[s2[left]]
            left += 1
            right += 1
            windowsChar[s2[right]] = windowsChar.get(s2[right], 0) + 1

            if windowsChar == containedChar: return True
        
        
        return False

            


        