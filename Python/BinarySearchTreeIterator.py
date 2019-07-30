from TreeNode import TreeNode

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.s = []
        n = root
        while n != None:
            self.s.append(n)
            n = n.left
        

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        p = self.s.pop()
        n = p.right
        while n != None:
            self.s.append(n)
            n = n.left
        return p.val
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return len(self.s) > 0

n1 = TreeNode(4)
n2 = TreeNode(2)
n3 = TreeNode(5)
n4 = TreeNode(1)
n5 = TreeNode(3)
n1.left = n2
n1.right = n3
n2.left = n4
n2.right = n5
test = BSTIterator(n1)
while test.hasNext():
    print(test.next())






