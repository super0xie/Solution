public class AddandSearchWordDatastructuredesign{

    private class Node{
        Node[] next;
        boolean isEnd;

        Node(){
            next = new Node[26];
        }
    }

    private void add(String str, int idx, Node n){
        if(idx == str.length()) {
            n.isEnd = true;
            return;
        }
        if(n.next[str.charAt(idx)-'a'] == null) n.next[str.charAt(idx)-'a'] = new Node();
        add(str, idx+1, n.next[str.charAt(idx)-'a']);
    }

    private boolean search(String str, int idx, Node n){
        if(idx == str.length()) {
            if(n.isEnd) return true;
            else return false;
        }

        if(str.charAt(idx) == '.'){
            for(Node next : n.next){
                if(next != null){
                    if(search(str, idx+1, next)) return true; 
                }
            }
            return false;
        }else{
            if(n.next[str.charAt(idx)-'a'] == null) return false;
            return search(str, idx+1, n.next[str.charAt(idx)-'a']);
        }
    }

    private Node root;

    public void WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        add(word, 0, root);
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
}