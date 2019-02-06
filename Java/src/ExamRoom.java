import java.util.HashMap;
import java.util.PriorityQueue;

public class ExamRoom {
    
    
    class Node implements Comparable<Node>{
        int l;
        int r;
        int dis;
        int idx;
        
        Node(int l, int r){
            this.l = l;
            this.r = r;
            update();
        }
        
        void update() {
            int len;
            if(this.r == N-1 || this.l == 0) len = (this.r - this.l + 1) * 2;
            else len = this.r - this.l + 1;
            dis = (len-1)/2;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dis != o.dis) {
                return o.dis - this.dis;
            }else {
                return this.l - o.l;
            }
        }
    }
    
    private PriorityQueue<Node> pq;
    
    public void ExamRoomOld(int N) {
        this.N = N;
        pq = new PriorityQueue<>();
        pq.add(new Node(0, N-1));
    }
    
    public int seatOld() {
        if(pq.isEmpty()) return -1;
        int res;
        Node n = pq.poll();
        if(n.l == 0) {
            if(n.r != 0) pq.add(new Node(1, n.r));
            res = 0;
        } else if(n.r == N-1) {
            if(n.l != N-1 && N-2 >= n.l) pq.add(new Node(n.l, N-2));
            res = N-1;
        } else {
            res = n.l + (n.r-n.l)/2;
            if(res != n.l) {
                pq.add(new Node(n.l, res-1));
            }
            if(res != n.r) {
                pq.add(new Node(res+1, n.r));
            }
        }
        return res;
    }
    
    public void leaveOld(int p) {
        Node left = null;
        Node right = null;
        
        for(Node n : pq) {
            if(n.r == p-1) left = n;
            if(n.l == p+1) right = n;
        }
        
        if(left != null && right != null) {
            pq.remove(left);
            pq.remove(right);
            pq.add(new Node(left.l, right.r));
        }else if(left != null) {
            pq.remove(left);
            pq.add(new Node(left.l, p));
        }else if(right != null) {
            pq.remove(right);
            pq.add(new Node(p, right.r));
        }else {
            pq.add(new Node(p, p));
        }
    }
    
    
    
    class PQ {
        
        private Node[] pq;
        private int count;
        HashMap<Integer, Node> map;
        
        PQ(){
            pq = new Node[40000];
            count = 0;
            map = new HashMap<>();
        }
        
        boolean isEmpty() {
            return count == 0;
        }
        
        void swap(int i, int j) {
            pq[i].idx = j;
            pq[j].idx = i;
            
            Node n = pq[i];
            pq[i] = pq[j];
            pq[j] = n;
        }
        
        void add(Node n) {
            pq[++count] = n;
            n.idx = count;
            swim(count);
            
            map.put(n.l, n);
            map.put(n.r, n);
        }
        
        void swim(int i) {
            while(i > 1 && pq[i/2].compareTo(pq[i]) > 0) {
                swap(i/2, i);
                i = i/2;
            }
        }
        
        void sink(int i) {
            while(i*2 <= count) {
                int j = 2 * i;
                if(j < count && pq[j].compareTo(pq[j+1]) > 0) j++;
                if(pq[i].compareTo(pq[j]) <= 0) break;
                swap(i, j);
                i = j;
            }
        }
        
        void delete(Node n) {
            map.remove(pq[n.idx].l);
            map.remove(pq[n.idx].r);
            if(n.idx == count) {
                pq[count] = null;
                count--;
            }else {
                int idx = n.idx;
                swap(n.idx, count--);
                sink(idx);
                pq[count+1] = null;
            }
        }
        
        Node poll() {
            map.remove(pq[1].l);
            map.remove(pq[1].r);
            Node min = pq[1];
            swap(1, count--);
            sink(1);
            pq[count+1] = null;
            return min;
        }
    }
    
    private int N;
    private PQ heap;
    public ExamRoom(int N) {
        this.N = N;
        heap = new PQ();
        heap.add(new Node(0, N-1));
    }
    
    public int seat() {
        if(heap.isEmpty()) return -1;
        int res;
        Node n = heap.poll();
        if(n.l == 0) {
            if(n.r != 0) heap.add(new Node(1, n.r));
            res = 0;
        } else if(n.r == N-1) {
            if(n.l != N-1 && N-2 >= n.l) heap.add(new Node(n.l, N-2));
            res = N-1;
        } else {
            res = n.l + (n.r-n.l)/2;
            if(res != n.l) {
                heap.add(new Node(n.l, res-1));
            }
            if(res != n.r) {
                heap.add(new Node(res+1, n.r));
            }
        }
        return res;
    }
    
    public void leave(int p) {
        Node left = heap.map.get(p-1);
        Node right = heap.map.get(p+1);
        
        if(left != null && right != null) {
            heap.delete(left);
            heap.delete(right);
            heap.add(new Node(left.l, right.r));
        }else if(left != null) {
            heap.delete(left);
            heap.add(new Node(left.l, p));
        }else if(right != null) {
            heap.delete(right);
            heap.add(new Node(p, right.r));
        }else {
            heap.add(new Node(p, p));
        }
    }
    
    public static void main(String[] args) {
        ExamRoom test = new ExamRoom(10);
        System.out.println(test.seat());
        System.out.println(test.seat());
        System.out.println(test.seat());
        System.out.println(test.seat());
        test.leave(4);
        System.out.println(test.seat());
        System.out.println("test");
    }
}
