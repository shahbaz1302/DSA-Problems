class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;
        Map<Character, Integer> map = new HashMap<>();
        int count = p.length();
        int left = 0;
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            int val = map.getOrDefault(rightChar, 0);
            if (val > 0)
                count--;
            map.put(rightChar, val - 1);
            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                int leftVal = map.getOrDefault(leftChar, 0);
                if (leftVal >= 0)
                    count++;
                map.put(leftChar, leftVal + 1);
                left++;
            }
            if (count == 0)
                result.add(left);
        }
        return result;
    }
}