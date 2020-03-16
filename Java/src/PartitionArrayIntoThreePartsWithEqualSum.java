
public class PartitionArrayIntoThreePartsWithEqualSum {
	
	public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A) {
        	sum += i;
        }
        
        if(sum % 3 != 0) return false;
        int target = sum / 3;
        
        int aux = 0;
        int count = 0;
        for(int i : A) {
        	aux += i;
        	if(aux == target) {
        		aux = 0;
        		count++;
        	}
        }
        
        return count == 3;
    }
	
	public static void main(String[] args) {
		PartitionArrayIntoThreePartsWithEqualSum test = new PartitionArrayIntoThreePartsWithEqualSum();
		int[] A = {3,3,6,5,-2,2,5,1,-9,4};
		System.out.println(test.canThreePartsEqualSum(A));
	}
	
}

