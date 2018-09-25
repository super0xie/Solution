import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
	private class Num{
		int idx;
		int val;
		int count;
		Num(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	
	public List<Integer> countSmaller(int[] nums) {
		Num [] arr = new Num[nums.length]; 
        for(int i = 0; i < nums.length; i++) {
        	arr[i] = new Num(i, nums[i]);
        }
        
        mergeSort(arr, 0, nums.length-1);
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	res.add(0);
        }
        
        for(int i = 0; i < nums.length; i++) {
        	res.set(arr[i].idx, arr[i].count);
        }
        
        return res;
    }
	
	private void mergeSort(Num[] nums, int start, int end) {
		if(start >= end) return;
		
		int mid = start + (end - start) / 2;
		
		mergeSort(nums, start, mid);
		mergeSort(nums, mid+1, end);
		
		Num[] aux = new Num[end-start+1];
		int idx = 0;
		int i = start;
		int j = mid+1;
		int sum = 0;
		while(i <= mid || j <= end) {
			if(i <= mid && j <= end) {
				if(nums[i].val <= nums[j].val) {
					nums[i].count += sum;
					aux[idx++] = nums[i++];
				}else {
					aux[idx++] = nums[j++];
					sum++;
				}
			}else if(i <= mid) {
				nums[i].count += sum;
				aux[idx++] = nums[i++];
			}else if(j <= end) {
				aux[idx++] = nums[j++];
				sum++;
			}
		}
		
		for(int k = 0; k < aux.length; k++) {
			nums[start+k] = aux[k];
		}
		
	}

}
