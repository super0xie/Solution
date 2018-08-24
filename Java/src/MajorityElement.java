import java.util.HashMap;

public class MajorityElement {
    
    
    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        
        for(int j = l; j <= r-1; j++) {
            if(arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
            }
        }
        
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        
        return i;
    }
    
    
    private int findKth(int[] arr, int k, int l, int r) {
        if(l == r) return arr[l];
        
        int pivotIndex = partition(arr, l, r);
        if(k == pivotIndex) return arr[k];
        else {
            if(k < pivotIndex) {
                return findKth(arr, k, l, pivotIndex-1);
            }else {
                return findKth(arr, k, pivotIndex+1, r);
            } 
        } 
    }
    
    public int majorityElement(int[] nums) {
        return findKth(nums, nums.length / 2, 0, nums.length-1);  
    }
    
    public int majorityElementv2(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int count = map.merge(nums[i], 1, Integer::sum);
            if(count > nums.length / 2)
                return nums[i];
        }
        
        return -1;
        
    }
    
    
    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(test.majorityElement(arr));
    }
    
    
}
