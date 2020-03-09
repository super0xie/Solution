
public class ValidateBinaryTreeNodes {
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] pcount = new int[n];
        
        for(int i = 0; i < n; i++) {
            
            if(leftChild[i] == rightChild[i] && leftChild[i] != -1) return false;
            if(leftChild[i] != -1)
                pcount[leftChild[i]]++;
            if(rightChild[i] != -1)
                pcount[rightChild[i]]++;
        }
        
        int root = -1;
        for(int i = 0; i < n; i++) {
            if(pcount[i] > 1) return false;
            else if(pcount[i] == 0) {
                if(root == -1) root = i;
                else return false;
            }
        }
        if(root == -1) return false; 
        return true;
    }
}
