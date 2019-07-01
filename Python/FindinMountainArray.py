class Solution:

    def findInMountainArray(self, secret: List[int], target: int) -> int:
        for i in range(len(secret)):
            if(secret[i] == target):
                return i
        return -1
