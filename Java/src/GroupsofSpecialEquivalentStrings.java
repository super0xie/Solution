import java.util.HashSet;

public class GroupsofSpecialEquivalentStrings {
	public int numSpecialEquivGroups(String[] A) {
		
		HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < A.length; i++) {
        	String str = A[i];
        	int [] count = new int [52];
        	for(int j = 0; j < str.length(); j++) {
        		char c = str.charAt(j);
        		if(j%2 == 0) {
        			count[c-'a']++;
        		}else {
        			count[c-'a'+ 26]++;
        		}
        	}
        	
        	StringBuffer sb = new StringBuffer();
        	for(int j = 0; j < 52; j++) {
        		sb.append(count[j]);
        	}
        	
        	set.add(sb.toString());
        	
        	
        }
        
        return set.size();
    }
	
	public static void main(String[] args) {
		GroupsofSpecialEquivalentStrings test = new GroupsofSpecialEquivalentStrings();
		String[] A = {"abc","acb","bac","bca","cab","cba"};
		
		System.out.println(test.numSpecialEquivGroups(A));
		
		
	}

}
