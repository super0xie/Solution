import java.util.Arrays;

public class RearrangeWordsinaSentence {
	
	class Node{
		String str;
		int idx;
		
		Node(String s, int i){
			str = s;
			idx = i;
		}
	}
	
	public String arrangeWords(String text) {
        String[] strs = text.split(" ");
        Node[] aux = new Node[strs.length];
        for(int i = 0; i < strs.length; i++) aux[i] = new Node(strs[i], i);
        Arrays.sort(aux, (a, b)->{
        	if(a.str.length() != b.str.length()) {
        		return a.str.length()-b.str.length();
        	}else {
        		return a.idx - b.idx;
        	}
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < aux.length; i++) {
        	if(i == 0) {
        		char c = aux[i].str.charAt(0);
        		if(c >= 'a' && c <= 'z') sb.append((char)('A' + c-'a'));
        		else sb.append(c);
        		sb.append(aux[i].str.substring(1));
        	}
        	else sb.append(aux[i].str.toLowerCase());
        	if(i != aux.length-1) sb.append(" ");
        }
        return sb.toString();
    }
	
}
