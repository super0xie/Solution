import java.util.Arrays;

public class Heaters {
    
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(heaters);
        for(int i = 0; i < houses.length; i++) {
            int house = houses[i];
            int s = Arrays.binarySearch(heaters, house);
            if(s >= 0) continue;
            
            int ip = -s - 1;
            if(ip == 0) {
                res = Math.max(res, heaters[0]-house);
            }else if(ip == heaters.length) {
                res = Math.max(res, house - heaters[heaters.length-1]);
            }else {
                res = Math.max(res, Math.min(house - heaters[ip-1], heaters[ip]-house));
            }
        }
            
        return res;
    }
    
}
