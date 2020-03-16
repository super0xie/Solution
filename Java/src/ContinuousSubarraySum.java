import java.util.ArrayList;
import java.util.HashSet;

public class ContinuousSubarraySum {

    public boolean checkSubarraySumOld(int[] nums, int k) {
        if(k == 0){
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] == 0 && nums[i+1] == 0) return true;
            }
            return false;
        }
        if(k < 0) k = -k;
        boolean[] mod = new boolean[k];

        for(int i = 0; i < nums.length; i++){
            int m = nums[i] % k;
            boolean[] aux = new boolean[k];
            for(int j = 0; j < k; j++){
                if(mod[j]){
                    int idx = (j + m)%k;
                    aux[idx] = true;
                    if(idx == 0) return true;
                }
            }

            aux[m] = true;
            mod = aux;
        }

        return false;
    }

    public boolean checkSubarraySumTLE(int[] nums, int k) {
        if(k == 0){
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] == 0 && nums[i+1] == 0) return true;
            }
            return false;
        }
        if(k < 0) k = -k;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            HashSet<Integer> aux = new HashSet<>();
            for(int j : set){
                int sum = j + nums[i];
                int mod = sum % k;
                if(mod == 0) return true;
                aux.add(mod);
            }
            
            aux.add(nums[i] % k);
            set = aux;
        }

        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if(k == 0){
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] == 0 && nums[i+1] == 0) return true;
            }
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int sum = nums[0]%k;
        int tmp = sum;
        for(int i = 1; i < nums.length; i++){
            sum = (sum + nums[i])%k;
            if(set.contains(sum)) return true;
            set.add(tmp);
            tmp = sum;
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum test = new ContinuousSubarraySum();
        int[] nums = {1,2,3};
        System.out.print(test.checkSubarraySum(nums, 4));
    }

}