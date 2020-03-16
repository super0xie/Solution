import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalListIntersections {
	
	
	class Node{
		int n;
		int se;
		
		Node(int n, int se){
			this.n = n;
			this.se = se;
		}
	}
	
	public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        ArrayList<Node> l = new ArrayList<>();
        
        for(Interval inter : A) {
        	Node s = new Node(inter.start, -1);
        	l.add(s);
        	Node e = new Node(inter.end, 1);
        	l.add(e);
        }
        
        for(Interval inter : B) {
        	Node s = new Node(inter.start, -1);
        	l.add(s);
        	Node e = new Node(inter.end, 1);
        	l.add(e);
        }
        
        Collections.sort(l, (a, b)->{
        	if(a.n != b.n) {
        		return a.n-b.n;
        	}else {
        		return a.se-b.se;
        	}
        });
        
        ArrayList<Interval> res = new ArrayList<>();
        Interval inter = new Interval(0, 0);
        int v = 0;
        for(Node n : l) {
        	int oldv = v;
        	if(n.se == -1) {
        		v++;
        	}else {
        		v--;
        	}
        	
        	if(v > 1) inter.start = n.n;
        	else if(oldv > 1 && v == 1) {
        		inter.end = n.n;
        		res.add(inter);
        		inter = new Interval(0, 0);
        	}
        }
        
        Interval[] ret = new Interval[res.size()];
        
        for(int i = 0; i < res.size(); i++) {
        	ret[i] = res.get(i);
        }
        
        return ret;
    }
	
	public static void main(String[] args) {
		IntervalListIntersections test = new IntervalListIntersections();
		Interval i1 = new Interval(0,2);
		Interval i2 = new Interval(5,10);
		Interval i3 = new Interval(13,23);
		Interval i4 = new Interval(24,25);
		Interval [] A = {i1, i2, i3, i4};
		
		Interval i5 = new Interval(1,5);
		Interval i6 = new Interval(8,12);
		Interval i7 = new Interval(15,24);
		Interval i8 = new Interval(25,26);
		Interval [] B = {i5, i6, i7, i8};
		
		test.intervalIntersection(A, B);
		
		
	}
	
}
