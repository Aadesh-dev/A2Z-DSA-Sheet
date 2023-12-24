class Twitter {

    Map<Integer, List<Pair<Integer, Integer>>> tweets;
    Map<Integer, Set<Integer>> users;
    int count;

    public Twitter() {
        tweets = new HashMap<>();
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Pair<Integer, Integer>> tweet = tweets.getOrDefault(userId, new ArrayList<>());
        tweet.add(new Pair(++count, tweetId));
        tweets.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<>((list1, list2) -> list2.get(0) - list1.get(0));
        if(users.get(userId) != null) {
            for(int followeeId : users.get(userId)) {
                if(tweets.get(followeeId) != null) {
                    List<Pair<Integer, Integer>> tweet = tweets.get(followeeId);
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(tweet.get(tweet.size() - 1).getKey());
                    list.add(tweet.get(tweet.size() - 1).getValue());
                    list.add(tweet.size() - 1);
                    list.add(followeeId);
                    heap.add(list);
                }
            }
        }

        if(tweets.get(userId) != null) {
                List<Pair<Integer, Integer>> tweet = tweets.get(userId);
                ArrayList<Integer> list = new ArrayList<>();
                list.add(tweet.get(tweet.size() - 1).getKey());
                list.add(tweet.get(tweet.size() - 1).getValue());
                list.add(tweet.size() - 1);
                list.add(userId);
                heap.add(list);
            }

            while(!heap.isEmpty() && newsFeed.size() < 10) {
                ArrayList<Integer> mostRecent = heap.poll();
                newsFeed.add(mostRecent.get(1));
                if(mostRecent.get(2) >= 1) {
                    mostRecent.set(2, mostRecent.get(2) - 1);
                    mostRecent.set(1, tweets.get(mostRecent.get(3)).get(mostRecent.get(2)).getValue());
                    mostRecent.set(0, tweets.get(mostRecent.get(3)).get(mostRecent.get(2)).getKey());
                    heap.add(mostRecent);
                }
            }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> user = users.getOrDefault(followerId, new HashSet<>());
        user.add(followeeId);
        users.put(followerId, user);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(users.get(followerId) != null) users.get(followerId).remove(followeeId);
    }
}
//Time:
//follow - O(1)
//unfollow - O(1)
//postTweet - O(1)
//getNewsFeed - O(k * log(k) + 10 * 2 * log(k)) => O((20 + k) * log(k))
//where k = number of followees of userId

//Space: O(n), where n = max between number of tweets and number of users

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */