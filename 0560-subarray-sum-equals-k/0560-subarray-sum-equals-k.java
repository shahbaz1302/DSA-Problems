class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int rem=preSum-k;
            count += map.getOrDefault(rem,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}