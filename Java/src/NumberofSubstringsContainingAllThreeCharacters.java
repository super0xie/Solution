import java.util.LinkedList;
import java.util.TreeSet;

public class NumberofSubstringsContainingAllThreeCharacters {
    
    public int numberOfSubstringsOld(String s) {
        TreeSet<Integer>[] sets = new TreeSet[3];
        for(int i = 0; i < sets.length; i++) {
            sets[i] = new TreeSet<>();
        }
        
        for(int i = 0; i < s.length(); i++) {
            sets[s.charAt(i)-'a'].add(i);
        }
        
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            int j = 0;
            int max = 0;
            for(; j < 3; j++) {
                Integer ret = sets[j].ceiling(i);
                if(ret == null) break;
                max = Math.max(max, ret);
            }
            if(j != 3) break;
            
            res += s.length()-max;
        }
        
        return res;
    }
    
    public int numberOfSubstrings(String s) {
        LinkedList<Integer>[] sets = new LinkedList[3];
        for(int i = 0; i < sets.length; i++) {
            sets[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < s.length(); i++) {
            sets[s.charAt(i)-'a'].add(i);
        }
        
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            int j = 0;
            int max = 0;
            for(; j < 3; j++) {
                while(!sets[j].isEmpty() && sets[j].getFirst() < i) sets[j].removeFirst();
                if(sets[j].isEmpty()) break;
                max = Math.max(max, sets[j].getFirst());
            }
            if(j != 3) break;
            
            res += s.length()-max;
        }
        
        return res;
    }
    
}
