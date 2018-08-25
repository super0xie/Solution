import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String result = "";
        
        String [] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, (String str1, String str2)->{
            String a = str1+str2;
            String b = str2+str1;
            
            return b.compareTo(a);
        });
        
        for(String str : strs) {
            result = result + str; 
        }
        

        if(result.length() > 0 && result.charAt(0) == '0') return "0";

        return result;
        
    }
    
    public static void main(String[] args) {
        int [] nums = {3,30,34,5,9};
        LargestNumber test = new LargestNumber();
        
        System.out.println(test.largestNumber(nums));;

    }
}
