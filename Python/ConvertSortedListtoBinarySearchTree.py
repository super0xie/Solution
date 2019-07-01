import TreeNode
class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if head == None:
            return None
        vals = []
        while head != None:
            vals.append(head.val)
            head = head.next
        return self.helper(vals, 0, len(vals)-1)
        
    def helper(self, vals, l, r):
        if l == r:
            return TreeNode(vals[l])
        
        mid = r - (r-l)//2
        n = TreeNode(vals[mid])
        n.left = self.helper(vals, l, mid-1)
        if mid + 1 <= r:
            n.right = self.helper(vals, mid+1, r)
        return n
    
        
