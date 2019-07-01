import TreeNode
import time
from typing import List
class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        val = preorder[0]
        n = TreeNode(val)
        length = len(preorder)
        idx = 0
        for i in range(length):
            if inorder[i] == val:
                idx = i
                break

        lenLeft = idx
        lenRight = length - lenLeft - 1
        
        if lenLeft > 0:
            n.left = self.buildTree(preorder[1 : 1+lenLeft], inorder[0 : idx])

        if lenRight > 0:
            n.right = self.buildTree(preorder[1+lenLeft : len(preorder)], inorder[idx+1 : len(inorder)])
        
        return n






    