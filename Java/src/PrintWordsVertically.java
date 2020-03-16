import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
	
	public List<String> printVertically(String s) {
        String[] strs = s.split(" ");
        int[] idx = new int[strs.length];
        List<String> res = new ArrayList<>();
        while(true) {
        	boolean cont = false;
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < strs.length; i++) {
        		if(idx[i] < strs[i].length()) {
        			cont = true;
        			sb.append(strs[i].charAt(idx[i]++));
        		}else {
        			sb.append(" ");
        		}
        	}
        	
        	if(cont) {
        		int j = sb.length()-1;
        		while(sb.charAt(j) == ' ') j--;
        		res.add(sb.substring(0, j+1));
        	} else {
        		break;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		PrintWordsVertically test = new PrintWordsVertically();
		List<String> res = test.printVertically("CONTEST IS COMING");
		for(String s : res)
			System.out.println(s);
	}
	
}
