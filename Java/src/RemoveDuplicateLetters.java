
public class RemoveDuplicateLetters {
	
    public String removeDuplicateLetters(String s) {
    	if(s.length() == 0) return s;
    	if(s.length() == 1) return s;
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
        	count[s.charAt(i) - 'a']++;
        }
        
        int minPosition = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) < s.charAt(minPosition)) minPosition = i;
        	count[s.charAt(i)-'a']--;
        	if(count[s.charAt(i)-'a'] == 0) break;
        }
        
        String result = ""+s.charAt(minPosition);
        result += removeDuplicateLetters(s.substring(minPosition+1).replace(""+s.charAt(minPosition), ""));
        return result;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicateLetters test = new RemoveDuplicateLetters();
    	System.out.println(test.removeDuplicateLetters("bcabc"));
    	
    }

}
