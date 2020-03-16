import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RectangleAreaII {

    class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public int compareTo(Interval o) {
            return start - o.start;
        }
    }

    class Node {
        ArrayList<Interval> list;
        int l;
        int r;
        Node left;
        Node right;
        Node(int l, int r){
            this.l = l;
            this.r = r;
            list = new ArrayList<>();
        }
    }

    private Node root;
    private ArrayList<Node> leaves;

    public int rectangleArea(int[][] rects) {
        leaves = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int[] rect : rects){
            set.add(rect[0]);
            set.add(rect[2]);
        }

        ArrayList<Integer> l = new ArrayList<>();
        for(int i : set) l.add(i);
        Collections.sort(l);

        root = build(l, 0, l.size()-1);

        for(int[] rect : rects){
            add(root, rect[0], rect[2], new Interval(rect[1], rect[3]));
        }

        long res = 0;
        int mod = 1000000000+7;

        for(Node n : leaves){
            
            List<Interval> merged = merge(n.list);
            long width = n.r-n.l;
            for(Interval inter : merged){
                res += width * (inter.end-inter.start);
            }
        }

        return (int)(res % mod);
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals);
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        Interval last = null;
        for(Interval interval: intervals) {
            if(last == null) {
                last = new Interval(interval.start, interval.end);
                result.add(last);
                continue;
            }
            
            if(last.end >= interval.start) {
                //merge
                if(last.end < interval.end) last.end = interval.end;
            }else {
                last = new Interval(interval.start, interval.end);
                result.add(last);
            }
        }
        
        return result;
        
    }

    private Node build(ArrayList<Integer> l, int i, int j){
        Node n = new Node(l.get(i), l.get(j));
        if(j-i == 1) {
            leaves.add(n);
            return n;
        }
        int mid = i + (j-i)/2;
        n.left = build(l, i, mid);
        n.right = build(l, mid, j);
        return n;
    }

    private void add(Node n, int l, int r, Interval interval){
        if(n.left == null && n.l == l && n.r == r){
            n.list.add(interval);
            return;
        }

        if(n.left != null && n.left.r >= r) add(n.left, l, r, interval);
        else if(n.right != null && n.right.l <= l) add(n.right, l, r, interval);
        else{
            add(n.left, l, n.left.r, interval);
            add(n.right, n.right.l, r, interval);
        }
    }

    public static void main(String[] args) {
        RectangleAreaII test = new RectangleAreaII();
        int[][] rects = {{0,0,1000000000,1000000000}};
        System.out.println(test.rectangleArea(rects));
    }




}