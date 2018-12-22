import java.util.List;



public class ReplaceWords {
    
    private class TrieNode{
        TrieNode[] next;
        boolean end;
        TrieNode(){
            next = new TrieNode [26];
            end = false;
        }
    }
    
    private TrieNode root;
    
    private void insert(TrieNode node, String str, int idx) {
        char c = str.charAt(idx);
        if(node.next[c-'a'] == null) {
            node.next[c-'a'] = new TrieNode();
        }
        
        if(idx == str.length()-1) {
            node.next[c-'a'].end = true;
        }else {
            insert(node.next[c-'a'], str, idx+1);
        }
    }
    
    
    private String search(TrieNode n, String str, int idx) {
        char c = str.charAt(idx);
        if(n.next[c-'a'] == null) return str;
        
        if(n.next[c-'a'].end) return str.substring(0, idx+1);
        if(idx == str.length()-1) return str;
        else {
            return search(n.next[c-'a'], str, idx+1);
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        root = new TrieNode();
        for(String word : dict) {
            insert(root, word, 0);
        }
        
        for(int i = 0; i < words.length; i++) {
            res.append(search(root, words[i], 0));
            if(i != words.length-1) res.append(" ");
        }
        
        return res.toString();
    }
    
}
