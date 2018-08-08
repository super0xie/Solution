class Solution(object):

    def helper(self, left, right, current):
        if len(current) == self.n * 2:
            self.result.append(current)
            return
        if left < self.n:
            self.helper(left+1, right, current+"(")

        if right < left:
            self.helper(left, right+1, current+")")




    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        self.result = []
        if n == 0:
            return self.result
        self.n = n

        self.helper(0, 0, "")
        return self.result

if __name__ == "__main__":
    test = Solution()
    result = test.generateParenthesis(3)
    print(result)



