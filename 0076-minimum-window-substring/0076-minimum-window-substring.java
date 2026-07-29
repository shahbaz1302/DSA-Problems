class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:t.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        int left = 0,minLen = Integer.MAX_VALUE,count=t.length();
        String ans="";
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                if(map.get(c)>0) count--;
                map.put(c,map.get(c)-1);
            }
            while(count==0){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    ans=s.substring(left,right+1);
                }
                char c1 = s.charAt(left);
                if(map.containsKey(c1)){
                    map.put(c1,map.get(c1)+1);
                    if(map.get(c1)>0) count++;
                }
                left++;
            }
        }
        return ans;
    }
}