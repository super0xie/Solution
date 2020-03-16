
public class SumofEvenNumbersAfterQueries {
	
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        for(int i : A) {
        	if(i % 2 == 0) sum+=i;
        }
        
        for(int i = 0; i < queries.length; i++) {
        	int v = queries[i][0];
        	int idx = queries[i][1];
        	
        	if(A[idx] % 2 == 0) sum -= A[idx];
        	A[idx] += v;
        	if(A[idx] % 2 == 0) sum += A[idx];
        	
        	res[i] = sum;
        }
        
        return res;
		
    }
	
	public static void main(String[] args) {
		SumofEvenNumbersAfterQueries test = new SumofEvenNumbersAfterQueries();
		int[] A = {1,2,3,4};
		int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
		test.sumEvenAfterQueries(A, queries);
	}
}
