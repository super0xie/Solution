import java.util.ArrayList;

public class OptimalDivision {

    private double max = Double.MIN_VALUE;
    private ArrayList<Integer> l;

    public String optimalDivisionBF(int[] nums) {
        if(nums.length == 1) return String.valueOf(nums[0]);
        l = new ArrayList<>();
        double [] arr = new double[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
        }

        helper(arr, new ArrayList<>());

        ArrayList<String> strs = new ArrayList<>();
        for(int i : nums){
            strs.add(String.valueOf(i));
        }

        int count = 0;
        while(strs.size() > 1){
            int idx = l.get(count);
            String left = strs.get(idx);
            String right = strs.get(idx+1);

            strs.remove(left);
            strs.remove(right);

            String toAdd = null;
            if(idx == 0){
                toAdd = left + "/" + right;
            }else if(count > 0 && idx == l.get(count-1)){
                toAdd = left.substring(0, left.length()-1) + "/" + right + ")";
            }else{
                toAdd = "(" + left + "/" + right + ")";
            }

            strs.add(idx, toAdd);
            count++;
        }

        return strs.get(0);
    }

    private void helper(double[] nums, ArrayList<Integer> idx){

        if(nums.length > 2){
            for(int i = 0; i < nums.length-1; i++){
                idx.add(i);
                double res = nums[i] / nums[i+1];
                double arr[] = new double[nums.length-1];
                int count = 0;

                for(int j = 0; j < i; j++){
                    arr[count++] = nums[j];
                }
                arr[count++] = res;
                for(int j = i+2; j < nums.length; j++){
                    arr[count++] = nums[j];
                }

                helper(arr, idx);
                idx.remove(idx.size()-1);
            }
        }else{
            double res = nums[0]/nums[1];
            if(res > max){
                max = res;
                l.clear();
                l.addAll(idx);
                l.add(0);
            }
        }

    }

    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return String.valueOf(nums[0]);
        if(nums.length == 2) return nums[0] + "/" + nums[1];

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        for(int i = 1; i < nums.length-1; i++){
            sb.append(nums[i]);
            sb.append("/");
        }
        sb.append(nums[nums.length-1]);
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        OptimalDivision test = new OptimalDivision();
        int[] nums = {1000, 100, 10, 2};
        System.out.print(test.optimalDivision(nums));
    }

}