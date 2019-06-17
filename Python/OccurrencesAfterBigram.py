class Solution(object):
    def findOcurrences(self, text, first, second):
        """
        :type text: str
        :type first: str
        :type second: str
        :rtype: List[str]
        """
        arr = text.split()
        res = []
        for i in range(len(arr)-2):
            if arr[i] == first and arr[i+1] == second:
                res.append(arr[i+2])
        return res