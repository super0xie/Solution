import java.util.ArrayList;

public class CreateMaximumNumber {



    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0) return nums2;
        if(nums2.length == 0) return nums1;
        ArrayList<Integer>[] pre = new ArrayList[nums1.length];
        ArrayList<Integer>[] dp1 = new ArrayList[k];
        for(int j = 0; j < k; j++){
            ArrayList<Integer>[] cur = new ArrayList[nums1.length];
            for(int i = 0; i < nums1.length; i++){
                if(i < j){
                    cur[i] = null;
                    continue;
                }
                ArrayList<Integer> l = null;
                if(j == 0) l = new ArrayList<>();
                else l = pre[i-1];
                l.add(nums1[i]);
                cur[i] = l;
                if(i >= 1 && cur[i-1] != null){
                    cur[i] = max(cur[i], cur[i-1]);
                }
            }
            dp1[j] = cur[nums1.length-1];
            pre = cur;
        }
        
        pre = new ArrayList[nums2.length];
        ArrayList<Integer>[] dp2 = new ArrayList[k];
        
        for(int j = 0; j < k; j++){
            ArrayList<Integer>[] cur = new ArrayList[nums2.length];
            for(int i = 0; i < nums2.length; i++){
                if(i < j){
                    cur[i] = null;
                    continue;
                }
                ArrayList<Integer> l = null;
                if(j == 0) l = new ArrayList<>();
                else l = pre[i-1];
                l.add(nums2[i]);
                cur[i] = l;
                if(i >= 1 && cur[i-1] != null){
                    cur[i] = max(cur[i], cur[i-1]);
                }
            }
            dp2[j] = cur[nums2.length-1];
            pre = cur;
        }
        
        ArrayList<Integer> res = dp2[k-1];
        for(int i = 0; i < dp1.length-1; i++) {
            ArrayList<Integer> l1 = dp1[i];
            ArrayList<Integer> l2 = dp2[k-2-i];
            if(l1 == null || l2 == null) continue;
            ArrayList<Integer> merged = merge(l1, l2);
            if(res == null) res = merged;
            else res = max(res, merged);
        }
        if(dp1[k-1] != null && res != null)
            res = max(res, dp1[k-1]);
        
        int[] ret = new int[k];
        for(int i = 0; i < k; i++) {
            ret[i] = res.get(i);
        }
        
        return ret;
    }
    
    private ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2){
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i < l1.size() || j < l2.size()) {
            if(i < l1.size() && j < l2.size()) {
                if(l1.get(i) < l2.get(j)) {
                    res.add(l2.get(j++));
                }else if(l1.get(i) > l2.get(j)){
                    res.add(l1.get(i++));
                }else{
                    int ii = i;
                    int jj = j;

                    while(ii < l1.size() && jj < l2.size() && l1.get(ii) == l2.get(jj)){
                        ii++;
                        jj++;
                    }

                    if(ii >= l1.size()) res.add(l2.get(j++));
                    else if(jj >= l2.size()) res.add(l1.get(i++));
                    else {
                        if(l2.get(jj) > l1.get(ii)) res.add(l2.get(j++));
                        else res.add(l1.get(i++));
                    } 
                }
            }else if(i < l1.size()) {
                res.add(l1.get(i++));
            }else {
                res.add(l2.get(j++));
            }
        }
        
        return res;
    }
    
    private ArrayList<Integer> max(ArrayList<Integer> l1, ArrayList<Integer> l2){
        for(int i = 0; i < l1.size(); i++){
            if(l1.get(i) > l2.get(i)) return l1;
            else if(l1.get(i) < l2.get(i)) return new ArrayList<>(l2);
        }
        
        return l1;
    }

    public static void main(String[] args) {
        CreateMaximumNumber test = new CreateMaximumNumber();
        int[] nums1 = {9, 1, 2, 5, 8, 3};
        int[] nums2 = {6,4,0};
        int[] res = test.maxNumber(nums1, nums2, 5);
        System.out.println("test");
    }

    

}