import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class FirstUniqueNumber {
	
	private TreeSet<Num> set = new TreeSet<>();
	private HashMap<Integer, Num> all = new HashMap<>();
	
	class Num{
		int n;
		int idx;
		
		Num(int n, int idx){
			this.n = n;
			this.idx = idx;
		}
	}
	
	public void FirstUnique(int[] nums) {
		set = new TreeSet<>((a, b)-> {return a.idx - b.idx;});
		
        for(int i : nums) {
        	if(all.containsKey(i)) {
        		Num n = all.get(i);
        		if(set.contains(n)) set.remove(n);
        	}else {
        		Num n = new Num(i, all.size());
        		set.add(n);
        		all.put(i, n);
        	}
        }
    }
    
    public int showFirstUnique() {
        if(set.isEmpty()) return -1;
        return set.first().n;
    }
    
    public void add(int i) {
    	if(all.containsKey(i)) {
    		Num n = all.get(i);
    		if(set.contains(n)) set.remove(n);
    	}else {
    		Num n = new Num(i, all.size());
    		set.add(n);
    		all.put(i, n);
    	}
    }
    
    public static void main(String[] args) {
    	FirstUniqueNumber test = new FirstUniqueNumber();
    	test.FirstUnique(new int [] {2, 3, 5} );
    	System.out.println(test.showFirstUnique());
    	test.add(5);
    	System.out.println(test.showFirstUnique());
    	test.add(2);
    	System.out.println(test.showFirstUnique());
    	test.add(3);
    	System.out.println(test.showFirstUnique());
    }
}
