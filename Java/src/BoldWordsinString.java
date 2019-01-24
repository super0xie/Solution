import java.util.ArrayList;
import java.util.Collections;

public class BoldWordsinString {
    
    class Inter implements Comparable<Inter>{
        int l;
        int r;
        Inter(int l, int r){
            this.l = l;
            this.r = r;
        }
        
        @Override
        public int compareTo(Inter o) {
            // TODO Auto-generated method stub
            return this.l - o.l;
        }
    }
    
    public String boldWords(String[] words, String S) {
        
        ArrayList<Inter> inters = new ArrayList<>();
        
        for(String str : words) {
            int idx = 0;
            while(true) {
                int match = S.indexOf(str, idx);
                if(match >= 0) {
                    inters.add(new Inter(match, match+str.length()-1));
                    idx = match+1;
                }else {
                    break;
                }
            }
        }
        if(inters.isEmpty()) return S;
        
        Collections.sort(inters);
        ArrayList<Inter> merged = new ArrayList<Inter>();
        Inter last = inters.get(0);
        merged.add(last);
        
        for(int i = 1; i < inters.size(); i++) {
            Inter inter = inters.get(i);
            if(last.r >= inter.l-1) {
                if(last.r < inter.r) last.r = inter.r;
            }else {
                last = new Inter(inter.l, inter.r);
                merged.add(last);
            }
        }
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(idx < merged.size()) {
                if(i == merged.get(idx).l) {
                    sb.append("<b>");
                    for(int j = i; j <= merged.get(idx).r; j++) {
                        sb.append(S.charAt(j));
                    }
                    sb.append("</b>");
                    i = merged.get(idx).r;
                    idx++;
                }else {
                    sb.append(S.charAt(i));
                }
            }else {
                sb.append(S.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        BoldWordsinString test = new BoldWordsinString();
        String[] words = {"b","dee","a","ee","c"};
        System.out.println(test.boldWords(words, "cebcecceab"));
    }
}
