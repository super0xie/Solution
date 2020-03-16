import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PalindromePairs {

    private class Node{
        Node[] next;
        int val;

        Node(){
            next = new Node[26];
            val = -1;
        }
    }

    private Node root;
    private HashSet<Integer> set;

    private void addltr(Node n, String str, int idx, int i){
        if(n.next[str.charAt(idx)-'a'] == null) n.next[str.charAt(idx)-'a'] = new Node();

        if(idx == str.length()-1){
            n.next[str.charAt(idx)-'a'].val = i;
        }else{
            addltr(n.next[str.charAt(idx)-'a'], str, idx+1, i);
        }
    }

    private void addrtl(Node n, String str, int idx, int i){
        if(n.next[str.charAt(idx)-'a'] == null) n.next[str.charAt(idx)-'a'] = new Node();

        if(idx == 0){
            n.next[str.charAt(idx)-'a'].val = i;
        }else{
            addrtl(n.next[str.charAt(idx)-'a'], str, idx-1, i);
        }
    }

    private void checkrtl(Node n, String str, int idx, int i, List<List<Integer>> res){
        if(n.next[str.charAt(idx)-'a'] == null) return;

        if(n.next[str.charAt(idx)-'a'].val >= 0){
            if(isPalin(str, 0, idx-1) && i != n.next[str.charAt(idx)-'a'].val){
                int hash = getHash(n.next[str.charAt(idx)-'a'].val, i);
                if(!set.contains(hash)) {
                    set.add(hash);
                    res.add(Arrays.asList(n.next[str.charAt(idx)-'a'].val, i));
                }
            }
        }

        if(idx > 0){
            checkrtl(n.next[str.charAt(idx)-'a'], str, idx-1, i, res);
        }
    }
    
    private int getHash(int i, int j) {
        return 10000 * i + j;
    }

    private void checkltr(Node n, String str, int idx, int i, List<List<Integer>> res){
        if(n.next[str.charAt(idx)-'a'] == null) return;

        if(n.next[str.charAt(idx)-'a'].val >= 0){
            if(isPalin(str, idx+1, str.length()-1) && i != n.next[str.charAt(idx)-'a'].val){
                int hash = getHash(i, n.next[str.charAt(idx)-'a'].val);
                if(!set.contains(hash)) {
                    set.add(hash);
                    res.add(Arrays.asList(i, n.next[str.charAt(idx)-'a'].val));
                }
            }
        }

        if(idx < str.length()-1){
            checkltr(n.next[str.charAt(idx)-'a'], str, idx+1, i, res);
        }
    }

    private boolean isPalin(String str, int l, int r){
        while(l < r){
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        set = new HashSet<>();
        root = new Node();
        for(int i = 0; i < words.length; i++){
            if(words[i].length() > 0) addltr(root, words[i], 0, i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(words[i].length() > 0) {
                checkrtl(root, words[i], words[i].length()-1, i, res);
            }
            else{
                for(int j = 0; j < words.length; j++){
                    if(j != i && isPalin(words[j], 0, words[j].length()-1)){
                        res.add(Arrays.asList(i, j));
                        res.add(Arrays.asList(j, i));
                    }
                }
            }
        }

        root = new Node();
        for(int i = 0; i < words.length; i++){
            if(words[i].length() > 0) addrtl(root, words[i], words[i].length()-1, i);
        }

        for(int i = 0; i < words.length; i++){
            if(words[i].length() > 0) {
                checkltr(root, words[i], 0, i, res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PalindromePairs test = new PalindromePairs();
        List<List<Integer>> res = test.palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"});
        for(List<Integer> l : res){
            System.out.println(l.get(0) + "," + l.get(1));
        }
    }
    
}