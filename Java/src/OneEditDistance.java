
public class OneEditDistance {
	
	public boolean isOneEditDistance(String s, String t) {
        if(s.length() != t.length()) {
        	String longer = null;
        	String shorter = null;
        	if(s.length() > t.length()) {
        		longer = s;
        		shorter = t;
        	}else {
        		longer = t;
        		shorter = s;
        	}
        	if(longer.length() - shorter.length() > 1) return false;
        	
//        	for(int i = 0; i < longer.length(); i++) {
//        		String aux = longer.substring(0, i) + longer.substring(i+1, longer.length());
//        		if(aux.equals(shorter)) return true;
//        	}
//        	return false;
        	
        	int count = 0;
        	int i = 0;
        	int j = 0;
        	
        	while(i < longer.length() && j < shorter.length()) {
        		if(s.charAt(i) == t.charAt(j)) {
        			i++;
        			j++;
        		}else {
        			count++;
        			if(count > 1) return false;
        			i++;
        		}
        	}
        	
        	return true;
        	
        }else {
        	int count = 0;
        	for(int i = 0; i < s.length(); i++) {
        		if(s.charAt(i) != t.charAt(i)) count++;
        	}
        	if(count == 1) return true;
        	return false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println("hello".substring(5, 5));
		
	}

}
