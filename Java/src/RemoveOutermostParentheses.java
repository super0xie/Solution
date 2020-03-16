
public class RemoveOutermostParentheses {
	
	public String removeOuterParentheses(String S) {
		int count = 0;
		int left = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '(') {
				if(count == 0) {
					left = i;
				}
				count++;
			}else {
				count--;
				if(count == 0) {
					sb.append(S.substring(left+1, i));
				}
			}
		}
		return sb.toString();
        
    }

}
