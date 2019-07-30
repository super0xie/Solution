class Solution:
    days = [31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    def numberOfDays(self, Y: int, M: int) -> int:
        if M == 2:
            leap = False
            if (Y % 100 == 0 and Y % 400 == 0) or (Y % 100 != 0 and Y % 4 == 0):
                leap = True
            if leap:
                return 29
            else:
                return 28
        else:
            return Solution.days[M-1]
        