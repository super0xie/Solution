import java.util.LinkedList;

public class ZumaGame {
    
    
    class Node{
        String str;
        
        int [] count;
        
        Node(String str){
            this.str = str;
            count = new int[5];
        }
    }
    
    public int findMinStep(String board, String hand) {
        
        Node n = new Node(board);
        for(int i = 0; i < hand.length(); i++) {
            n.count[charToIdx(hand.charAt(i))]++;
        }
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(n);
        
        int step = 1;
        while(!queue.isEmpty()) {
            LinkedList<Node> aux = new LinkedList<>();
            while(!queue.isEmpty()) {
                Node polled = queue.poll();
                String s = polled.str;
                
                for(int i = 0; i < s.length(); i++) {
                    if(polled.count[charToIdx(s.charAt(i))] == 0) continue;
                    int j = i+1;
                    while(j < s.length() && s.charAt(j) == s.charAt(i)) j++;
                    
                    String str = s.substring(0, j) + s.charAt(i) + s.substring(j);
                    str = remove(str);
                    if(str.length() == 0) return step;
                    Node nei = new Node(str);
                    System.arraycopy(polled.count, 0, nei.count, 0, 5);
                    nei.count[charToIdx(s.charAt(i))]--;
                    aux.add(nei);
                    
                    i = j-1;
                }
            }
            queue = aux;
            step++;
        }
        
        return -1;
    }
    
    private int charToIdx(char c) {
        if(c == 'R') return 0;
        if(c == 'Y') return 1;
        if(c == 'B') return 2;
        if(c == 'G') return 3;
        if(c == 'W') return 4;
        return -1;
    }
    
    private String remove(String s) {
        for(int i = 0; i < s.length(); i++) {
            int j = i+1;
            while(j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            if(j-i >= 3) {
                if(j < s.length()) {
                    return remove(s.substring(0, i) + s.substring(j));
                }else {
                    return remove(s.substring(0, i));
                }
            }
        }
        return s;
    }
    
    public static void main(String[] args) {
        ZumaGame test = new ZumaGame();
        String board = "BRYRBB";
        String hand = "RYGYR";
        System.out.println(test.findMinStep(board, hand));
        
        
    }
    
}
