
public class QueriesonaPermutationWithKey {
	public int[] processQueriesOld(int[] queries, int m) {
        int[] idx = new int[m+1];
        for(int i = 1; i < m+1; i++) {
        	idx[i] = i-1;
        }
        
        int[] res = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
        	res[i] = idx[queries[i]];
        	for(int j = 1; j < m+1; j++) {
        		if(idx[j] < idx[queries[i]]) {
        			idx[j]++;
        		}
        	}
        	idx[queries[i]] = 0;
        }
        
        return res;
    }
	
	public int[] processQueries(int[] queries, int m) {
		int n = queries.length;
        int[] idx = new int[m+1];
        BinaryIndexedTree t = new BinaryIndexedTree(m+n+1);
        for(int i = 1; i < m+1; i++) {
        	t.modify(n+i-1, 1);
        	idx[i] = n + i-1;
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
        	int oidx = idx[queries[i]];
        	int nidx = n-1-i;
        	res[i] = t.get(0, oidx)-1;
        	t.modify(oidx, -1);
        	t.modify(nidx, 1);
        	idx[queries[i]] = n-1-i;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		QueriesonaPermutationWithKey test = new QueriesonaPermutationWithKey();
		int[] res = test.processQueries(new int[] {7,5,5,8,3}, 8);
		for(int i : res) {
			System.out.print(i);
		}
	}
}
