import java.util.HashMap;

public class DistributeCandies {
    
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        for(int i : candies) {
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        
        int bro = 0;
        
        for(int key : count.keySet()) {
            bro += count.get(key)-1;
        }
        
        if(bro >= candies.length / 2)
            return count.size();
        else {
            return count.size() - (candies.length / 2 - bro); 
        }
    }
    
    public static void main(String[] args) {
        int[] candies = {1,1,1,2,2,3};
        DistributeCandies test = new DistributeCandies();
        System.out.println(test.distributeCandies(candies));
    }
    
}
