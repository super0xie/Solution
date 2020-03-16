# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        if root == None:
            return res
        q = [root]
        while len(q) > 0:
            aux = []
            val = []
            for n in q:
                val.append(n.val)
                if n.left != None:
                    aux.append(n.left)
                if n.right != None:
                    aux.append(n.right)
            
            q = aux
            if len(val) > 0:
                res.append(val)

        return res


