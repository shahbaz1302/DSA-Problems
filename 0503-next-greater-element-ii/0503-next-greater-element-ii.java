class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]) stack.pop();
            if(i<n) res[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}