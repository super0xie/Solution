import java.util.ArrayList;

public class ThekthLexicographicalStringofAllHappyStringsofLengthn {
	private int idx = 0;
	
	public String getHappyString(int n, int k) {
		ArrayList<String> strs = new ArrayList<>();
		String res = dfs(new char[n], 0, strs, k);
		if(res != null) return res;
		return "";
    }
	
	private String dfs(char[] arr, int i, ArrayList<String> res, int k) {
		for(char c = 'a'; c <= 'c'; c++) {
			if(i == 0 || arr[i-1] != c) {
				arr[i] = c;
				if(i == arr.length-1) {
					idx++;
					if(k == idx) return String.valueOf(arr);
				}else {
					String ret = dfs(arr, i+1, res, k);
					if(ret != null) return ret;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ThekthLexicographicalStringofAllHappyStringsofLengthn test = new ThekthLexicographicalStringofAllHappyStringsofLengthn();
		System.out.println(test.getHappyString(1, 3));
	}
	
}
