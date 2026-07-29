class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) left = Math.max(left, map.get(c) + 1);
            map.put(c, right);
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}