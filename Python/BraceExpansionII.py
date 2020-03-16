from typing import List

class Solution:

    def braceExpansionII(self, exp: str) -> List[str]:
        s = []
        i = 0
        cur = None

        while i < len(exp):
            tmp = None
            if exp[i] == "{":
                j = i+1
                count = 1
                while j < len(exp):
                    if exp[j] == "{":
                        count += 1
                    elif exp[j] == "}":
                        count -= 1
                        if count == 0:
                            break
                    j += 1

                tmp = self.braceExpansionII(exp[i+1 : j])
                i = j + 1
            elif exp[i] == ",":
                i += 1
                continue
            else:
                j = i
                while j < len(exp) and exp[j].islower():
                    j += 1
                tmp = [exp[i : j]]
                i = j
            
            if cur != None:
                cur = self.concat(cur, tmp)
            else:
                cur = tmp
            
            if i == len(exp) or exp[i] == ",":
                s.append(cur)
                cur = None
            
        res = self.union(s)
        res = sorted(res)
        return res
    

    def concat(self, l1: List[str], l2: List[str]) -> List[str]:
        res = []
        for str1 in l1:
            for str2 in l2:
                res.append(str1 + str2)
        return res

    def union(self, s: List[List[str]]) -> List[str]:
        strs = set()
        for l in s:
            for strg in l:
                strs.add(strg)
        res = []
        for strg in strs:
            res.append(strg)
        return res



test = Solution()
print(test.braceExpansionII("{a,b}{c{d,e}}"))
