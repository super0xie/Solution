import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    
    class Node implements Comparable<Node>{
        String str;
        int count;
        Node(String str, int count){
            this.str = str;
            this.count = count;
        }
        @Override
        public int compareTo(Node o) {
            if(this.count != o.count) {
                return this.count - o.count;
            }else {
                return o.str.compareTo(this.str);
            }
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(String key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
            if(pq.size() > k) pq.poll();
        }
        
        while(!pq.isEmpty()) res.add(pq.poll().str);
        List<String> ret = new ArrayList<>();
        for(int i = res.size()-1; i >= 0; i--) {
            ret.add(res.get(i));
        }
        return ret;
    }
    
}
