import java.util.ArrayList;

public class CopyListwithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        ArrayList<RandomListNode> src = new ArrayList<>();
        ArrayList<RandomListNode> dst = new ArrayList<>();

        RandomListNode p = head;
        int idx = 0;
        while(p != null){
            src.add(p);
            dst.add(new RandomListNode(p.label));
            p = p.next;
            src.get(idx).next = dst.get(idx);
            dst.get(idx).next = src.get(idx);
            idx++;
        }

        for(int i = 0; i < dst.size(); i++){
            if(dst.get(i).next.random != null)
                dst.get(i).random = dst.get(i).next.random.next;
        }

        for(int i = 0; i < dst.size()-1; i++){
            dst.get(i).next = dst.get(i+1);
            src.get(i).next = src.get(i+1);
        }

        dst.get(dst.size()-1).next = null;
        src.get(src.size()-1).next = null;

        return dst.get(0);
    }
}