class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        Map<Character,Integer> map=new HashMap();
        for(int i=0;i<s1.length();i++) map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        int count=s1.length(),left=0;
        for(int right=0;right<s2.length();right++){
            char ch=s2.charAt(right);
            if(map.getOrDefault(ch,0)>0) count--;
            map.put(ch,map.getOrDefault(ch,0)-1);
            if(count==0) return true;
            if(right-left+1==s1.length()){
                char ch1=s2.charAt(left);
                if(map.getOrDefault(ch1,0)>=0) count++;
                map.put(ch1,map.getOrDefault(ch1,0)+1);
                left++;
            }
        }
        return false;
    }
}