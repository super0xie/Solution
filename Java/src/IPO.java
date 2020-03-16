import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for(int i = 0; i < Capital.length; i++){
            if(!map.containsKey(Capital[i])) map.put(Capital[i], new ArrayList<>());
            map.get(Capital[i]).add(Profits[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int key : map.subMap(0, true, W, true).keySet()){
            pq.addAll(map.get(key));
        }

        while(k > 0){
            if(pq.isEmpty()) break;

            int saved = W;
            W += pq.poll();

            for(int key : map.subMap(saved, false, W, true).keySet()){
                pq.addAll(map.get(key));
            }
            k--;
        }

        return W;
    }

    public static void main(String[] args) {
        IPO test = new IPO();
        int k = 2;
        int W = 0;
        int[] Profits = {1,2,3};
        int[] Capital = {0,1,1};

        System.out.println(test.findMaximizedCapital(k, W, Profits, Capital));
    }

}