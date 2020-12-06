import java.util.PriorityQueue;

public class FindValidMatrixGivenRowandColumnSums {
	
	
	public int[][] restoreMatrixOld(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        while(true) {
        	int minR = -1;
        	int minC = -1;
        	int minSumR = Integer.MAX_VALUE;
        	int minSumC = Integer.MAX_VALUE;
        	
        	for(int i = 0; i < m; i++) {
        		if(rowSum[i] == 0) continue;
        		if(rowSum[i] < minSumR) {
        			minSumR = rowSum[i];
        			minR = i;
        		}
        	}
        	if(minSumR == Integer.MAX_VALUE) break;
        	minSumC = Integer.MAX_VALUE;
        	for(int i = 0; i < n; i++) {
        		if(colSum[i] == 0) continue;
        		if(colSum[i] < minSumC) {
        			minSumC = colSum[i];
        			minC = i;
        		}
        	}
        	if(minSumC == Integer.MAX_VALUE) break;
        	int min = Math.min(minSumR, minSumC);
        	rowSum[minR] -= min;
        	colSum[minC] -= min;
        	
        	res[minR][minC] = min;
        }
        
        
        return res;
    }
	
	class Pair{
		int v;
		int l;
		
		Pair(int v, int l){
			this.v = v;
			this.l = l;
		}
	}
	
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        
        PriorityQueue<Pair> rows = new PriorityQueue<>((a, b)->{return a.v-b.v;});
        PriorityQueue<Pair> cols = new PriorityQueue<>((a, b)->{return a.v-b.v;});
        
        for(int i = 0; i < m; i++) rows.add(new Pair(rowSum[i], i));
        for(int i = 0; i < n; i++) cols.add(new Pair(colSum[i], i));
        
        while(true) {
        	if(rows.isEmpty() || cols.isEmpty()) break;
        	
        	Pair r = rows.poll();
        	Pair c = cols.poll();
        	
        	int min = Math.min(r.v, c.v);
        	r.v -= min;
        	c.v -= min;
        	res[r.l][c.l] = min;
        	
        	if(r.v != 0) rows.add(r);
        	if(c.v != 0) cols.add(c);

        }
        
        return res;
    }
	
	
	public static void main(String[] args) {
		int[] rowSum = {14,9};
		int[] colSum = {6,9,8};
		FindValidMatrixGivenRowandColumnSums test = new FindValidMatrixGivenRowandColumnSums();
		int[][] res = test.restoreMatrix(rowSum, colSum);
		Utility.print2DArray(res);
	}
	
}
