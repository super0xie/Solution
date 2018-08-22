import java.util.Arrays;

public class BoatstoSavePeople {
    
    public int numRescueBoats(int[] people, int limit) {
        int startIndex = 0;
        int result = people.length;
        
        Arrays.sort(people);
        
        for(int i = people.length-1; i > startIndex; i--) {
            if(people[i] + people[startIndex] <= limit) {
                startIndex++;
                result--;
            }
        }
        
        return result;
    
    }

}
