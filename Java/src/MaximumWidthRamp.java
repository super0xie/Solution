import java.util.Arrays;

public class MaximumWidthRamp {
    
//    private class Num{
//        int n;
//        int i;
//        Num(int n, int i){
//            this.n = n;
//            this.i = i;
//        }
//    }
//    
//    
//    private int res = 0;
//    
//    public int maxWidthRamp(int[] A) {
//        Num[] nums = new Num[A.length];
//        for(int i = 0; i < A.length; i++) {
//            nums[i] = new Num(A[i], i);
//        }
//        
//        mergeSort(nums, 0, nums.length-1);
//        
//        return res;
//    }
//    
//    private void mergeSort(Num[] arr, int l, int r) {
//        if(l == r) return;
//        int mid = l + (r-l)/2;
//        mergeSort(arr, l, mid);
//        mergeSort(arr, mid+1, r);
//        merge(arr, l, mid, mid+1, r);
//    }
//    
//    private void merge(Num[] arr, int l1, int r1, int l2, int r2) {
//        Num[] aux = new Num[r2-l1+1];
//        
//        int i = l1;
//        int j = l2;
//        int idx = 0;
//        
//        while(i <= r1 || j <= r2) {
//            if(i <= r1 && j <= r2) {
//                if(arr[i].n <= arr[j].n) {
//                    res = Math.max(res, arr[j].i - arr[i].i);
//                    aux[idx++] = arr[i++];
//                }else {
//                    aux[idx++] = arr[j++];
//                }
//            }else if(i <= r1) {
//                aux[idx++] = arr[i++];
//            }else if(j <= r2) {
//                aux[idx++] = arr[j++];
//            }
//        }
//        
//        for(i = 0; i < aux.length; i++) {
//            arr[l1+i] = aux[i];
//        }
//    }
    
    private class Num {
        int n;
        int i;

        Num(int n, int i) {
            this.n = n;
            this.i = i;
        }
    }
    
    public int maxWidthRamp(int[] A) {
        Num[] nums = new Num[A.length];
        for (int i = 0; i < A.length; i++) {
            nums[i] = new Num(A[i], i);
        }
        
        Arrays.sort(nums, (a, b)->{return a.n-b.n;});
        
        int res = 0;
        int minIdx = Integer.MAX_VALUE/2;
        
        for(Num n : nums) {
            res = Math.max(res, n.i - minIdx);
            minIdx = Math.min(minIdx, n.i);
        }
        return res;

    }
    
    
    public static void main(String[] args) {
        MaximumWidthRamp test = new MaximumWidthRamp();
        int[] A = {6,0,8,2,1,5};
        test.maxWidthRamp(A);
    }
    
    
}
