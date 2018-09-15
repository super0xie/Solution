import java.util.Arrays;

public class FindAndReplaceinString {
	
	private class Replace{
		int index;
		String source;
		String target;
		Replace(int index, String source, String target){
			this.index = index;
			this.source = source;
			this.target = target;
		}
		
		
	}
	
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		
		
		Replace[] replace = new Replace[indexes.length];
		
		for(int i = 0; i < indexes.length; i++) {
			replace[i] = new Replace(indexes[i], sources[i], targets[i]);
		}
		
		Arrays.sort(replace, (a, b)->{return a.index - b.index;});
		
		
		int index = 0;
		String res = "";
		for(int i = 0; i < S.length(); i++) {
			if(index < indexes.length && i == replace[index].index) {
				if(S.startsWith(replace[index].source, i)) {
					res += replace[index].target;
					i = i + replace[index].source.length()-1;
				}else {
					res += S.charAt(i);
				}
				index++;
			}else {
				res += S.charAt(i);
			}
		}
		
		return res;
        
    }
	
	public static void main(String[] args) {
		String S = "vmokgggqzp";
		int[] indexes = {3,5,1};
		String[] sources = {"kg","ggq","mo"};
		String[] targets = {"s","so","bfr"};
		
		FindAndReplaceinString test = new FindAndReplaceinString();
		test.findReplaceString(S, indexes, sources, targets);
	}

}
