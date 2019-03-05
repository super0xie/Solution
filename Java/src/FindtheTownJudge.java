public class FindtheTownJudge{

    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        boolean[] trustOther = new boolean[N+1];

        for(int[] t : trust){
            count[t[1]]++;
            trustOther[t[0]] = true;
        }
        int res = -1;
        for(int i = 1; i <= N; i++){
            if(count[i] == N-1 && !trustOther[i]){
                res = i;
                break;
            }
        }
        return res;
    }

}