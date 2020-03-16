import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class InvalidTransactions {
	
	
	class Tran{
		String name;
		int time;
		int amount;
		String city;
		String ori;
		
		Tran(String str){
			ori = str;
			String[] strs = str.split(",");
			name = strs[0];
			time = Integer.parseInt(strs[1]);
			amount = Integer.parseInt(strs[2]);
			city = strs[3];
		}
		
		
	}
	
	
	public List<String> invalidTransactions(String[] transactions) {
		ArrayList<String> res = new ArrayList<>();
		HashMap<String, ArrayList<Tran>> map = new HashMap<>();
		
		for(String str : transactions) {
			Tran t = new Tran(str);
			if(!map.containsKey(t.name)) map.put(t.name, new ArrayList<>());
			map.get(t.name).add(t);
		}
		
		for(String key : map.keySet()) {
			ArrayList<Tran> l = map.get(key);
			Collections.sort(l, (a, b)->{
				return a.time - b.time;
			});
			
			HashSet<Tran> set = new HashSet<>();
			
			for(int i = 0; i < l.size(); i++) {
				if(l.get(i).amount > 1000) set.add(l.get(i));
				for(int j = i+1; j < l.size(); j++) {
					if(l.get(j).time - l.get(i).time <= 60) {
						if(!l.get(j).city.equals(l.get(i).city)) {
							set.add(l.get(i));
							set.add(l.get(j));
						}
					}else {
						break;
					}
				}
			}
			
			for(Tran t : set) {
				res.add(t.ori);
			}
			
		}
		
		return res;
    }

}
