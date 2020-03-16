
public class XORQueriesofaSubarray {
	
	public int[] xorQueries(int[] arr, int[][] queries) {
        int[] sums = new int[32];
        int[][] pre = new int[arr.length][32];
        for(int i = 0; i < arr.length; i++) {
        	int n = arr[i];
        	for(int j = 0; j < 32; j++) {
        		sums[j] += n % 2;
        		n = n / 2;
        		pre[i][j] = sums[j];
        	}
        }
        
        
        int[] res = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
        	
        	int l = queries[i][0];
        	int r = queries[i][1];
        	int d = 1;
        	int num = 0;
        	
        	for(int j = 0; j < 32; j++) {
        		int count = 0;
        		if(l != 0) count = pre[r][j] - pre[l-1][j];
        		else count = pre[r][j];
        		
        		if(count % 2 == 1) num += d;
        		d = d * 2;
        	}
        	
        	res[i] = num;
        }
        
        return res;
    }
	
	
	public static void main(String[] args) {
		XORQueriesofaSubarray test = new XORQueriesofaSubarray();
		int[] arr = {4,8,2,10};
		int[][] queries = {{2,3},{1,3},{0,0},{0,3}};
		int[] res = test.xorQueries(arr, queries);
		for(int i : res) System.out.println(i);
		
	}
	
}
