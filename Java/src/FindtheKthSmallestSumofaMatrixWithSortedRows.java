import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class FindtheKthSmallestSumofaMatrixWithSortedRows {
	
	class Aux{
		int sum;
		int[] idx;
		
		Aux(int s, int[] idx){
			this.sum = s;
			this.idx = idx;
		}
	}
	
	public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        PriorityQueue<Aux> pq = new PriorityQueue<>((a, b)-> {return a.sum-b.sum;});
        int[] idx = new int[m];
        int sum = 0;
        for(int i = 0; i < m; i++) sum += mat[i][0];
        
        pq.add(new Aux(sum, idx));
        int count = 0;
        int cur = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(encode(idx));
        while(count < k) {
        	Aux p = pq.poll();
        	count++;
        	cur = p.sum;
        	for(int i = 0; i < m; i++) {
        		if(p.idx[i] < n-1) {
        			int[] copy = Arrays.copyOf(p.idx, m);
        			copy[i]++;
        			String en = encode(copy);
        			if(!visited.contains(en)) {
        				visited.add(en);
        				pq.add(new Aux(p.sum + mat[i][p.idx[i]+1] - mat[i][p.idx[i]], copy));
        			}
        				
        		}
        	}
        	
        }
        
        return cur;
    }
	
	private String encode(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i : arr) sb.append(i + ",");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		FindtheKthSmallestSumofaMatrixWithSortedRows test = new FindtheKthSmallestSumofaMatrixWithSortedRows();
		int[][] mat = {{1,1,10},{2,2,9}};
		System.out.println(test.kthSmallest(mat, 7));
	}
	
}
