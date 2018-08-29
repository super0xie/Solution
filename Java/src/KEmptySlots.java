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
    
    public static void main(String[] args) {
        int[] flowers = {1,3,2};
        
        KEmptySlots test = new KEmptySlots();
        System.out.println(test.kEmptySlots(flowers, 1));
        
    }

}
