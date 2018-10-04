public class KEmptySlots {
    
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int [flowers.length+1];
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < flowers.length; i++) {
            days[flowers[i]] = i+1;
        }
        
        int left = 1;
        int right = k + 2;
        
        for(int i = 1; right < days.length; i++) {
            
            if(i == right) {
                result = Math.min(result, Math.max(days[left], days[right]));
                left = i;
                right = i+k+1;
            }else if(days[i] < days[left] || days[i] < days[right]) {
                left = i;
                right = i+k+1;
            }
            
        }
        
        if(result == Integer.MAX_VALUE) result = -1;
        return result;
    }
    
    
    public int kEmptySlotsWrong(int[] flowers, int k) {
        int [] days = new int [flowers.length];
        
        for(int i = 0; i < flowers.length; i++) {
            days[flowers[i]-1] = i;
        }
        
        int l = 0;
        int r = k + 1;
        int res = -1;
        for(int i = 0; r < days.length; i++) {
            if(i == r) {
                res = Math.max(days[l]+1, days[r]+1);
                return res;
            }else if(days[i] < days[l] || days[i] < days[r]) {
                l = i;
                r = i + k + 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] flowers = {1,3,2};
        
        KEmptySlots test = new KEmptySlots();
        System.out.println(test.kEmptySlots(flowers, 1));
        
    }

}
