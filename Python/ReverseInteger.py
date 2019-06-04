class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        flag = 1
        upperLimit = 2**31-1
        lowerLimit = 2**31
        if x < 0:
            flag = -1
            x = -x
        result = 0
        while x != 0:
            r = x % 10
            x = x // 10
            result = result * 10
            if (flag == 1 and result > upperLimit) or (flag == -1 and result > lowerLimit):
                return 0
            result += r
        result = result * flag
        return result


if __name__ == "__main__":
    test = Solution()
    print(test.reverse(-123))
    # print(-123 % 10)