class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> words = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        words.offer(beginWord);
        level.offer(1);
        dictionary.remove(beginWord);
        while (!words.isEmpty()) {
            String word = words.poll();
            int steps = level.poll();
            if (word.equals(endWord)) return steps;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original=chars[i];
                for (char j ='a'; j <= 'z'; j++) {
                    chars[i]=j;
                    String newWord = String.valueOf(chars);
                    if (dictionary.contains(newWord)) {
                        dictionary.remove(newWord);
                        words.offer(newWord);
                        level.offer(steps + 1);
                    }
                }
                chars[i]=original;
            }
        }
        return 0;
    }
}