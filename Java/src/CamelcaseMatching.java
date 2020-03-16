import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        for(String str : queries){
            res.add(helper(str, pattern));
        }
        return res;
    }

    private boolean helper(String q, String p){
        int idx = 0;

        for(int i = 0; i < q.length(); i++){
            if(idx < p.length() && q.charAt(i) == p.charAt(idx)){
                idx++;
            }else if(q.charAt(i) >= 'A' && q.charAt(i) <= 'Z') return false;
        }

        if(idx == p.length()) return true;
        else return false;
    }

}