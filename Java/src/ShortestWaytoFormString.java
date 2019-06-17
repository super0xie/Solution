import java.util.ArrayList;
import java.util.Collections;

public class ShortestWaytoFormString {

    public int shortestWay(String source, String target) {
        ArrayList<Integer>[] l = new ArrayList[26];
        for(int i = 0; i < source.length(); i++){
            if(l[source.charAt(i)-'a'] == null) l[source.charAt(i)-'a'] = new ArrayList<>();
            l[source.charAt(i)-'a'].add(i);
        }

        int idx = -1;
        int res = 1;
        for(int i = 0; i < target.length(); i++){
            if(l[target.charAt(i)-'a'] == null) return -1;
            ArrayList<Integer> list = l[target.charAt(i)-'a'];
            int ret = Collections.binarySearch(list, idx+1);
            if(ret >= 0){
                idx = list.get(ret);
            }else{
                int ip = -ret-1;
                if(ip == list.size()) {
                    idx = -1;
                    res++;
                    i--;
                }else{
                    idx = list.get(ip);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ShortestWaytoFormString test = new ShortestWaytoFormString();
        System.out.println(test.shortestWay("adbsc", "addddddddddddsbc"));
    }

}