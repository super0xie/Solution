import java.util.HashMap;

public class EncodeandDecodeTinyURL {
	private HashMap<String, String> map;
	
	public String encode(String longUrl) {
        if(map == null) map = new HashMap<String, String>();
        String result = Integer.toHexString(longUrl.hashCode());
        map.put(result, longUrl);
        return result;
    }

    public String decode(String shortUrl) {
    	if(map == null) map = new HashMap<String, String>();
    	return map.get(shortUrl);
    }
	
	public static void main(String[] args) {
		System.out.println(Integer.toHexString("hello".hashCode()));
		
	}
}
