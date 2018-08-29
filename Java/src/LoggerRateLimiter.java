import java.util.HashMap;

public class LoggerRateLimiter {
    
    private HashMap<String, Integer> map;

    public LoggerRateLimiter() {
        map = new HashMap<String, Integer>();
    }
    
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            int lastTime = map.get(message);
            if(timestamp - lastTime < 10) return false;
            else {
                map.put(message, timestamp);
                return true;
            }
        }else {
            map.put(message, timestamp);
            return true;
        }
    }
}
