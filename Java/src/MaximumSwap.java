
public class MaximumSwap {
    
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != '9') {
                
                int max = Integer.MIN_VALUE;
                int maxIdx = -1;
                for(int j = i+1; j < chars.length; j++) {
                    if(chars[j] > chars[i]) {
                        if(chars[j] >= max) {
                            max = chars[j];
                            maxIdx = j;
                        }
                    }
                }
                
                if(max != Integer.MIN_VALUE) {
                    char temp = chars[i];
                    chars[i] = chars[maxIdx];
                    chars[maxIdx] = temp;
                    return Integer.parseInt(String.valueOf(chars));
                }
                
            }
        }
        
        return num;
    }
    
}
