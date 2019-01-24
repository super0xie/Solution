
public class MaximumLengthofRepeatedSubarray {
    
    class TrieNode{
        TrieNode[] children;
        
        TrieNode(){
            children = new TrieNode[100];
        }
    }
    
    private TrieNode root;
    
    private void add(TrieNode n, int[] arr, int idx) {
        if(n.children[arr[idx]] == null) {
            n.children[arr[idx]] = new TrieNode();
        }
        if(idx < arr.length-1) add(n.children[arr[idx]], arr, idx+1);
    }
    
    private int len(TrieNode n, int[] arr, int idx, int len) {
        if(n.children[arr[idx]] == null) return len;
        else if(idx < arr.length-1) return len(n.children[arr[idx]], arr, idx+1, len+1);
        else return len+1;
    }
    
    
    public int findLength(int[] A, int[] B) {
        root = new TrieNode();
        
        if(A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        
        for(int i = 0; i < A.length; i++) {
            add(root, A, i);
        }
        
        int res = 0;
        for(int i = 0; i < B.length; i++) {
            res = Math.max(res, len(root, B, i, 0));
        }
        return res;
    }
}
