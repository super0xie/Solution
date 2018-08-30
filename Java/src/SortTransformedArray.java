
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int [] result = new int[nums.length];
        
        int leftToRight = 0;
        int index = 0;
        double middle = 0;
        if(a == 0) {
            if(b >= 0) leftToRight = 1;
            else leftToRight = 0;
        }else {
            middle = - b / ((double)a*2);
            
            while(index < nums.length && nums[index] < middle) {
                index++;
            }
            
            if(index == 0) {
                if(a > 0) leftToRight = 1;
                else leftToRight = 0;
            }else if(index == nums.length) {
                if(a > 0) leftToRight = 0;
                else leftToRight = 1;
            }else {
                leftToRight = -1;
            }
        }
        
        if(leftToRight >= 0) {
            if(leftToRight == 1) {
                for(int i = 0; i < nums.length; i++) {
                    result[i] = nums[i] * nums[i] * a + b * nums[i] + c;
                }
            }else {
                int ind = 0;
                for(int i = nums.length-1; i >= 0; i--) {
                    result[ind++] = nums[i] * nums[i] * a + b * nums[i] + c;
                }
            }
        }else {
            if(a > 0) {
                int left = index - 1;
                int right = index;
                int i = 0;
                while(left >= 0 || right < nums.length) {
                    if(left < 0) {
                        result[i++] = nums[right] * nums[right] * a + b * nums[right] + c;
                        right++;
                    }else if(right >= nums.length) {
                        result[i++] = nums[left] * nums[left] * a + b * nums[left] + c;
                        left--;
                    }else{
                        if(middle - nums[left] > nums[right] - middle) {
                            result[i++] = nums[right] * nums[right] * a + b * nums[right] + c;
                            right++;
                        }else {
                            result[i++] = nums[left] * nums[left] * a + b * nums[left] + c;
                            left--;
                        }
                    }
                }
            }else {
                int left = 0;
                int right = nums.length - 1;
                int i = 0;
                while(left <= index-1 || right >= index) {
                    if(left > index-1) {
                        result[i++] = nums[right] * nums[right] * a + b * nums[right] + c;
                        right--;
                    }else if(right < index) {
                        result[i++] = nums[left] * nums[left] * a + b * nums[left] + c;
                        left++;
                    }else{
                        if(middle - nums[left] > nums[right] - middle) {
                            result[i++] = nums[left] * nums[left] * a + b * nums[left] + c;
                            left++;
                        }else {
                            result[i++] = nums[right] * nums[right] * a + b * nums[right] + c;
                            right--;
                        }
                    }
                }
            }
            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        SortTransformedArray test = new SortTransformedArray();
        int [] nums = {-4,-2,2,4};
        int a = 0, b = -1, c = 5;
        
        int [] result = test.sortTransformedArray(nums, a, b, c);
        System.out.println("hello");
    }
}
