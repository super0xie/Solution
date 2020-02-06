
public class VerbalArithmeticPuzzle {
	public boolean isSolvable(String[] words, String result) {
		
		
        int[] map = new int[26];
        
        boolean[] leadingChar = new boolean[26];
        boolean[] chars = new boolean[26];
        int count = 0;
        for(String str : words) {
        	leadingChar[str.charAt(0)-'A'] = true;
        	for(int i = 0; i < str.length(); i++) {
        		if(!chars[str.charAt(i)-'A']) count++;
        		chars[str.charAt(i)-'A'] = true;
        	}
        }
        leadingChar[result.charAt(0)-'A'] = true;
        for(int i = 0; i < result.length(); i++) {
        	if(!chars[result.charAt(i)-'A']) count++;
        	chars[result.charAt(i)-'A'] = true;
        }
        
        int[] c = new int[count];
        int idx = 0;
        
        for(int i = 0; i < chars.length; i++) {
        	if(chars[i]) c[idx++] = i;
        }
        
        boolean[] used = new boolean[10];
        
        
        return dfs(c, 0, map, words, result, leadingChar, used);
        
    }
	
	
	private boolean valid(String[] words, String result, int[] map) {
		int lsum = 0;
		
		for(String str : words) {
			int n = 0;
			for(int i = 0; i < str.length(); i++) {
				n = n * 10;
				n += map[str.charAt(i)-'A'];
			}
			
			lsum += n;
		}
		
		int rsum = 0;
		for(int i = 0; i < result.length(); i++) {
			rsum = rsum * 10;
			rsum += map[result.charAt(i)-'A'];
		}
		
		return lsum == rsum;
	}
	
	private boolean dfs(int[] chars, int i, int[] map, String[] words, String result, boolean[] leadingChar, boolean[] used) {
		if(i == chars.length) {
			if(valid(words, result, map)) {
				return true;
			}
			return false;
			
		}else {
			int start = 0;
			if(leadingChar[chars[i]]) start = 1;
			
			for(int j = start; j <= 9; j++) {
				if(used[j]) continue;
				
				map[chars[i]] = j;
				used[j] = true;
				
				if(dfs(chars, i+1, map, words, result, leadingChar, used)) return true;
				
				used[j] = false;
				
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		VerbalArithmeticPuzzle test = new VerbalArithmeticPuzzle();
		System.out.println(test.isSolvable(new String[] {"LEET","CODE"}, "POINT"));
	}
	
}
