class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        dic = {}
        for inter in intervals:
            if inter[0] in dic:
                dic[inter[0]] += 1
            else:
                dic[inter[0]] = 1

            if inter[1] in dic:
                dic[inter[1]] -= 1
            else:
                dic[inter[1]] = -1

        res = 0
        sum = 0
        for i in sorted(dic.keys()):
            sum += dic[i]
            res = max(res, sum)
        return res