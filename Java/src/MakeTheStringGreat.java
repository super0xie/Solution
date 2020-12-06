
public class MakeTheStringGreat {
	
	public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        boolean cont = true;
        while(cont) {
        	cont = false;
        	for(int i = 0; i < s.length(); i++) {
            	if(i < s.length()-1 && diff(s.charAt(i)) == diff(s.charAt(i+1)) && s.charAt(i) != s.charAt(i+1)) {
            		i = i+1;
            		cont = true;
            	}else {
            		sb.append(s.charAt(i));
            	}
            }
        	s = sb.toString();
        	sb = new StringBuilder();
        }
        
        return s;
    }
	
	private int diff(char c) {
		if(c >= 'a' && c <= 'z') return c-'a';
		return c-'A';
	}
	
	public static void main(String[] args) {
		String s = "leEeetcode";
		MakeTheStringGreat test = new MakeTheStringGreat();
		test.makeGood(s);
	}
}
