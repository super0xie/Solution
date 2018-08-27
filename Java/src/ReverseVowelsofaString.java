
public class ReverseVowelsofaString {
	
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        
        while(i < j) {
        	while(i < s.length() && !isVowel(chars[i])) i++;
        	while(j >= 0 && !isVowel(chars[j])) j--;
        	
        	if(i < j && i < s.length() && j >= 0) {
        		char temp = chars[i];
        		chars[i] = chars[j];
        		chars[j] = temp;
        		i++;
        		j--;
        	}
        }
        
        return String.valueOf(chars);
        
        
    }
    
    private boolean isVowel(char c) {
    	return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
	
    public static void main(String[] args) {
    	ReverseVowelsofaString test = new ReverseVowelsofaString();
    	System.out.println(test.reverseVowels("hello"));
    }

}
