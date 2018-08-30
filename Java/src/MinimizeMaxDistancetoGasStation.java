import java.util.PriorityQueue;

public class MinimizeMaxDistancetoGasStation {
    
    private class Interval{
        double length;
        double dis;
        int stations;
        
        
        void computeDis() {
            dis = length / stations;
        }
    }
    
    public double minmaxGasDist(int[] stations, int K) {
        int sumDis = 0;
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a,b)->{
            if(b.dis > a.dis) return 1;
            else if(a.dis > b.dis) return -1;
            return 0;
        });
        
        for(int i = 1; i < stations.length; i++) {
            sumDis += stations[i] - stations[i-1];
        }
        
        
        for(int i = 1; i < stations.length; i++) {
            Interval inter = new Interval();
            inter.length = stations[i] - stations[i-1];
            int stationToPut = (int)(K * inter.length / sumDis);
            inter.stations = 1 + stationToPut;
            K -= stationToPut;
            inter.computeDis();
            pq.add(inter);
        }
        
        while(K > 0) {
            Interval inter = pq.poll();
            inter.stations++;
            inter.computeDis();
            pq.add(inter);
            K--;
        }
        
        
        
        
        return pq.poll().dis;
    }
    
    public static void main(String [] args) {
        MinimizeMaxDistancetoGasStation test = new MinimizeMaxDistancetoGasStation();
        
        int[] stations = {23,24,36,39,46,56,57,65,84,98};
        test.minmaxGasDist(stations, 1);
        
                
    }
}
