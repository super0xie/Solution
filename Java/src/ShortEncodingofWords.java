import java.util.HashSet;

public class ShortEncodingofWords {
    
    class TrieNode {
        TrieNode[] children;
        boolean hasChildren;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    
    private void add(String str, int idx, TrieNode n) {
        if(n.children[str.charAt(idx)-'a'] == null) {
            n.children[str.charAt(idx)-'a'] = new TrieNode();
            n.hasChildren = true;
        }
        
        if(idx > 0) {
            add(str, idx-1, n.children[str.charAt(idx)-'a']);
        }
    }
    
    private boolean isPrefix(String str, int idx, TrieNode n) {
        if(idx == 0) return n.children[str.charAt(idx)-'a'].hasChildren;
        else {
            return isPrefix(str, idx-1, n.children[str.charAt(idx)-'a']);
        }
    }
    
    public int minimumLengthEncoding(String[] words) {
        root = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            add(words[i], words[i].length()-1, root);
        }
        
        int res = 0;
        
        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            if(!isPrefix(words[i], words[i].length()-1, root) && !visited.contains(words[i])) {
                res += words[i].length()+1;
            }
            visited.add(words[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        ShortEncodingofWords test = new ShortEncodingofWords();
        System.out.println(test.minimumLengthEncoding(words));
    }
    
}
