
public class LongestHappyString {
	
	public String longestDiverseString(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		
        while(true) {
        	if(a == 0 && b == 0 && c == 0) break;
        	
        	int max = Math.max(a, Math.max(b, c));
        	
        	if(a == max) {
        		if(sb.length() < 2 || !(sb.charAt(sb.length()-1) == 'a' && sb.charAt(sb.length()-2) == 'a')) {
        			sb.append('a');
        			a--;
        		} else if(b >= c) {
        			if(b == 0) break;
        			sb.append('b');
        			b--;
        		} else {
        			sb.append('c');
        			c--;
        		}
        		
        	}else if(b == max) {
        		if(sb.length() < 2 || !(sb.charAt(sb.length()-1) == 'b' && sb.charAt(sb.length()-2) == 'b')) {
        			sb.append('b');
        			b--;
        		}else if(a >= c) {
        			if(a == 0) break;
        			sb.append('a');
        			a--;
        		}else {
        			sb.append('c');
        			c--;
        		}
        	}else {
        		if(sb.length() < 2 || !(sb.charAt(sb.length()-1) == 'c' && sb.charAt(sb.length()-2) == 'c')) {
        			sb.append('c');
        			c--;
        		}else if(a >= b) {
        			if(a == 0) break;
        			sb.append('a');
        			a--;
        		}else {
        			sb.append('b');
        			b--;
        		}
        	}
        	
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		LongestHappyString test = new LongestHappyString();
		System.out.println(test.longestDiverseString(7, 1, 0));
		
	}
	
}
