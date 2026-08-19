class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse=findNSE(arr);
        int[] psee=findPSEE(arr);
        long total=0;
        long mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++){
            long left=i-psee[i];
            long right=nse[i]-i;
            total=(total+(right*left*arr[i])%mod)%mod;
        }
        return (int)total;
    }

    public int[] findNSE(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]) stack.pop();
            res[i]=stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] findPSEE(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]) stack.pop();
            res[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return res;
    }
}