class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++) map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        int left = 0,count=s1.length();
        for(int right = 0;right<s2.length();right++){
            char ch = s2.charAt(right);
            int val = map.getOrDefault(ch,0);
            if(val>0) count--;
            map.put(ch,val-1);
            if(count==0) return true;
            if(right-left+1==s1.length()){
                char ch1 = s2.charAt(left);
                int leftVal = map.get(ch1);
                if(leftVal>=0) count++;
                map.put(ch1,leftVal+1);
                left++;
            }
        }
        return false;
    }
}