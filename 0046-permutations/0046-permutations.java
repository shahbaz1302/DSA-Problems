class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        findPermutations(0,nums,result);
        return result;
    }

    public void findPermutations(int index,int[] nums,List<List<Integer>> result) {
        if(index==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++) list.add(nums[i]);
            result.add(list);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            findPermutations(index+1,nums,result);
            swap(nums,i,index);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}