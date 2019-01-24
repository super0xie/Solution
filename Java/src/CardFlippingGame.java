import java.util.HashSet;

public class CardFlippingGame {
    
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<>();
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < fronts.length; i++) {
            if(fronts[i] == backs[i]) set.add(fronts[i]);
        }
        
        for(int i = 0; i < fronts.length; i++) {
            if(fronts[i] < min && !set.contains(fronts[i])) min = fronts[i];
            if(backs[i] < min && !set.contains(backs[i])) min = backs[i];
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public static void main(String[] arsg) {
        int[] fronts = {1,2,4,4,7};
        int[] backs = {1,3,4,1,3};
        
        CardFlippingGame test = new CardFlippingGame();
        System.out.println(test.flipgame(fronts, backs));
    }


}
