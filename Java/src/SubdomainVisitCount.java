import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {
	
	public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : cpdomains) {
        	String[] arr = str.split("[ .]");
        	int c = Integer.parseInt(arr[0]);
        	String aux = "";
        	for(int i = arr.length-1; i >= 1; i--) {
        		if(aux.length() > 0) aux = "." + aux;
        		aux = arr[i] + aux;
        		map.put(aux, map.getOrDefault(aux, 0)+c);
        	}
        }
        
        List<String> res = new ArrayList<>();
        for(String key : map.keySet()) {
        	res.add(map.get(key) + " " + key);
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] arr = "9001 discuss.leetcode.com".split("[ .]");
		System.out.println("test");
	}
	
}
