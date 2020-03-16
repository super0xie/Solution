import java.util.HashSet;

public class SimilarStringGroups {
	
	public class UnionFind {
		
		int[] uf;
		
		UnionFind(int n){
			uf = new int[n];
			for(int i = 0; i < n; i++) {
				uf[i] = i;
			}
		}
		
		public int getRoot(int i) {
			if(uf[i] == i) return i;
			else {
				int r = getRoot(uf[i]);
				uf[i] = r;
				return r;
			}
		}
		
		public void union(int i, int j) {
			int r1 = getRoot(i);
			int r2 = getRoot(j);
			
			if(r1 != r2) {
				uf[r1] = r2;
			}
		}
	}
	
	public int numSimilarGroups(String[] A) {
        UnionFind uf = new UnionFind(A.length);
        
        for(int i = 0; i < A.length; i++) {
        	for(int j = i+1; j < A.length; j++) {
        		if(similar(A[i], A[j])) {
        			uf.union(i, j);
        		}
        	}
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < A.length; i++) {
        	set.add(uf.getRoot(i));
        }
        
        return set.size();
	}
	
	private boolean similar(String str1, String str2) {
		int a = 0, b = 0;
		int count = 0;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if(count == 0) {
					a = i;
					count++;
				}
				else if(count == 1) {
					b = i;
					count++;
				}
				else return false;
			}
		}
		
		if(count == 0) return true;
		if(count != 2) return false;
		
		if(str1.charAt(a) == str2.charAt(b) && str1.charAt(b) == str2.charAt(a)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		SimilarStringGroups test = new SimilarStringGroups();
		System.out.println(test.numSimilarGroups(new String[]{"tars","rats","arts","star"}));
	}
	
	
}
