import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class DesignSearchAutocompleteSystem {
	
//	class Node{
//		Node[] next;
//		ArrayList<String> l;
//		
//		Node() {
//			next = new Node[27];
//			l = new ArrayList<>();
//		}
//	}
//	
//	private Node root;
//	private HashMap<String, Integer> count;
//	private Node cur;
//	private StringBuilder sb;
//	
//	private Comparator<String> cmp = new Comparator<>() {
//
//		@Override
//		public int compare(String o1, String o2) {
//			int c1 = count.get(o1);
//			int c2 = count.get(o2);
//			
//			if(c1 != c2) return c2 - c1;
//			else {
//				return o1.compareTo(o2);
//			}
//		}
//		
//	};
//	
//	
//	public void AutocompleteSystem(String[] sentences, int[] times) {
//        root = new Node();
//        count = new HashMap<>();
//        cur = root;
//        sb = new StringBuilder();
//        
//        for(int i = 0; i < sentences.length; i++) {
//        	count.put(sentences[i], times[i]);
//        	add(root, sentences[i], 0);
//        }
//        
//    }
//	
//	private void add(Node n, String str, int i) {
//		int idx = getIdx(str.charAt(i));
//		if(n.next[idx] == null) n.next[idx] = new Node();
//		if(!n.next[idx].l.contains(str))
//			n.next[idx].l.add(str);
//		Collections.sort(n.next[idx].l, cmp);
//		if(i != str.length()-1) {
//			add(n.next[idx], str, i+1);
//		}
//	}
//	
//	private int getIdx(char c) {
//		if(c == ' ') return 26;
//		else return (int)(c-'a');
//	}
//	
//	
//    
//    public List<String> input(char c) {
//    	if(c != '#') {
//    		sb.append(c);
//    		int idx = getIdx(c);
//            List<String> res = new ArrayList<>();
//            if(cur == null || cur.next[idx] == null) {
//            	cur = null;
//            	return res;
//            } else {
//            	for(int i = 0; i < Math.min(3, cur.next[idx].l.size()); i++) res.add(cur.next[idx].l.get(i));
//                cur = cur.next[idx];
//                return res;
//            }
//            
//    	}else {
//    		cur = root;
//    		String str = sb.toString();
//    		sb = new StringBuilder();
//    		count.put(str, count.getOrDefault(str, 0)+1);
//    		add(root, str, 0);
//    		return new ArrayList<>();
//    	}
//    }
	
	
	class Node{
		Node[] next;
		ArrayList<StrWithCount> l;
		
		Node() {
			next = new Node[27];
			l = new ArrayList<>();
		}
	}
	
	class StrWithCount{
		String str;
		int count;
		
		StrWithCount(String s, int n){
			str = s;
			count = n;
		}
		
	}
	
	private Node root;
	private HashMap<String, StrWithCount> map;
	private Node cur;
	private StringBuilder sb;
	
	private Comparator<StrWithCount> cmp = new Comparator<StrWithCount>() {

		@Override
		public int compare(StrWithCount o1, StrWithCount o2) {
			
			if(o1.count != o2.count) return o2.count - o1.count;
			else {
				return o1.str.compareTo(o2.str);
			}
		}
		
	};
	
	
	public void AutocompleteSystem(String[] sentences, int[] times) {
        root = new Node();
        map = new HashMap<>();
        cur = root;
        sb = new StringBuilder();
        
        for(int i = 0; i < sentences.length; i++) {
        	StrWithCount str = new StrWithCount(sentences[i], times[i]);
        	map.put(sentences[i], str);
        	add(root, str, 0, true);
        }
        
    }
	
	private void add(Node n, StrWithCount str, int i, boolean newStr) {
		int idx = getIdx(str.str.charAt(i));
		if(n.next[idx] == null) n.next[idx] = new Node();
		if(newStr)
			n.next[idx].l.add(str);
		
		if(i != str.str.length()-1) {
			add(n.next[idx], str, i+1, newStr);
		}
	}
	
	private int getIdx(char c) {
		if(c == ' ') return 26;
		else return (int)(c-'a');
	}
    
    public List<String> input(char c) {
    	if(c != '#') {
    		sb.append(c);
    		int idx = getIdx(c);
            List<String> res = new ArrayList<>();
            if(cur == null || cur.next[idx] == null) {
            	cur = null;
            	return res;
            } else {
            	ArrayList<StrWithCount> l = cur.next[idx].l;
            	Collections.sort(l, cmp);
            	for(int i = 0; i < Math.min(3, l.size()); i++) res.add(l.get(i).str);
                cur = cur.next[idx];
                return res;
            }
            
    	} else {
    		cur = root;
    		String str = sb.toString();
    		sb = new StringBuilder();
    		boolean newStr = !map.containsKey(str);
    		StrWithCount s = null;
    		if(newStr) {
    			s = new StrWithCount(str, 1);
    			map.put(str, s);
    		} else {
    			s = map.get(str);
    			s.count++;
    		}
    			
    		add(root, s, 0, newStr);
    		return new ArrayList<>();
    	}
    }
    

    
    public static void main(String[] args) {
    	DesignSearchAutocompleteSystem test = new DesignSearchAutocompleteSystem();
    	String[] sentences = {"abc","abbc","a"};
    	int[] times = {3,3,3};
    	test.AutocompleteSystem(sentences, times);
    	List<String> res = null;
    	
    	for(int i = 0; i < 2; i++) {
    		res = test.input('b');
        	for(String str : res) System.out.print(str + ", ");
        	System.out.println(" ");
        	
        	res = test.input('c');
        	for(String str : res) System.out.print(str + ", ");
        	System.out.println(" ");
        	
        	res = test.input('#');
        	for(String str : res) System.out.print(str + ", ");
        	System.out.println(" ");
    	}
//    	
//    	for(int i = 0; i < 4; i++) {
//    		res = test.input('i');
//        	for(String str : res) System.out.print(str + ", ");
//        	System.out.println(" ");
//        	
//        	res = test.input(' ');
//        	for(String str : res) System.out.print(str + ", ");
//        	System.out.println(" ");
//        	
//        	res = test.input('a');
//        	for(String str : res) System.out.print(str + ", ");
//        	System.out.println(" ");
//        	
//        	res = test.input('#');
//        	for(String str : res) System.out.print(str + ", ");
//        	System.out.println(" ");
//    	}
    	
    	
    	System.out.println(" ");
    }
	
}
