import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class NumberofAtoms {

    public String countOfAtoms(String f) {
        HashMap<Integer, Integer> pair = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < f.length(); i++){
            if(f.charAt(i) == '(') s.push(i);
            else if(f.charAt(i) == ')') pair.put(s.pop(), i);
        }

        HashMap<String, Integer> res = helper(f, 0, f.length()-1, pair);
        
        ArrayList<String> keys = new ArrayList<>();
        for(String str : res.keySet()){
            keys.add(str);
        }
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for(String str : keys){
            sb.append(str);
            if(res.get(str) > 1) sb.append(res.get(str));
        }
        return sb.toString();
    }

    private HashMap<String, Integer> helper(String f, int l, int r, HashMap<Integer, Integer> pair){
        HashMap<String, Integer> ret = new HashMap<>();

        for(int i = l; i <= r; i++){
            if(f.charAt(i) == '('){
                HashMap<String, Integer> res = helper(f, i+1, pair.get(i)-1, pair);
                i = pair.get(i);
                int j = i+1;
                int count = 0;
                while(j <= r && f.charAt(j) >= '0' && f.charAt(j) <= '9'){
                    count = count * 10;
                    count += (int)(f.charAt(j)-'0');
                    j++;
                }
                if(count == 0) count = 1;
                i = j-1;
                for(String key : res.keySet()){
                    ret.put(key, ret.getOrDefault(key, 0) + count * res.get(key));
                }

                
            }else if(f.charAt(i) >= 'A' && f.charAt(i) <= 'Z'){
                String name;
                int j;
                if(i + 1 <= r && f.charAt(i+1) >= 'a' && f.charAt(i+1) <= 'z'){
                    name = f.substring(i, i+2);
                    j = i+2;
                }else{
                    name = f.substring(i, i+1);
                    j = i+1;
                }
                
                int count = 0;
                while(j <= r && f.charAt(j) >= '0' && f.charAt(j) <= '9'){
                    count = count * 10;
                    count += (int)(f.charAt(j)-'0');
                    j++;
                }
                if(count == 0) count = 1;
                i = j-1;

                ret.put(name, ret.getOrDefault(name, 0)+count);

                
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        NumberofAtoms test = new NumberofAtoms();
        System.out.println(test.countOfAtoms("Mg(OH)"));
        
    }

}