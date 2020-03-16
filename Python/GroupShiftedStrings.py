import string
from typing import List

class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        res = []
        dic = {}

        m = {}
        i = 1
        for c in string.ascii_lowercase:
            m[c] = i
            i += 1
        
        for s in strings:
            encode = 0
            diff = m[s[0]] - 1

            for c in s:
                n = m[c] - diff
                if n <= 0:
                    n += 26
                encode *= 100
                encode += n
            
            if encode in dic:
                dic[encode].append(s)
            else:
                dic[encode] = [s]
        
        for i in dic:
            res.append(dic[i])
        
        return res

test = Solution()
res = test.groupStrings(["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"])
print(res)


        


