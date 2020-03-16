
public class BulbSwitcherIII {
    
    public int numTimesAllBlue(int[] light) {
        int max = 0;
        int res = 0;
        for(int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if(max == i+1) res++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        BulbSwitcherIII test = new BulbSwitcherIII();
        System.out.println(test.numTimesAllBlue(new int[] {1,2,3,4,5,6}));
    }
    
}
