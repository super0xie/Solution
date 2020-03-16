public class MaximumSumof3NonOverlappingSubarrays{

    public int[] maxSumOfThreeSubarraysOld(int[] nums, int k) {
        int[][] dpa = new int[nums.length][2];

        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        dpa[k-1][0]= sum;
        dpa[k-1][1] = 0;
        int max = sum;
        int maxStart = 0;

        for(int i = k; i < nums.length; i++){
            sum += nums[i];
            sum -= nums[i-k];
            if(sum > max){
                max = sum;
                maxStart = i-k+1;
            }
            dpa[i][0] = max;
            dpa[i][1] = maxStart;
        }


        int[][] dpb = new int[nums.length][2];
        sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[nums.length-1-i];
        }
        dpb[nums.length-k][0] = sum;
        dpb[nums.length-k][1] = nums.length-k;
        max = sum;
        maxStart = nums.length-k;

        for(int i = nums.length-1-k; i >= 0; i--){
            sum += nums[i];
            sum -= nums[i+k];

            if(sum >= max){
                max = sum;
                maxStart = i;
            }

            dpb[i][0] = max;
            dpb[i][1] = maxStart;
        }


        int midSum = 0;
        for(int i = k; i < k * 2; i++){
            midSum += nums[i];
        }

        max = dpa[k-1][0] + midSum + dpb[2*k][0];
        int[] res = {dpa[k-1][1], k, dpb[2*k][1]};

        for(int i = k+1; i <= nums.length-2*k; i++){
            midSum += nums[i + k - 1];
            midSum -= nums[i-1];

            sum = dpa[i-1][0] + midSum + dpb[i+k][0];
            if(sum > max){
                max = sum;
                res = new int[] {dpa[i-1][1], i, dpb[i+k][1]};
            }
        }

        return res;
    }


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] windowSum = new int[nums.length+1-k];
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        windowSum[0] = sum;
        for(int i = 1; i <= nums.length-k; i++){
            sum += nums[i+k-1];
            sum -= nums[i-1];
            windowSum[i] = sum;
        }

        int[][] dpa = new int[nums.length][2];

        int max = 0;
        int maxStart = 0;

        for(int i = k-1; i < nums.length; i++){
            sum = windowSum[i-k+1];
            if(sum > max){
                max = sum;
                maxStart = i-k+1;
            }
            dpa[i][0] = max;
            dpa[i][1] = maxStart;
        }

        int[][] dpb = new int[nums.length][2];
        
        max = 0;
        maxStart = 0;

        for(int i = nums.length-k; i >= 0; i--){
            sum = windowSum[i];
            if(sum >= max){
                max = sum;
                maxStart = i;
            }
            dpb[i][0] = max;
            dpb[i][1] = maxStart;
        }

        max = 0;
        int[] res = null;

        for(int i = k; i <= nums.length-2*k; i++){
            int midSum = windowSum[i];
            sum = dpa[i-1][0] + midSum + dpb[i+k][0];
            if(sum > max){
                max = sum;
                res = new int[] {dpa[i-1][1], i, dpb[i+k][1]};
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        MaximumSumof3NonOverlappingSubarrays test = new MaximumSumof3NonOverlappingSubarrays();
        System.out.println(test.maxSumOfThreeSubarrays(nums, k));  
    }

}