import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Twitter {
    
    private class User{
        int id;
        HashSet<Integer> follow;
        ArrayList<Integer> tweet;
        User(int id){
            this.id = id;
            this.follow = new HashSet<Integer>();
            this.tweet = new ArrayList<Integer>();
        }
    }
    
    private HashMap<Integer, User> db;
    private HashMap<Integer, Integer> tweets;
    private int inc = 0;
    

    /** Initialize your data structure here. */
    public Twitter() {
        db = new HashMap<Integer, User>();
        tweets = new HashMap<Integer, Integer>();
        inc = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        
        if(db.containsKey(userId)) {
            db.get(userId).tweet.add(inc);
            
            
        }else {
            User user = new User(userId);
            user.tweet.add(inc);
            db.put(userId, user);
        }
        tweets.put(inc, tweetId);
        inc++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!db.containsKey(userId)) db.put(userId, new User(userId));
        List<List<Integer>> tweetLists = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        
        int count = 0;
        User user = db.get(userId);
        tweetLists.add(user.tweet);
        count += user.tweet.size();
        
        for(int i : user.follow) {
            tweetLists.add(db.get(i).tweet);
            count += db.get(i).tweet.size();
        }
        
        count = Math.min(count, 10);
        
        HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        
        for(List<Integer> tweets : tweetLists) {
            map.put(tweets, tweets.size()-1);
        }
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>((a, b)->{
            int idxA = map.get(a);
            int idxB = map.get(b);
            
            if(idxA < 0 && idxB < 0) return 0;
            if(idxA < 0 && idxB >= 0) return 1;
            if(idxB < 0 && idxA >= 0) return -1;
            else {
                int tA = a.get(idxA);
                int tB = b.get(idxB);
                
                return tB - tA;
            }
        });
        
        for(List<Integer> tweets : tweetLists) {
            pq.add(tweets);
        }
        
        while(count > 0) {
            List<Integer> polled = pq.poll();
            int idx = map.get(polled);
            res.add(tweets.get(polled.get(idx)));
            map.put(polled, idx-1);
            pq.add(polled);
            count--;
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!db.containsKey(followerId)) db.put(followerId, new User(followerId));
        if(!db.containsKey(followeeId)) db.put(followeeId, new User(followeeId));
        db.get(followerId).follow.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!db.containsKey(followerId) || !db.containsKey(followeeId)) return;
        db.get(followerId).follow.remove(followeeId);
    }
    
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1));
    }
}