class Solution {
    String b;
    Map<String,Integer> mpp;
    List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        b=beginWord;
        mpp = new HashMap<>();
        queue.add(beginWord);
        mpp.put(beginWord,1);
        dictionary.remove(beginWord);
        while(!queue.isEmpty()){
            String word = queue.poll();
            int steps = mpp.get(word);
            if(word.equals(endWord)) break;
            for(int i = 0; i < beginWord.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord=new String(replacedCharArray);
                    if(dictionary.contains(replacedWord)){
                        queue.add(replacedWord);
                        mpp.put(replacedWord,steps+1);
                        dictionary.remove(replacedWord);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(mpp.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }

    public void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = mpp.get(word);
        for(int i = 0; i < word.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                char[] replacedCharArray=word.toCharArray();
                replacedCharArray[i] = c;
                String replacedWord=new String(replacedCharArray);
                if(mpp.containsKey(replacedWord) && mpp.get(replacedWord)+1==steps){
                    seq.add(replacedWord);
                    dfs(replacedWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
}