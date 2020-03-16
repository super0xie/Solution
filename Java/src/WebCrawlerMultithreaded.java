import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class WebCrawlerMultithreaded {
	
	interface HtmlParser {
		public List<String> getUrls(String url);
	}
	
	class Parser implements HtmlParser{

		@Override
		public List<String> getUrls(String url) {
			try {
				Thread.sleep(15);
			}catch(Exception e) {
				
			}
			
			if(url.equals("http://news.yahoo.com/news/topics/")) {
				return Arrays.asList("http://news.yahoo.com", "http://news.yahoo.com/news");
			}else if(url.equals("http://news.google.com")) {
				return Arrays.asList("http://news.yahoo.com/news", "http://news.yahoo.com/news/topics/");
			}else if(url.equals("http://news.yahoo.com")) {
				return Arrays.asList("http://news.yahoo.com/us");
			}
			return Arrays.asList();
		}
		
	}
	
//	private String domain;
//	private HashSet<String> set;
//	private ReentrantLock lock = new ReentrantLock(true);
//	private int n;
//	private ExecutorService taskExecutor = Executors.newCachedThreadPool();
//	
//	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
//		List<String> res = new ArrayList<>();
//		
//        set = new HashSet<>();
//        String[] strs = startUrl.split("/+");
//        domain = strs[1];
//        taskExecutor.execute(()->{
//        	dfs(startUrl, domain, set, htmlParser);
//        });
//        
//        
//        
//        try {
//        	Thread.sleep(100);
//        	taskExecutor.shutdown();
//        	taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//        } catch (InterruptedException e) {
//        	  
//        }
//        
//        for(String str : set) res.add(str);
//        return res;
//    }
//	
//	private void dfs(String url, String domain, HashSet<String> set, HtmlParser htmlParser) {
//		lock.lock();
//		
//		if(!set.contains(url)) {
//			String[] strs = url.split("/+");
//			String d = strs[1];
//			if(d.equals(domain)) {
//				set.add(url);
//				List<String> l = htmlParser.getUrls(url);
//				
//				for(String u : l) {
//					
//					taskExecutor.execute(()->{
//						dfs(u, domain, set, htmlParser);
//			        });
//					
//				}
//				
//			}
//		}
//		
//		lock.unlock();
//	}
	
	private String domain;
	private ConcurrentHashMap <String, Integer> set;
	private AtomicInteger n;
	
	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		set = new ConcurrentHashMap<>();
		n = new AtomicInteger();
		List<String> res = new ArrayList<>();
		
        
        String[] strs = startUrl.split("/+");
        domain = strs[1];
        dfs(startUrl, htmlParser);
        
        while(true) {
        	try {
        		Thread.sleep(100);
        	} catch(Exception e) {
        		
        	}
        	if(n.get() == 0) break;
        }
        
        for(String str : set.keySet()) res.add(str);
        return res;
    }
	
	private void dfs(String url, HtmlParser htmlParser) {
		
		if(!set.contains(url)) {
			String[] strs = url.split("/+");
			String d = strs[1];
			if(d.equals(domain)) {
				
				List<String> l = htmlParser.getUrls(url);
				n.incrementAndGet();
				set.put(url, 1);
				for(String u : l) {
					Thread t = new Thread(()->{
						dfs(u, htmlParser);
					});
					t.start();
				}
				
				n.decrementAndGet();
				
			}
		}
		
	}
	
	

	public static void main(String[] args) {
		WebCrawlerMultithreaded test = new WebCrawlerMultithreaded();
		Parser p = test.new Parser();
		List<String> res = test.crawl("http://news.yahoo.com/news/topics/", p);
		for(String str : res)
			System.out.println(str);
	}
	
}
