import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TheSkylineProblem {

    class Node {
        int l;
        int r;
        Node left;
        Node right;
        int height;
        Node(int l, int r){
            this.l = l;
            this.r = r;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if(buildings.length == 0) return res;
        HashSet<Integer> set = new HashSet<>();
        for(int[] b : buildings){
            set.add(b[0]);
            set.add(b[1]);
        }

        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.addAll(set);
        Collections.sort(nodes);
        ArrayList<Node> leaves = new ArrayList<>();
        Node root = buildTree(nodes, 0, nodes.size()-1, leaves);

        for(int[] b : buildings){
            update(root, b[0], b[1], b[2]);
        }

        
        for(int i = 0; i < leaves.size(); i++){
            if(i != 0 && leaves.get(i).height == leaves.get(i-1).height) continue;
            res.add(new int[]{leaves.get(i).l, leaves.get(i).height});
        }

        res.add(new int[]{leaves.get(leaves.size()-1).r, 0});
        return res;
    }

    private void update(Node n, int start, int end, int h){
        if(n.left == null){
            n.height = Math.max(n.height, h);
            return;
        }
        int mid = n.left.r;
        if(start >= mid){
            update(n.right, start, end, h);
        }else if(end <= mid){
            update(n.left, start, end, h);
        }else{
            update(n.left, start, mid, h);
            update(n.right, mid, end, h);
        }
    }

    private Node buildTree(ArrayList<Integer> l, int i, int j, ArrayList<Node> leaves){
        Node n = new Node(l.get(i), l.get(j));

        if(i+1 == j){
            leaves.add(n);
            return n;
        }

        int mid = i + (j-i)/2;
        n.left = buildTree(l, i, mid, leaves);
        n.right = buildTree(l, mid, j, leaves);
        return n;
    }

    public static void main(String[] args) {
        TheSkylineProblem test = new TheSkylineProblem();
        List<int[]> res = test.getSkyline(new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        for(int[] r : res){
            System.out.println(r[0] + ", " + r[1]);
        }
    }
    
}