class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            if abs(len(s) - len(t)) > 1:
                return False
            count = 0
            i = 0
            j = 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    i += 1
                    j += 1
                else:
                    count += 1
                    if count > 1:
                        return False
                    if len(s) > len(t):
                        i += 1
                    else:
                        j += 1
            
            return True
        else:
            count = 0
            for i in range(len(s)):
                if s[i] != t[i]:
                    count += 1
            
            return count == 1

        


