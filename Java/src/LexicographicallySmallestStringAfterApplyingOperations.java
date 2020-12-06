import java.util.ArrayDeque;
import java.util.HashSet;

public class LexicographicallySmallestStringAfterApplyingOperations {
	
	public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> visited = new HashSet<>();
        visited.add(s);
        ArrayDeque<String> q = new ArrayDeque<>();
        q.add(s);
        while(!q.isEmpty()) {
        	String p = q.poll();
        	char[] chars = p.toCharArray();
        	for(int i = 1; i < chars.length; i+=2) {
        		int n = chars[i]-'0';
        		n += a;
        		if(n >= 10) n -= 10;
        		chars[i] = (char)(n + '0');
        	}
        	String ns = String.valueOf(chars);
        	if(!visited.contains(ns)) {
        		visited.add(ns);
        		q.add(ns);
        	}
        	
        	chars = new char[p.length()];
        	int idx = 0;
        	for(int i = p.length()-b; i < p.length(); i++) {
        		chars[idx++] = p.charAt(i);
        	}
        	for(int i = 0; i < p.length()-b; i++) {
        		chars[idx++] = p.charAt(i);
        	}
        	
        	ns = String.valueOf(chars);
        	if(!visited.contains(ns)) {
        		visited.add(ns);
        		q.add(ns);
        	}
        }
        
        String min = null;
        for(String str : visited) {
        	if(min == null) min = str;
        	else {
        		if(min.compareTo(str) > 0) min = str;
        	}
        }
        return min;
    }
	
	public static void main(String[] args) {
		LexicographicallySmallestStringAfterApplyingOperations test = new LexicographicallySmallestStringAfterApplyingOperations();
		test.findLexSmallestString("43987654", 7, 3);
	}
	
}
