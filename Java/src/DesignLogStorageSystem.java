import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DesignLogStorageSystem {
    
    private HashMap<String, Integer> indice;
    private HashMap<Integer, int[]> log;
    //Year:Month:Day:Hour:Minute:Second
    public void LogSystem() {
        log = new HashMap<>();
        indice = new HashMap<>();
        indice.put("Year", 0);
        indice.put("Month", 1);
        indice.put("Day", 2);
        indice.put("Hour", 3);
        indice.put("Minute", 4);
        indice.put("Second", 5);
    }
    
    public void put(int id, String timestamp) {
        log.put(id, getDate(timestamp));
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int[] l = getDate(s);
        int[] u = getDate(e);
        int idx = indice.get(gra);
        List<Integer> res = new ArrayList<>();
        
        for(int id : log.keySet()) {
            if(between(log.get(id), l, u, idx)) res.add(id);
        }
        return res;
    }
    
    private boolean between(int[]t, int[] l, int[] u, int idx) {
        for(int i = 0; i <= idx; i++) {
            if(t[i] > u[i]) return false;
            if(t[i] < u[i]) break;
        }
        
        for(int i = 0; i <= idx; i++) {
            if(t[i] > l[i]) break;
            if(t[i] < l[i]) return false;
        }
        
        return true;
    }
    
    private int[] getDate(String s) {
        String[] strs = s.split(":");
        int[] ret = new int[6];
        for(int i = 0; i < 6; i++) {
            ret[i] = Integer.parseInt(strs[i]);
        }
        return ret;
    }
    
    public static void main(String[] args) {
        DesignLogStorageSystem test = new DesignLogStorageSystem();
        test.LogSystem();
        test.put(1,"2017:01:01:23:59:59");
        test.put(2,"2017:01:02:23:59:59");
//        test.put(3, "2016:01:01:00:00:00");
//        test.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        test.retrieve("2017:01:01:23:59:58","2017:01:02:23:59:58","Second");
        
    }
}
