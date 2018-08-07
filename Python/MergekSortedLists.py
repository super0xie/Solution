from ListNode import ListNode
import heapq as pq

def less_than(self, other):
    return self.val < other.val

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if len(lists) == 0:
            return None
        ListNode.__lt__ = less_than

        heap = []
        head = dum = ListNode(0)
        for i in range(len(lists)):
            if lists[i] != None:
                pq.heappush(heap, (lists[i].val, lists[i]))
        while len(heap) > 0:
            poped_node = pq.heappop(heap)[1]
            if poped_node.next != None:
                pq.heappush(heap, (poped_node.next.val, poped_node.next))
            head.next = poped_node
            head = head.next
        return dum.next






if __name__ == "__main__":
    test = Solution()
    n1 = ListNode(1)
    n2 = ListNode(4)
    n3 = ListNode(5)
    n4 = ListNode(1)
    n5 = ListNode(3)
    n6 = ListNode(4)
    n7 = ListNode(2)
    n8 = ListNode(6)
    n1.next = n2
    n2.next = n3
    n4.next = n5
    n5.next = n6
    n7.next = n8
    lists = [n1, n4, n7]
    head = test.mergeKLists(lists)

    while head != None:
        print(head.val)
        head = head.next
    # heap = []
    # pq.heappush(heap, (n1.val, n1))
    # pq.heappush(heap, (n2.val, n2))

    # for i in range(len(lists)):
    #     node = lists[i]
    #     print(node.val)
    #     pq.heappush(heap, (node.val, node))

