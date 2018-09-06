
public class TwoSumII {
    
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) return new int[] {i, j};
            if(sum < target) i++;
            else j--;
        }
        
        return null;
        
    }

}
