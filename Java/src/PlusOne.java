
public class PlusOne {
    
    public int[] plusOne(int[] digits) {
        
        for(int i = digits.length-1; i >=0; i++) {
            int sum = digits[i] + 1;
            if(sum == 10) {
                digits[i] = 0;
                if(i == 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    return result;
                }
            }else {
                digits[i] = sum;
                return digits;
            }
        }
        
        return digits;
        
    }
    
    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        int [] digits = {9,9};
        int [] result = test.plusOne(digits);
        
        System.out.println("ok");
    }

}
