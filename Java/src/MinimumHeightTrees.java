import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int last = 0;
        while(!queue.isEmpty()){
            last = queue.poll();
            for(int nei : g[last]){
                if(!visited[nei]){
                    visited[nei] = true;
                    queue.add(nei);
                }
            }
        }
        visited = new boolean[n];
        int[] pre = new int[n];

        int src = last;
        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()){
            last = queue.poll();
            for(int nei : g[last]){
                if(!visited[nei]){
                    visited[nei] = true;
                    pre[nei] = last;
                    queue.add(nei);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(last);
        while(last != src){
            path.add(pre[last]);
            last = pre[last];
        }

        List<Integer> res = new ArrayList<>();
        if(path.size() % 2 == 1){
            res.add(path.get(path.size()/2));
        }else{
            res.add(path.get(path.size()/2));
            res.add(path.get(path.size()/2-1));
        }

        return res;
    }



    public static void main(String[] args) {
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        MinimumHeightTrees test = new MinimumHeightTrees();
        List<Integer> res = test.findMinHeightTrees(6, edges);
        for(int i : res){
            System.out.println(i);
        }
    }

}



