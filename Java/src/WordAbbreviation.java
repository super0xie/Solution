import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordAbbreviation {

    class Str {
        String str;
        int idx;

        Str(String str, int idx){
            this.str = str;
            this.idx = idx;
        }
    }
    public List<String> wordsAbbreviation(List<String> dict) {
        String[] res = new String[dict.size()];
        int idx = 0;
        HashMap<String, ArrayList<Str>> map = new HashMap<>();
        for(String str : dict){
            if(str.length() <= 3) res[idx] = str;
            else{
                String abbr = "" + str.charAt(0) + (str.length()-2) + str.charAt(str.length()-1);
                ArrayList<Str> l = map.getOrDefault(abbr, new ArrayList<Str>());
                l.add(new Str(str, idx));
                map.put(abbr, l);
            }
            idx++;
        }

        while(!map.isEmpty()){
            HashMap<String, ArrayList<Str>> aux = new HashMap<>();
            for(String str : map.keySet()){
                if(map.get(str).size() == 1){
                    res[map.get(str).get(0).idx] = str;
                }else{
                    int len = 0;
                    while(len < str.length() && str.charAt(len) >= 'a' && str.charAt(len) <= 'z') len++;

                    if(map.get(str).get(0).str.length() == len + 3){
                        for(Str s : map.get(str)){
                            res[s.idx] = s.str;
                        }
                    }else{
                        for(Str s : map.get(str)){
                            String abbr = "" + s.str.substring(0, len+1) + (s.str.length()-len-2) + str.charAt(str.length()-1);
                            ArrayList<Str> l = aux.getOrDefault(abbr, new ArrayList<Str>());
                            l.add(s);
                            aux.put(abbr, l);
                        }
                    }
                }
            }
            map = aux;
        }

        List<String> ret = new ArrayList<String>();
        for(String str : res){
            ret.add(str);
        }
        return ret;
    }

    public static void main(String[] args) {
        WordAbbreviation test = new WordAbbreviation();
        List<String> dict = Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion");
        List<String> ret = test.wordsAbbreviation(dict);
        for(String str : ret) System.out.println(str);
    }

}