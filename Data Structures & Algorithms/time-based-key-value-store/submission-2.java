class TimeMap {

    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> mapValue = new TreeMap<>();
        if (map.containsKey(key)) {
            mapValue = map.get(key);
        }
        mapValue.put(timestamp, value);
        map.put(key, mapValue);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        TreeMap<Integer, String> mapValue = map.get(key);
        Map.Entry<Integer, String> entry = mapValue.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
