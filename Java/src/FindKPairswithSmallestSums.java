import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {

    class Pair{
        int[] a;
        int sum;

        Pair(int[] a){
            this.a = a;
            sum = a[0]+a[1];
        }
    }

    public List<int[]> kSmallestPairsV2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{return b.sum-a.sum;});
        for(int i = 0; i < nums1.length; i++){
            boolean added = false;
            for(int j = 0; j < nums2.length; j++){
                if(pq.size() < k){
                    pq.add(new Pair(new int[]{nums1[i], nums2[j]}));
                    added = true;
                }else{
                    
                    int maxSum = pq.peek().sum;
                    int sum = nums1[i] + nums2[j];
                    if(sum >= maxSum) break;                   
                    pq.poll();
                    pq.add(new Pair(new int[] {nums1[i], nums2[j]}));
                    added = true;
                }
            }
            if(!added) break;
        }

        LinkedList<int[]> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll().a);
        }
        return res;
    }

    public List<int[]> kSmallestPairsV1(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{return -a[0]-a[1]+b[0]+b[1];});
        for(int i = 0; i < nums1.length; i++){
            boolean added = false;
            for(int j = 0; j < nums2.length; j++){
                if(pq.size() < k){
                    pq.add(new int[]{nums1[i], nums2[j]});
                    added = true;
                }else{
                    int[] max = pq.peek();
                    int maxSum = max[0] + max[1];
                    int sum = nums1[i] + nums2[j];
                    if(sum >= maxSum) break;                   
                    pq.poll();
                    pq.add(new int[] {nums1[i], nums2[j]});
                    added = true;
                }
            }

            if(!added) break;
        }

        LinkedList<int[]> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll());
        }
        return res;
    }


    public List<int[]> kSmallestPairsV3(int[] nums1, int[] nums2, int k) {

        ArrayList<int[]> list = new ArrayList<>();
        for(int s = 0; s < k; s++){
            for(int i = 0; i < Math.min(nums1.length, k); i++){
                int j = s-i;
                if(j >= nums2.length || j < 0) continue;
                list.add(new int[]{nums1[i], nums2[j]});
            }
        }

        if(list.size() <= k) return list;
        Collections.sort(list, ((a, b)->{return a[0]+a[1]-b[0]-b[1];}));
        LinkedList<int[]> res = new LinkedList<>();
        for(int i = 0; i < k; i++){
            res.add(list.get(i));
        }

        return res;
    }

    public List<int[]> kSmallestPairsV4(int[] nums1, int[] nums2, int k) {

        ArrayList<Pair> list = new ArrayList<>();
        for(int s = 0; s < k; s++){
            for(int i = 0; i < Math.min(nums1.length, k); i++){
                int j = s-i;
                if(j >= nums2.length || j < 0) continue;
                list.add(new Pair(new int[]{nums1[i], nums2[j]}));
            }
        }
        LinkedList<int[]> res = new LinkedList<>();

        if(list.size() <= k) {
            for(Pair p: list){
                res.add(p.a);
            }
            return res;
        }

        int l = 0;
        int r = list.size()-1;

        while(l < r){
            int i = partition(list, l, r);
            if(i == k) break;
            else if(i < k) l = i+1;
            else r = i-1;
        }
        
        for(int i = 0; i < k; i++){
            res.add(list.get(i).a);
        }

        return res;
    }

    private int partition(ArrayList<Pair> l, int start, int end){
        Pair pivot = l.get(end);
        int tar = start;

        for(int i = start; i < end; i++){
            if(l.get(i).sum < pivot.sum){
                swap(l, i, tar);
                tar++;
            }
        }

        swap(l, tar, end);
        return tar;
    }

    private void swap(ArrayList<Pair> l, int i, int j){
        Pair aux = l.get(i);
        l.set(i, l.get(j));
        l.set(j, aux);
    }

    
    
    public static void main(String[] args) {
        FindKPairswithSmallestSums test = new FindKPairswithSmallestSums();
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        List<int[]> res = test.kSmallestPairsV1(nums1, nums2, 2);
        for(int[] i: res){
            System.out.println("" + i[0] + " "  + i[1]);
        }
    }

}