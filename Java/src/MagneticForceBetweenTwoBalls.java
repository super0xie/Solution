import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
	
	public int maxDistance(int[] position, int k) {
		Arrays.parallelSort(position);
        int l = 1;
        int r = position[position.length-1] - position[0]; 
        
        
        while(l < r) {
        	int m = r-(r-l)/2;
        	int i = 0;
        	int count = 1;
        	int cur = 0;
        	while(count < k) {
        		while(i < position.length && position[i] < position[cur] + m) i++;
        		cur = i;
        		if(i < position.length) count++;
        		else break;
        	}
        	if(count == k) l = m;
        	else r = m-1;
        }
        
        
        return l;
		
    }
	
	public static void main(String[] args) {
		MagneticForceBetweenTwoBalls test = new MagneticForceBetweenTwoBalls();
		int[] position = {5,4,3,2,1,1000000000};
		test.maxDistance(position, 2);
	}
	
}
