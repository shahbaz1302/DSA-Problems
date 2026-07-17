class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int length=1;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for (int item : set) {
            if (!set.contains(item - 1)) {
                int count = 1;
                int x = item;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count++;
                }
                length = Math.max(length, count);
            }
        }
        return length;
    }
}