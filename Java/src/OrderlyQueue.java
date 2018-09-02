import java.util.ArrayList;
import java.util.Collections;

public class OrderlyQueue {
	
    public String orderlyQueue(String S, int K) {
        int[] count = new int[26];
        for(int i = 0; i <S.length(); i++) {
        	count[S.charAt(i) - 'a']++;
        }
        
        
        
        char start = 'a';
        for(int i = 0; i < 26; i++) {
        	if(count[i] > 0) {
        		start = (char) ('a' + i);
        		break;
        	}
        }
        
        if(K > 1) {
        	String res = "";
        	for(int i = 0; i < 26; i++) {
        		for(int j = 0; j < count[i]; j++) {
        			res = res + (char)('a'+i);
        		}
        	}
        	return res;
        }
        
        
        ArrayList<String> list = new ArrayList<String>();
        
        int si = 0;
        while(true) {
        	int index = S.indexOf(start, si);
        	if(index < 0) break;
        	String cand;
        	if(index != 0) {
        		cand = S.substring(index, S.length()) + S.substring(0, index);
        	}else {
        		cand = S;
        	}
        	list.add(cand);
        	si = index + 1;
        }
        
        Collections.sort(list);
        return list.get(0);
        
    }
    
    public static void main(String[] args) {
    	OrderlyQueue test = new OrderlyQueue();
    	
    	System.out.println(test.orderlyQueue("baaca", 3));
    }
    
}
