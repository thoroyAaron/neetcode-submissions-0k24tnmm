class Solution:
    def isPalindrome(self, s: str) -> bool:
        head = 0
        tail = len(s) - 1
        while head < tail:
            while head < tail and not s[head].isalnum():  # 跳过非法字符
                head += 1
            while head < tail and not s[tail].isalnum():
                tail -= 1
            if s[head].lower() != s[tail].lower():
                return False
            head += 1
            tail -= 1
        return True