class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        printSequences(0,nums,result,new ArrayList());
        return result;
    }

    public void printSequences(int index,int[] arr,List<List<Integer>> result,List<Integer> temp){
        result.add(new ArrayList(temp));
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            temp.add(arr[i]);
            printSequences(i+1,arr,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}