import java.util.HashSet;

public class PartitionEqualSubsetSum {

    public boolean canPartitionOld(int[] nums) {
        int sum = 0;
        int[] count = new int[101];
        for(int i : nums){
            count[i]++;
            sum += i;
        }

        if(sum % 2 != 0) return false;
        int tar = sum / 2;

        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = 1; i <= 100; i++){
            if(count[i] > 0){
                HashSet<Integer> aux = new HashSet<>();
                for(int n : set){
                    for(int j = 1; j <= count[i]; j++){
                        int toAdd = j * i;
                        int s = n + toAdd;
                        if(s == tar) return true;
                        if(s < tar - i) aux.add(s);
                    }
                }

                set.addAll(aux);
            }
        }
        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0) return false;
        int tar = sum / 2;
        boolean[] dp = new boolean[tar+1];
        dp[0] = true;
        for(int i : nums){
            for(int j = tar; j >= i; j--){
                dp[j] = dp[j] || dp[j-i];
            }
            if(dp[tar]) return true;
        }

        return dp[tar];
    }



    public static void main(String[] args) {
        PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
        int[] nums = {2, 2, 3, 5};
        System.out.print(test.canPartition(nums));
        
    }
}