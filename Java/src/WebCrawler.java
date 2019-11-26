import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WebCrawler {
	
	interface HtmlParser {
		public List<String> getUrls(String url);
	}
	
	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String[] strs = startUrl.split("/+");
        String domain = strs[1];
        dfs(startUrl, domain, set, htmlParser);
        
        for(String str : set) res.add(str);
        return res;
    }
	
	private void dfs(String url, String domain, HashSet<String> set, HtmlParser htmlParser) {
		if(set.contains(url)) return;
		
		String[] strs = url.split("/+");
		String d = strs[1];
		if(d.equals(domain)) {
			set.add(url);
			List<String> l = htmlParser.getUrls(url);
			
			for(String u : l) {
				dfs(u, domain, set, htmlParser);
			}
		}
			
	}
	
}
