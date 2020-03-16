import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        HashSet<Integer> pre = new HashSet<>();
        pre.add(stones[0]);
        pre.add(-stones[0]);

        for(int i = 1; i < stones.length; i++){
            HashSet<Integer> cur = new HashSet<>();
            for(int p : pre){
                cur.add(p + stones[i]);
                cur.add(p - stones[i]);
            }
            pre = cur;
        }

        int res = Integer.MAX_VALUE;

        for(int i : pre){
            if(i >= 0) res = Math.min(res, i);
        }
    
        return res;
    }


    public static void main(String[] args) {
        LastStoneWeightII test = new LastStoneWeightII();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(test.lastStoneWeightII(stones));
    }



}