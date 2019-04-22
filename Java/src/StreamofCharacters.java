public class StreamofCharacters{
    private class Node {
        Node[] next;
        boolean end;

        Node(){
            next = new Node[26];
        }
    }

    private Node root;
    private StringBuilder sb;

    private void add(Node n, int i, String str){
        if(n.next[str.charAt(i)-'a'] == null) n.next[str.charAt(i)-'a'] = new Node();

        if(i == 0){
            n.next[str.charAt(i)-'a'].end = true;
        }else{
            add(n.next[str.charAt(i)-'a'], i-1, str);
        }
    }

    public void StreamChecker(String[] words) {
        root = new Node();

        for(String str : words){
            add(root, str.length()-1, str);
        }

        sb = new StringBuilder();
    }

    private boolean check(Node n, int i){
        if(n.next[sb.charAt(i)-'a'] == null) return false;
        if(n.next[sb.charAt(i)-'a'].end) return true;
        if(i == 0) return false;
        return check(n.next[sb.charAt(i)-'a'], i-1);
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return check(root, sb.length()-1);
    }
}