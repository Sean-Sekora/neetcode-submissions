class TimeMap {

    Map<String, Map<Integer, String>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        Map<Integer, String> mapValue = new HashMap<>();
        if (map.containsKey(key)) {
            mapValue = map.get(key);
        }
        mapValue.put(timestamp, value);
        map.put(key, mapValue);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        Map<Integer, String> mapValue = map.get(key);

        if (mapValue.containsKey(timestamp)) return mapValue.get(timestamp);

        int lastTimestamp = 0;
        for (int t : mapValue.keySet()) {
            if (t < timestamp) {
                lastTimestamp = Math.max(lastTimestamp, t);
            }
        }
        if (lastTimestamp > 0) return mapValue.get(lastTimestamp);

        return "";
    }
}
