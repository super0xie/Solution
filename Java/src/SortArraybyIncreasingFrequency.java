import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortArraybyIncreasingFrequency {
	
	public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for(int i : nums) count[i+100]++;
        
        Integer[] aux = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Arrays.parallelSort(aux, (Integer a, Integer b)->{
        	if(count[a+100] != count[b+100]) return count[a+100]-count[b+100];
        	return b-a;
        });
        
        return Arrays.stream(aux).mapToInt(i->i).toArray();
    }
	
}
