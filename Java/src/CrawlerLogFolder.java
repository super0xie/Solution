
public class CrawlerLogFolder {
	
	public int minOperations(String[] logs) {
        int count = 0;
        for(String s : logs) {
        	if(s.equals("../")) {
        		if(count > 0) count--;
        	} else if(s.equals("./")) continue;
        	else count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		CrawlerLogFolder test = new CrawlerLogFolder();
		String[] logs = {"./","../","./"};
		System.out.println(test.minOperations(logs));
	}
	
}
