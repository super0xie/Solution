from typing import List

class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], num_wanted: int, use_limit: int) -> int:
        
        l = []
        for i in range(len(values)):
            l.append((values[i], labels[i]))
        l = sorted(l, key=lambda a: a[0])

        count = {}
        n = 0
        res = 0
        print(l)
        for i in range(len(l)-1, -1, -1):
            if l[i][1] in count and count[l[i][1]] == use_limit:
                continue
            
            if l[i][1] not in count:
                count[l[i][1]] = 1
            else:
                count[l[i][1]] += 1

            n += 1
            res += l[i][0]

            print(count)
            if n == num_wanted:
                break

        return res


test = Solution()
print(test.largestValsFromLabels([5,4,3,2,1], [1,1,2,2,3], 3, 1))






