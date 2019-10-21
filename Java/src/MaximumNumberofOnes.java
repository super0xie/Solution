import java.util.ArrayList;
import java.util.Collections;

public class MaximumNumberofOnes {
	
	public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
		if(maxOnes == 0) return 0;
        int[][] nums = new int[sideLength][sideLength];
        int rc = height / sideLength;
        int rm = height % sideLength;
        int cc = width / sideLength;
        int cm = width % sideLength;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < sideLength; i++) {
        	int nr = rc + (i < rm ? 1 : 0);
        	for(int j = 0; j < sideLength; j++) {
        		int nc = cc + (j < cm ? 1 : 0);
        		nums[i][j] = nr * nc;
        		list.add(nums[i][j]);
        	}
        }
        
        Collections.sort(list);
        int res = 0;
        for(int i = list.size()-1; i >= 0; i--) {
        	res += list.get(i);
        	maxOnes--;
        	if(maxOnes == 0) break;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaximumNumberofOnes test = new MaximumNumberofOnes();
		System.out.println(test.maximumNumberOfOnes(3, 3, 2, 1));
	}
	
}
