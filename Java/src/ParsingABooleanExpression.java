import java.util.ArrayList;
import java.util.List;

public class ParsingABooleanExpression {

    public boolean parseBoolExpr(String str) {
        List<Boolean> ret = helper(str);
        return ret.get(0);
    }

    private List<Boolean> helper(String str){
        List<Boolean> res = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '!' || str.charAt(i) == '&' || str.charAt(i) == '|'){
                int count = 0;
                int j = i+1;
                for(; j < str.length(); j++){
                    if(str.charAt(j) == '(') count++;
                    else if(str.charAt(j) == ')') {
                        count--;
                        if(count == 0) break;
                    }
                }

                String sub = str.substring(i+2, j);
                List<Boolean> ret = helper(sub);
                Boolean toAdd = false;
                if(str.charAt(i) == '!'){
                    toAdd = !ret.get(0);
                }else if(str.charAt(i) == '&'){
                    toAdd = ret.get(0);
                    for(int k = 0; k < ret.size(); k++) toAdd = toAdd && ret.get(k); 
                }else if(str.charAt(i) == '|'){
                    toAdd = ret.get(0);
                    for(int k = 0; k < ret.size(); k++) toAdd = toAdd || ret.get(k); 
                }

                res.add(toAdd);
                i = j;
            }else if(str.charAt(i) == ','){
                continue;
            }else if(str.charAt(i) == 't'){
                res.add(true);
            }else if(str.charAt(i) == 'f'){
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ParsingABooleanExpression test = new ParsingABooleanExpression();
        System.out.println(test.parseBoolExpr("|(&(t,f,t),!(t))"));
    }




}