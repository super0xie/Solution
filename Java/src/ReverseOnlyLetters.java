
public class ReverseOnlyLetters {
	
	public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        int j = S.length() - 1;
        for(int i = 0 ; i < S.length(); i++) {
        	if((S.charAt(i) <= 'z' && S.charAt(i) >= 'a') || (S.charAt(i) <= 'Z' && S.charAt(i) >= 'A')) {
        		while(j >= 0 && !(S.charAt(j) <= 'z' && S.charAt(j) >= 'a') && !(S.charAt(j) <= 'Z' && S.charAt(j) >= 'A')) j--;
        		sb.append(S.charAt(j));
        		j--;
        	}else {
        		sb.append(S.charAt(i));
        	}
        }
        
        return sb.toString();
    }
	
	public static void main(String[] ags) {
		ReverseOnlyLetters test = new ReverseOnlyLetters();
		System.out.println(test.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}
	
}
