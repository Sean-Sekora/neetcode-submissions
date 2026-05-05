class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        encoded.append(strs.size());
        StringBuilder concat = new StringBuilder(",");
        for (String str : strs) {
            encoded.append(",").append(str.length());
            concat.append(str);
        }
        encoded.append(concat);
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        String[] split = str.split(",");
        int stringCount = Integer.parseInt(split[0]);
        int[] lengths = new int[stringCount];
        int left = split[0].length() + 1;

        for (int i = 1; i <= stringCount; i++) {
            left += split[i].length() + 1;
            lengths[i-1] = Integer.parseInt(split[i]);
        }

        for (int length : lengths) {
            decoded.add(str.substring(left, left + length));
            left += length;
        }

        return decoded;
    }
}
