import java.util.PriorityQueue;

public class OptimizeWaterDistributioninaVillage {
	
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[2]-b[2];
        });
		
		for(int[] p : pipes){
            pq.add(p);
        }
		
		for(int i = 0; i < wells.length; i++) pq.add(new int[] {0, i+1, wells[i]});
		
		int count = 0;
        int sum = 0;
        int[] uf = new int[n+1];
        for(int i = 0; i < uf.length; i++) uf[i] = i;
        
        while(!pq.isEmpty()){
            int[] con = pq.poll();
            int r1 = getRoot(uf, con[0]);
            int r2 = getRoot(uf, con[1]);
            if(r1 == r2) continue;

            union(uf, con[0], con[1]);
            count++;
            sum += con[2];
            if(count == n) return sum;
        }
        
        return sum;
    }
	
	private int getRoot(int[] uf, int i){
        if(uf[i] == i) return i;
        else {
            int r = getRoot(uf, uf[i]);
            uf[i] = r;
            return r;
        }
    }

    private void union(int[] uf, int i, int j){
        int r1 = getRoot(uf, i);
        int r2 = getRoot(uf, j);
        if(r1 != r2)
            uf[r1] = r2;
    }
	
}
