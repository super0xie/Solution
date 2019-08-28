import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AnalyzeUserWebsiteVisitPattern {

	
	class Visit{
		int time;
		int web;
		
		Visit(int t, int w){
			time = t;
			web = w;
		}
	}
	
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int encode = 1;
        int n = username.length;
        for(String str : website){
            if(!map.containsKey(str)) {
            	map.put(str, encode);
            	encode++;
            }
        }
        
        String[] webs = new String[map.size()+1];
        for(String key : map.keySet()) webs[map.get(key)] = key;
        
        HashMap<String, ArrayList<Visit>> data = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
        	if(!data.containsKey(username[i])) data.put(username[i], new ArrayList<>());
        	data.get(username[i]).add(new Visit(timestamp[i], map.get(website[i])));
        }
        
        HashMap<Integer, Integer> m = new HashMap<>();
        int max = 0;
        for(String user : data.keySet()) {
        	HashSet<Integer> set = new HashSet<>();
        	ArrayList<Visit> l = data.get(user);
        	Collections.sort(l, (a, b)->{
        		return a.time - b.time;
        	});
        	
        	helper(l, 0, 0, 0, set);
        	
        	for(int i : set) {
        		int count = m.getOrDefault(i, 0)+1;
        		max = Math.max(max, count);
        		m.put(i, count);
        	}
        }
        
        
        ArrayList<String> results = new ArrayList<>();
       
        
        for(int key : m.keySet()) {
        	if(m.get(key) == max) {
        		int idx2 = key % 100;
        		int idx1 = (key / 100) % 100;
        		int idx0 = (key / 10000) % 100;
        		results.add(webs[idx0]  + " " + webs[idx1] + " " + webs[idx2]);
        	}
        }
        
        Collections.sort(results);
        String[] strs = results.get(0).split(" ");
        ArrayList<String> res = new ArrayList<>();
        for(String str : strs) res.add(str);
        return res;
    }
    
    private void helper(ArrayList<Visit> l, int i, int count, int encode, HashSet<Integer> codes) {
    	if(i == l.size()) return;
    	
    	helper(l, i+1, count, encode, codes);
    	encode = encode * 100 + l.get(i).web;
    	if(count == 2) {
    		codes.add(encode);
    	}else {
    		helper(l, i+1, count+1, encode, codes);
    	}
    	
    }
    
    public static void main(String[] args) {
    	AnalyzeUserWebsiteVisitPattern test = new AnalyzeUserWebsiteVisitPattern();
    	String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
    	int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
    	String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
    	System.out.print(test.mostVisitedPattern(username, timestamp, website));
    }
    
}