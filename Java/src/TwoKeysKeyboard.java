
public class TwoKeysKeyboard {
    int min = Integer.MAX_VALUE;
    
    public int minSteps(int n) {
        if(n == 1) return 0;
        if(n == 2) return 2;
        
        
        minStepHelper(2, 1, 2, n, false);
        return min;
    }
    
    private void minStepHelper(int currentLength, int lengthInClipboard, int step, int n, boolean justCopied) {
        if(currentLength == n) {
            if(step < min) {
                min = step;
            }
            return;
        }
        
        if(currentLength > n) return;
        
        //paste
        minStepHelper(currentLength+lengthInClipboard, lengthInClipboard, step+1, n, false);
        
        if(!justCopied) {
          //copy
            minStepHelper(currentLength, currentLength, step+1, n, true);
        }
        
    }
    
    public static void main(String[] strs) {
        TwoKeysKeyboard tkk = new TwoKeysKeyboard();
        System.out.println(tkk.minSteps(6));
    }
    

}
