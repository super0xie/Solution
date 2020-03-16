from typing import List

class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        aux = [0] * n
        res = [0] * n

        for booking in bookings:
            aux[booking[0]-1] += booking[2]
            if booking[1] != n:
                aux[booking[1]] -= booking[2]
        
        sum = 0
        for i in range(n):
            sum += aux[i]
            res[i] = sum
        return res


test = Solution()
bookings = [[1,2,10],[2,3,20],[2,5,25]]
print(test.corpFlightBookings(bookings, 5))
