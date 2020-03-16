import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class CampusBikes {

    class Node implements Comparable<Node>{
        int w;
        int b;
        int dis;

        Node(int w, int b, int[] wl, int [] bl){
            this.w = w;
            this.b = b;
            this.dis = Math.abs(wl[0]-bl[0]) + Math.abs(wl[1]-bl[1]);
        }

        @Override
        public int compareTo(Node o) {
            if(this.dis != o.dis) return this.dis - o.dis;
            else{
                if(this.w != o.w) return this.w - o.w;
                else return this.b - o.b;
            }
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        ArrayList<Node> l = new ArrayList<>();
        for(int i = 0; i < workers.length; i++){
            for(int j = 0; j < bikes.length; j++){
                l.add(new Node(i, j, workers[i], bikes[j]));
            }
        }

        Collections.sort(l);
        int[] res = new int[workers.length];
        boolean[] visitedWorkers = new boolean[workers.length];
        boolean[] visitedBikes = new boolean[bikes.length];

        for(int i = 0; i < l.size(); i++){
            Node n = l.get(i);
            if(visitedWorkers[n.w] || visitedBikes[n.b]) continue;
            res[n.w] = n.b;
            visitedWorkers[n.w] = true;
            visitedBikes[n.b] = true;
        }

        return res;
    }

    public static void main(String[] args) {
        CampusBikes test = new CampusBikes();
        int[][] workers = {{0,0},{1,1},{2,0}};
        int[][] bikes = {{1,0},{2,2},{2,1}};
        int[] res = test.assignBikes(workers, bikes);
        for(int i : res) System.out.print(i + ", ");
    }


}