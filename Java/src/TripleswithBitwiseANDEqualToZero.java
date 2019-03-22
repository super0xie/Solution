import java.util.HashMap;

public class TripleswithBitwiseANDEqualToZero {
    public int countTripletsOld(int[] A) {
		int res = 0;
		HashMap<Integer, Integer> [] arr = new HashMap[16];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new HashMap<Integer, Integer>();
		}
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A.length; j++) {
				int n = A[i] & A[j];
				int and = n;
				for(int k = 0; k < 16; k++) {
					if(n % 2 == 0) arr[k].put(and, arr[k].getOrDefault(and, 0)+1);
					n = n >> 1;
				}
			}
		}
		
		for(int i = 0; i < A.length; i++) {
			int n = A[i];
			if(n == 0) {
				res += A.length * A.length;
				continue;
			}
			int and = n;
			int minSize = Integer.MAX_VALUE;
			int minIdx = Integer.MAX_VALUE;
			
			for(int k = 0; k < 16; k++) {
				if(n % 2 == 1) {
					if(arr[k].size() < minSize) {
						minSize = arr[k].size();
						minIdx = k;
					}
				}
				n = n >> 1;
			}
			
			if(minIdx != Integer.MAX_VALUE) {
				for(int num : arr[minIdx].keySet()) {
					if((num & and) == 0) {
						res += arr[minIdx].get(num);
					}
				}
			}
			
		}
		return res;
    }

    public int countTriplets(int[] A) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A.length; j++) {
				int n = A[i] & A[j];
				map.put(n, map.getOrDefault(n, 0)+1);
			}
		}
        
		for(int i = 0; i < A.length; i++) {
			for(int key : map.keySet()){
                if((int)(A[i] & key) == 0) res += map.get(key);
            }
		}
		return res;
    }


}