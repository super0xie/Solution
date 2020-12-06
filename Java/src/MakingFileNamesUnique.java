import java.util.HashMap;
import java.util.HashSet;

public class MakingFileNamesUnique {

	public String[] getFolderNamesTLE(String[] names) {
        HashSet<String> set = new HashSet<>();
        String[] res = new String[names.length];
        for(int i = 0; i < names.length; i++) {
        	String cand = names[i];
        	int j = 1;
        	while(set.contains(cand)) {
        		cand = names[i] + "(" + j + ")";
        		j++;
        	}
        	set.add(cand);
        	res[i] = cand;
        }
        return res;
    }
	
	public String[] getFolderNamesLowPass(String[] names) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, HashSet<Integer>> map = new HashMap<>();
        String[] res = new String[names.length];
        for(int i = 0; i < names.length; i++) {
        	String s = names[i];
        	String base = null;
        	int idx = -1;
        	
        	if(s.matches(".*\\(\\d+\\)$")) {
        		int j = s.length()-1;
        		while(s.charAt(j) != '(') j--;
        		base = s.substring(0, j);
        		idx = Integer.parseInt(s.substring(j+1, s.length()-1));
        	}else {
        		base = s;
        	}
        	
        	if(set.contains(s)) {
        		if(!map.containsKey(s)) map.put(s, new HashSet<>());
    			HashSet<Integer> indice = map.get(s);
    			int j = 1;
    			while(indice.contains(j)) j++;
    			String r = s + "(" + j + ")";
    			res[i] = r;
    			indice.add(j);
    			set.add(r);
        	} else {
        		set.add(s);
        		res[i] = s;
        		if(idx >= 0) {
        			if(!map.containsKey(base)) map.put(base, new HashSet<>());
        			map.get(base).add(idx);
        		}
        	}
        }
        return res;
    }
	
	class Aux{
		HashSet<Integer> set;
		int i;
		
		Aux(){
			set = new HashSet<>();
			i = 1;
		}
		
		int geti(){
			int res = i;
			set.add(i);
			i++;
			while(set.contains(i)) i++;
			return res;
		}
		
		void add(int j) {
			set.add(j);
			while(set.contains(i)) i++;
		}
	}
	
	public String[] getFolderNames(String[] names) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Aux> map = new HashMap<>();
        String[] res = new String[names.length];
        for(int i = 0; i < names.length; i++) {
        	String s = names[i];
        	String base = null;
        	int idx = -1;
        	
        	if(s.matches(".*\\(\\d+\\)$")) {
        		int j = s.length()-1;
        		while(s.charAt(j) != '(') j--;
        		base = s.substring(0, j);
        		idx = Integer.parseInt(s.substring(j+1, s.length()-1));
        	}else {
        		base = s;
        	}
        	
        	if(set.contains(s)) {
        		if(!map.containsKey(s)) map.put(s, new Aux());
    			int j = map.get(s).geti();
    			String r = s + "(" + j + ")";
    			res[i] = r;
    			set.add(r);
        	} else {
        		set.add(s);
        		res[i] = s;
        		if(idx >= 0) {
        			if(!map.containsKey(base)) map.put(base, new Aux());
        			map.get(base).add(idx);
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		MakingFileNamesUnique test = new MakingFileNamesUnique();
		String[] res = test.getFolderNames(new String[] {"gta","gta(1)","gta","avalon"});
		for(String s : res) System.out.print(s + " ");
//		System.out.println("kaido(1)".matches(".*\\(\\d+\\)$"));
		
	}
}
