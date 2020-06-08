import java.util.ArrayList;
import java.util.Collections;

public class MaxDifferenceYouCanGetFromChanginganInteger {
	public int maxDiff(int num) {
        boolean[] visited = new boolean[10];
        
        String str = String.valueOf(num);
        ArrayList<Integer> l = new ArrayList<>();
        l.add(num);
        for(int i = 0; i < str.length(); i++) {
        	if(visited[str.charAt(i)-'0']) continue;
        	visited[str.charAt(i)-'0'] = true;
        	char[] chars = str.toCharArray();
        	
        	for(int j = 0; j < chars.length; j++) {
        		if(chars[j] == str.charAt(i)) chars[j] = '9';
        	}
        	
        	l.add(Integer.parseInt(String.valueOf(chars)));
        	
        	chars = str.toCharArray();
        	char tar;
        	if(str.charAt(i) == str.charAt(0)) tar = '1';
        	else tar = '0';
        	
        	for(int j = 0; j < chars.length; j++) {
        		if(chars[j] == str.charAt(i)) chars[j] = tar;
        	}
        	
        	l.add(Integer.parseInt(String.valueOf(chars)));
        }
        
        Collections.sort(l);
        
        if(l.size() > 1) {
        	return l.get(l.size()-1)-l.get(0);
        }else return 0;
        
        
    }
	
	public static void main(String[] args) {
		MaxDifferenceYouCanGetFromChanginganInteger test = new MaxDifferenceYouCanGetFromChanginganInteger();
		System.out.println(test.maxDiff(9288));
	}
}
