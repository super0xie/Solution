
public class ShiftingLetters {
    
    public String shiftingLetters(String S, int[] shifts) {
        int sum = 0;
        for(int i = shifts.length-1; i >= 0; i--) {
            sum += shifts[i] % 26;
            sum = sum % 26;
            shifts[i] = sum;
        }
        
        char[] chars = S.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + shifts[i]);
            if(chars[i] > 'z') chars[i] -= 26;
        }
        
        return String.valueOf(chars);
    }
    
    public static void main(String[] args) {
        ShiftingLetters test = new ShiftingLetters();
        int[] shifts = {3,5,9};
        System.out.println(test.shiftingLetters("abc", shifts));
    }
    
}
