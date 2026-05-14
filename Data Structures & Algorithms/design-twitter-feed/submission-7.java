class Twitter {

    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<int[]>> userTweets;
    private final static int CAPACITY = 10;
    private int time;

    public Twitter() {
        this.followers = new HashMap<>();
        this.userTweets = new LinkedHashMap<>();
        this.time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>());
        userTweets.get(userId).add(new int[]{time++, tweetId});
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>();
        for (Integer followeeId : followers.get(userId)) {
            feed.addAll(userTweets.get(followeeId));
        }
        feed.sort((a,b) -> Integer.compare(b[0],a[0]));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(CAPACITY, feed.size()); i++) result.add(feed.get(i)[1]);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) followers.get(followerId).remove(followeeId);
    }
}
