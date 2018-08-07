from ListNode import ListNode

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        count = 0
        cache = []
        node = head
        while(node != None):
            count = count + 1;
            cache.append(node)
            node = node.next;

        if count == n:
            return head.next
        index = count - n
        cache[index-1].next = cache[index-1].next.next
        return head


if __name__ == "__main__":
    test = Solution()
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)
    n5 = ListNode(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    test.removeNthFromEnd(n1, 2)

    node = n1
    while(node != None):
        print(node.val)
        node = node.next

