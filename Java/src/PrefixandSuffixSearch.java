import java.util.ArrayList;
import java.util.HashSet;


public class PrefixandSuffixSearch {
	
	
	private class TrieNode{
		TrieNode[] next;
		ArrayList<Integer> l;
		HashSet<Integer> map;
		TrieNode(){
			next = new TrieNode [26];
			l = new ArrayList<>();
			map = new HashSet<>();
		}
	}
	
	
	private void insert(TrieNode node, String str, int i, boolean forward, int n) {
		
		int idx = str.charAt(i)-'a';
		if(node.next[idx] == null) {
			node.next[idx] = new TrieNode();
		}
		
		if(forward)
			node.next[idx].l.add(n);
		else
			node.next[idx].map.add(n);
		
		if(i != str.length()-1) {
			insert(node.next[idx], str, i+1, forward, n);
		}
		
	}
	
	private ArrayList<Integer> fsearch(TrieNode node, String str, int i) {
		int idx = str.charAt(i)-'a';
		if(node.next[idx] == null) return null;
		
		if(i != str.length()-1) {
			return fsearch(node.next[idx], str, i+1);
		}else {
			return node.next[idx].l;
		}
	}
	
	private HashSet<Integer> bsearch(TrieNode node, String str, int i) {
		int idx = str.charAt(i)-'a';
		if(node.next[idx] == null) return null;
		
		if(i != str.length()-1) {
			return bsearch(node.next[idx], str, i+1);
		}else {
			return node.next[idx].map;
		}
	}
	
	private TrieNode froot = new TrieNode();
	private TrieNode broot = new TrieNode();
	private ArrayList<Integer> dic = new ArrayList<>();
	private HashSet<Integer> dicSet = new HashSet<>();
	
	public void WordFilter(String[] words) {
		
		
        for(int i = words.length-1; i >= 0; i--) {
        	dic.add(i);
        	dicSet.add(i);
        	insert(froot, words[i], 0, true, i);
        	String rev = new StringBuilder(words[i]).reverse().toString();
        	insert(broot, rev, 0, false, i);
        }
    }
    
    public int f(String prefix, String suffix) {
    	ArrayList<Integer> list = null;
    	if(prefix.length() != 0) {
    		list = fsearch(froot, prefix, 0);
    		if(list == null) return -1;
    	}else {
    		list = dic;
    	}
    	
    	HashSet<Integer> set = null;
    	if(suffix.length() != 0) {
    		String rev = new StringBuilder(suffix).reverse().toString();
    		set = bsearch(broot, rev, 0);
        	if(set == null) return -1;
    	}else {
    		set = dicSet;
    	}
    	
    	for(int i : list) {
    		if(set.contains(i)) return i;
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	PrefixandSuffixSearch test = new PrefixandSuffixSearch();
    	String[] words = {"pop"};
    	test.WordFilter(words);
    	System.out.println(test.f("", "op"));
    }
}
