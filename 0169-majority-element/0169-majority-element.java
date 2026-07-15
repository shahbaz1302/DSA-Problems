class Solution {
    public int majorityElement(int[] nums) {
        int count1 = 0;
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0) {
                count1 = 1;
                element = nums[i];
            } else if (nums[i] == element) count1++;
            else count1--;
        }
        int count2 = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == element) count2++;
        }
        if (count2 > nums.length / 2) return element;
        return -1;
    }
}