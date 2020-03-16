import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SmallestSufficientTeam {


    private int size = Integer.MAX_VALUE;
    private int[] res;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(String str : req_skills){
            map.put(str, idx);
            idx++;
        }

        int[] p = new int[people.size()];
        idx = 0;
        for(int i = 0; i < people.size(); i++){
            int n = 0;
            for(String str : people.get(i)){
                if(map.containsKey(str)){
                    int index = map.get(str);
                    n = n | (1 << index);
                }
            }
            p[idx++] = n;
        }
        
        for(int i = 0; i < p.length; i++) {
        	for(int j = i+1; j < p.length; j++) {
        		if(p[i] == -1 || p[j] == -1) continue;
        		int and = p[i] | p[j];
        		if(and == p[i]) p[j] = -1;
        		if(and == p[j]) p[i] = -1;
        	}
        }
        

        int target = (1 << req_skills.length) - 1;
        helper(0, new ArrayList<>(), p, 0, target);

        return res;
    }

    private void helper(int i, ArrayList<Integer> aux, int[] people, int cur, int target){
        if(i == people.length) return;
        if(aux.size() + 1 >= size) return;
        
        if(people[i] == -1) {
        	helper(i+1, aux, people, cur, target);
        	return;
        }
        
        aux.add(i);
        int res = cur | people[i];
        if(res == target){
            this.res = new int[aux.size()];
            for(int j = 0; j < aux.size(); j++) this.res[j] = aux.get(j);
            size = aux.size();
            aux.remove(aux.size()-1);
        }else{
        	if(res != cur)
        		helper(i+1, aux, people, res, target);
            aux.remove(aux.size()-1);
            helper(i+1, aux, people, cur, target);
        }
    }

    public static void main(String[] args) {
        SmallestSufficientTeam test = new SmallestSufficientTeam();
        String[] req_skills = {"algorithms","math","java","reactjs","csharp","aws"};
        List<List<String>> people = new ArrayList<>();
        people.add(Arrays.asList("algorithms","math","java"));
        people.add(Arrays.asList("algorithms","math","reactjs"));
        people.add(Arrays.asList("java","csharp","aws"));
        people.add(Arrays.asList("reactjs","csharp"));
        people.add(Arrays.asList("csharp","math"));
        people.add(Arrays.asList("aws","java"));

        int[] res = test.smallestSufficientTeam(req_skills, people);
        for(int i : res) System.out.print(i + ",");
    }
    
}