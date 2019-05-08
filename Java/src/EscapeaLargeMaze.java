import java.util.HashSet;
import java.util.LinkedList;

public class EscapeaLargeMaze {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        long m = 1000000;
        HashSet<Long> visited = new HashSet<>();
        int step = 0;
        LinkedList<Long> q = new LinkedList<>();
        long srcEncode = source[0] * m + source[1];
        q.add(srcEncode);
        visited.add(srcEncode);
        for(int [] b : blocked){
            long encode = b[0] * m + b[1];
            visited.add(encode);
        }
        
        long t = target[0] * m + target[1];
        
        while(!q.isEmpty()){
            LinkedList<Long> aux = new LinkedList<>();
            if(step > 100) return true;
            while(!q.isEmpty()){
                long polled = q.poll();
                long r = polled / m;
                long c = polled % m;

                for(int k = 0; k < 4; k++){
                    long i = r + adj[k][0];
                    long j = c + adj[k][1];
                    if(i >= 0 && i < m && j >= 0 && j < m){
                        long encode = i * m + j;
                        if(encode == t) return true;

                        if(!visited.contains(encode)){
                            aux.add(encode);
                            visited.add(encode);
                        }
                    }
                }

            }
            step++;
            q = aux;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] blocked = {{691938,300406},{710196,624190},{858790,609485},{268029,225806},{200010,188664},{132599,612099},{329444,633495},{196657,757958},{628509,883388}};
        int[] source = {655988,180910};
        int[] target = {267728,840949};
        EscapeaLargeMaze test = new EscapeaLargeMaze();
        System.out.println(test.isEscapePossible(blocked, source, target));
    }

}