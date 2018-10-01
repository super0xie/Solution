
public class ReverseWordsinaStringIII {
	public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for(String str : strs) {
        	for(int i = str.length()-1; i >= 0; i--) {
        		sb.append(str.charAt(i));
        	}
        	sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
