
public class Hexspeak {
	
	public String toHexspeak(String num) {
        long n = Long.parseLong(num);
        String str = Long.toHexString(n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
        	if(str.charAt(i) >= '2' && str.charAt(i) <= '9') {
        		return "ERROR";
        	}else {
        		if(str.charAt(i) == '1') sb.append('I');
        		else if(str.charAt(i) == '0') sb.append('O');
        		else sb.append(Character.toUpperCase(str.charAt(i)));
        	}
        }
        
        
        
        return sb.toString();
        
        
    }
	
	public static void main(String[] args) {
		Hexspeak test = new Hexspeak();
		System.out.println(test.toHexspeak("3"));
	}
	
}
