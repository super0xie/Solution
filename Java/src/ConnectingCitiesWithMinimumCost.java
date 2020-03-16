import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {

    public int minimumCost(int N, int[][] connections) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[2]-b[2];
        });
        
        for(int[] con : connections){
            pq.add(con);
        }

        int count = 0;
        int sum = 0;
        int[] uf = new int[N+1];
        for(int i = 0; i < uf.length; i++) uf[i] = i;

        while(!pq.isEmpty()){
            int[] con = pq.poll();
            int r1 = getRoot(uf, con[0]);
            int r2 = getRoot(uf, con[1]);
            if(r1 == r2) continue;

            union(uf, con[0], con[1]);

            count++;
            sum += con[2];
            if(count == N-1) return sum;
        }

        return -1;
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

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost test = new ConnectingCitiesWithMinimumCost();
        int[][] conn = {{1,2,3},{3,4,4}};
        System.out.print(test.minimumCost(4, conn));
    }

}
