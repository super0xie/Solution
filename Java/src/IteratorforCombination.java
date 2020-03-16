import java.util.ArrayList;

public class IteratorforCombination {
	
	
	private ArrayList<String> strs;
	private int idx;
	
	
	public void CombinationIterator(String characters, int combinationLength) {
        strs = new ArrayList<>();
        int[] indice = new int[combinationLength];
        dfs(0, 0, indice, characters);
    }
	
	private void dfs(int i, int start, int[] indice, String characters) {
		if(i == indice.length) {
			char[] chars = new char[indice.length];
			for(int j = 0; j < indice.length; j++) {
				chars[j] = characters.charAt(indice[j]);
			}
			strs.add(String.valueOf(chars));
		}else {
			int left = indice.length-i;
			for(int j = start; characters.length()-j >= left ; j++) {
				indice[i] = j;
				dfs(i+1, j+1, indice, characters);
			}
		}
	}
	
    
    public String next() {
        return strs.get(idx++);
    }
    
    public boolean hasNext() {
        if(idx < strs.size()) return true;
        return false;
    }
    
    public static void main(String[] args) {
    	IteratorforCombination test = new IteratorforCombination();
    	test.CombinationIterator("abc", 2);
    	while(test.hasNext()) {
    		System.out.println(test.next());
    	}
    	
    }
}
