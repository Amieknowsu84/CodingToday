class Twitter {

    // every user has a list of followers
    // whenever they post tweet the followers news feed should be updated of followers
    // getNews feeds will get only 10 lates feeds so need to capture 10 only
    // user follow list can be updated based on follow unfollow
    
    
    Map<Integer,Set<Integer>> followers;
    Map<Integer,PriorityQueue<Pair<Integer,Integer>>> tweets;
    int tweetCount = 0;
    
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            tweets.put(userId,new PriorityQueue<>((a,b)->a.getValue()-b.getValue()));
        }
        
        add(tweets.get(userId),new Pair<>(tweetId,tweetCount++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
     
        PriorityQueue<Pair<Integer,Integer>> feedsQueue = new PriorityQueue<>(
                                                          (a,b)->a.getValue()-b.getValue());
        
        if(followers.get(userId) != null)
        for(int follower:followers.get(userId)){
            PriorityQueue<Pair<Integer,Integer>> tweetIds = tweets.containsKey(follower)
                                              ? tweets.get(follower) : null;
            if(tweetIds != null)
            for(Pair<Integer,Integer> tweet: tweetIds){
                add(feedsQueue,tweet);
            }
        }
        
        PriorityQueue<Pair<Integer,Integer>> tweetIds = tweets.containsKey(userId) 
                                          ? tweets.get(userId) : null;
        if(tweetIds != null)
        for(Pair<Integer,Integer> tweet: tweetIds){
            add(feedsQueue,tweet);
        }
        
        List<Pair<Integer,Integer>> result =  new ArrayList<>(feedsQueue);
        Collections.sort(result,(a,b)->b.getValue()-a.getValue());
        //result.stream().forEach(System.out::println);
        return result.stream().map(a->a.getKey()).collect(Collectors.toList());
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId,new HashSet<Integer>());
        }
        
        Set<Integer> followersSet = followers.get(followerId);
        followersSet.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId) && followers.get(followerId)!=null)
           followers.get(followerId).remove(followeeId);
    }
    
    private void add(PriorityQueue<Pair<Integer,Integer>> queue,Pair<Integer,Integer> tweet){
        queue.add(tweet);
        if(queue.size() > 10){
            queue.remove();
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */