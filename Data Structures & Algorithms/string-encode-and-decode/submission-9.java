class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        String current = "";
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '#') {
                length = Integer.parseInt(current);
                if (length == 0) {
                    decoded.add("");
                } else {
                    decoded.add(str.substring(i + 1, i + 1 + length));
                    i = i + length;
                }
                current = "";
            } else {
                current += c;
            }
        }

        return decoded;
    }
}
