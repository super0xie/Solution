import java.util.Arrays;

public class HIndex {
	
	public int hIndex(int[] citations) {
		if(citations.length==0) return 0;
		Arrays.sort(citations);
		for(int i = 0; i < citations.length; i++) {
			if(citations.length-i <= citations[i]) return citations.length-i;
		}
		return -1;
        
    }
	
	public static void main(String[] args) {
		
		HIndex test = new HIndex();
		int[] citations = {10, 100, 100, 100, 100, 100, 100, 100, 100, 100};
		System.out.println(test.hIndex(citations));
	}

}
