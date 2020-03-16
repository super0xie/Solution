from typing import List

class Solution:

    def addNegabinary(self, arr1: List[int], arr2: List[int]) -> List[int]:
        i = len(arr1)-1
        j = len(arr2)-1
        l = []
        carry = 0
        while i >= 0 or j >= 0:
            res = 0
            if i >= 0 and j >= 0:
                res = arr1[i] + arr2[j] + carry
            elif i >= 0:
                res = arr1[i] + carry
            elif j >= 0:
                res = arr2[j] + carry
            
            if res == 0:
                l.append(0)
                carry = 0
            elif res == 1:
                l.append(1)
                carry = 0
            elif res == 2:
                l.append(0)
                carry = -1
            elif res == -1:
                l.append(1)
                carry = 1
            elif res == 3:
                l.append(1)
                carry = -1
            i -= 1
            j -= 1
        
        if carry == -1:
            l.append(1)
            l.append(1)
        elif carry == 1:
            l.append(1)

        while len(l) > 1 and l[-1] == 0:
            l.pop(-1)

        l.reverse()
        return l

test = Solution()
print(test.addNegabinary([1,1,1,1,1], [1,0,1]))
        


