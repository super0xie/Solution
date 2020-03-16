import java.util.Arrays;
import java.util.List;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
	
	private int res;
	public int maxLength(List<String> arr) {
		dfs(0, arr, new boolean[26], 0);
		
		return res;
    }
	
	
	private void dfs(int i, List<String> arr, boolean[] visited, int n) {
		if(i == arr.size()) return;
		
		dfs(i+1, arr, visited, n);
		String str = arr.get(i);
		int count = n;
		
		int j = 0;
		for(j = 0; j < str.length(); j++) {
			if(visited[str.charAt(j)-'a']) {
				for(int k = 0; k < j; k++) {
					visited[str.charAt(k)-'a'] = false;
				}
				break;
			}
			visited[str.charAt(j)-'a'] = true;
			count++;
		}
		
		if(j == str.length()) {
			res = Math.max(res, count);
			dfs(i+1, arr, visited, count);
			for(j = 0; j < str.length(); j++) {
				visited[str.charAt(j)-'a'] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		MaximumLengthofaConcatenatedStringwithUniqueCharacters test = new MaximumLengthofaConcatenatedStringwithUniqueCharacters();
		System.out.println(test.maxLength(Arrays.asList("pxa","ghxqdobesypaz","rismkaxhlc","eyxq")));
	}
	
	
	
	
	
}
