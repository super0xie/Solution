import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FallingSquares {

    class Node {
        int h;
        int l;
        int r;
        Node left;
        Node right;
        Node(int l, int r){
            this.l = l;
            this.r = r;
        }
    }

    private Node root;

    public List<Integer> fallingSquares(int[][] positions) {
        HashSet<Integer> set = new HashSet<>();
        for(int[] p : positions){
            set.add(p[0]);
            set.add(p[0]+p[1]-1);
        }

        ArrayList<Integer> l = new ArrayList<>();
        l.addAll(set);
        Collections.sort(l);
        root = build(l, 0, l.size()-1);
        List<Integer> res = new ArrayList<>();

        for(int[] p : positions){
            int max = getMax(root, p[0], p[0]+p[1]-1);
            int h = max + p[1];
            add(root, p[0], p[0]+p[1]-1, h);
            res.add(root.h);
        }

        return res;
    }

    private Node build(ArrayList<Integer> l, int i, int j){
        Node n = new Node(l.get(i), l.get(j));
        if(j == i) {
            return n;
        }
        int mid = i + (j-i)/2;
        n.left = build(l, i, mid);
        n.right = build(l, mid+1, j);
        return n;
    }

    private void add(Node n, int i, int j, int h){
        if(n.l == n.r){
            n.h = h;
        }else{
            if(n.left != null && n.left.r >= j) add(n.left, i, j, h);
            else if(n.right != null && n.right.l <= i) add(n.right, i, j, h);
            else{
                add(n.left, i, n.left.r, h);
                add(n.right, n.right.l, j, h);
            }

            if(n.left != null) n.h = Math.max(n.h, n.left.h);
            if(n.right != null) n.h = Math.max(n.h, n.right.h);
        }
    }
    
    private int getMax(Node n, int i, int j){
        if(n.l == n.r){
            return n.h;
        }else{
            if(n.left != null && n.left.r >= j) return getMax(n.left, i, j);
            else if(n.right != null && n.right.l <= i) return getMax(n.right, i, j);
            else{
                return Math.max(getMax(n.left, i, n.left.r), getMax(n.right, n.right.l, j));
            }
        }
    }

    public static void main(String[] args) {
        FallingSquares test = new FallingSquares();
        int[][] positions = {{9,7},{1,9},{3,1}};
        List<Integer> res = test.fallingSquares(positions);
        for(int i : res) System.out.println(i);
    }

}