import java.util.HashMap;

public class LongestWellPerformingInterval {

    public int longestWPIOld(int[] hours) {
        int[] prefix = new int[hours.length];
        int count = 0;
        for(int i = 0; i < hours.length; i++){
            if(hours[i] > 8) count++;
            prefix[i] = count;
        }
        int res = 0;
        for(int i = 0; i < hours.length; i++){
            for(int j = i; j < hours.length; j++){
                int n = j - i + 1;
                int td = getCount(prefix, i, j);
                int ntd = n - td;
                if(td > ntd) res = Math.max(res, n);
            }
        }

        return res;
    }

    public int longestWPIOld2(int[] hours) {
        int[] prefix = new int[hours.length];
        int count = 0;
        int res = 0;
        for(int i = 0; i < hours.length; i++){
            if(hours[i] > 8) count++;
            if(count > 0) res = Math.max(res, count);
            prefix[i] = count;
        }

        for(int n = hours.length; n >= 1; n--){
            for(int i = 0; i + n - 1 < hours.length; i++){
                int j = i + n - 1;
                int td = getCount(prefix, i, j);
                int ntd = n - td;
                if(td > ntd) return n;
            }
        }

        return res;
    }

    public int longestWPI(int[] hours) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        for(int i = 0; i < hours.length; i++){
            if(hours[i] > 8) count++;
            else count--;
            if(count > 0) res = Math.max(res, i+1);
            else{
                if(map.containsKey(count-1)){
                    int j = map.get(count-1);
                    res = Math.max(res, i-j);
                }
            }
            if(!map.containsKey(count)) map.put(count, i);
        }

        return res;
    }

    private int getCount(int[] prefix, int i, int j){
        if(i == 0) return prefix[j];
        else return prefix[j]-prefix[i-1];
    }

    public static void main(String[] args) {
        LongestWellPerformingInterval test = new LongestWellPerformingInterval();
        int[] hours = {6,6,9};
        System.out.println(test.longestWPI(hours));
    }

}