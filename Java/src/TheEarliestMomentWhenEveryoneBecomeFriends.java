import java.util.Arrays;

public class TheEarliestMomentWhenEveryoneBecomeFriends{

    private int numGroup;
    public int earliestAcq(int[][] logs, int N) {
        int[] uf = new int[N];
        for(int i = 0; i < N; i++) uf[i] = i;
        numGroup = N;

        Arrays.sort(logs, (a, b)->{
            return a[0]-b[0];
        });

        for(int i = 0; i < logs.length; i++){
            union(uf, logs[i][1], logs[i][2]);
            if(numGroup == 1) return logs[i][0];
        }

        return -1;

    }

    private int getRoot(int[] uf, int i){
        if(uf[i] == i) return i;
        int r = getRoot(uf, uf[i]);
        uf[i] = r;
        return r;
    }

    private void union(int[] uf, int i1, int i2){
        int r1 = getRoot(uf, i1);
        int r2 = getRoot(uf, i2);

        if(r1 != r2){
            uf[r1] = r2;
            numGroup--;
        }
    }

}