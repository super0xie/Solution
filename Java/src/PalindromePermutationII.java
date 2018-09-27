import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		int[] counts = new int [256];
        for(int i = 0; i < s.length(); i++) {
        	counts[s.charAt(i)]++;
        }
        int oddCount = 0;
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < 256; i++) {
        	if(counts[i] % 2 == 1) {
        		oddCount++;
        		if(oddCount > 1) return res;
        	}
        }
        
        dfs(counts, new StringBuilder(), s.length(), res);
        return res;
    }
	
	private void dfs(int[] counts, StringBuilder sb, int n, List<String> res) {
		for(int i = 0; i < counts.length; i++) {
			if(sb.length() * 2 == n-1 && counts[i]==1) {
				String str = sb.toString() + (char)i +  sb.reverse().toString();
				sb.reverse();
				res.add(str);
				break;
			}else if(sb.length() * 2 == n-2 && counts[i] > 1) {
				sb.append((char)i);
				String str = sb.toString() + sb.reverse().toString();
				sb.reverse();
				res.add(str);
				sb.deleteCharAt(sb.length()-1);
				break;
			}else {
				if(counts[i] > 1) {
					sb.append((char)i);
					counts[i]-=2;
					dfs(counts, sb, n, res);
					counts[i]+=2;
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		PalindromePermutationII test = new PalindromePermutationII();
		test.generatePalindromes("aabbcc");
	}
}
