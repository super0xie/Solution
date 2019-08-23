import java.util.HashMap;

public class NumberofDiceRollsWithTargetSum {

    public int numRollsToTargetOld(int d, int f, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = 1000000000 + 7;
        for(int i = 1; i <= f; i++) map.put(i, 1);

        for(int i = 2; i <= d; i++){
            HashMap<Integer, Integer> cur = new HashMap<>();
            for(int j = 1; j <= f; j++){
                for(int key : map.keySet()){
                    int sum = key + j;
                    if(sum <= target) {
                    	int val = (cur.getOrDefault(sum, 0)+map.get(key)) % mod;
                        cur.put(sum, val);
                    }
                }
            }
            map = cur;
        }

        return map.getOrDefault(target, 0);
    }
    
    public int numRollsToTarget(int d, int f, int target) {
        int[] pre = new int[1001];
        int mod = 1000000000 + 7;
        for(int i = 1; i <= f; i++) pre[i]=1;

        for(int i = 2; i <= d; i++){
            int[] cur = new int[1001]; 
            for(int j = 1; j <= f; j++){
                for(int k = 1; k <= 1000; k++){
                    int sum = k + j;
                    if(sum <= target) {
                    	int val = (cur[sum]+pre[k]) % mod;
                    	cur[sum] = val;
                    }
                }
            }
            pre = cur;
        }

        return pre[target];
    }

    public static void main(String[] args) {
        NumberofDiceRollsWithTargetSum test = new NumberofDiceRollsWithTargetSum();
        System.out.println(test.numRollsToTarget(30, 30, 500));
    }

}