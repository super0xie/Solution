class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        start = [0] * 1001
        end = [0] * 1001

        for trip in trips:
            start[trip[1]] += trip[0]
            end[trip[2]] += trip[0]
        
        for i in range(1001):
            capacity += end[i]
            capacity -= start[i]
            if capacity < 0:
                return False
                
        return True