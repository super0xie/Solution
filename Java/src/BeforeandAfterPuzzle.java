import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BeforeandAfterPuzzle {
	
	class Phrase{
		String[] strs;
		
		Phrase(String str){
			strs = str.split(" ");
		}
	}
	
	public List<String> beforeAndAfterPuzzles(String[] phrases) {
		HashMap<String, ArrayList<Phrase>> head = new HashMap<>();
		HashMap<String, ArrayList<Phrase>> tail = new HashMap<>();
		HashSet<String> res = new HashSet<>();
		for(String str : phrases) {
			Phrase p = new Phrase(str);
			if(!head.containsKey(p.strs[0])) head.put(p.strs[0], new ArrayList<>());
			if(!tail.containsKey(p.strs[p.strs.length-1])) tail.put(p.strs[p.strs.length-1], new ArrayList<>());
			
			head.get(p.strs[0]).add(p);
			tail.get(p.strs[p.strs.length-1]).add(p);
		}
		
		for(String t : tail.keySet()) {
			
			if(head.containsKey(t)) {
				ArrayList<Phrase> pre = tail.get(t);
				ArrayList<Phrase> suf = head.get(t);
				for(int i = 0; i < pre.size(); i++) {
					for(int j = 0; j < suf.size(); j++) {
						if(pre.get(i) == suf.get(j)) continue;
						
						res.add(merge(pre.get(i), suf.get(j)));
					}
				}
				
			}
			
		}
		
		List<String> ret = new ArrayList<>();
		for(String str : res) ret.add(str);
		Collections.sort(ret);
		return ret;
    }
	
	private String merge(Phrase p1, Phrase p2) {
		StringBuilder sb = new StringBuilder();
		sb.append(p1.strs[0]);
		for(int i = 1; i < p1.strs.length; i++) sb.append(" " + p1.strs[i]);
		for(int i = 1; i < p2.strs.length; i++) sb.append(" " + p2.strs[i]);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		BeforeandAfterPuzzle test = new BeforeandAfterPuzzle();
		String[] phrases = {"a","b","a"};
		List<String> res = test.beforeAndAfterPuzzles(phrases);
		for(String str : res) System.out.println(str);
	}
}
