class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        findCombinations(0,candidates,target,result,new ArrayList<>());
        return result;
    }

    public void findCombinations(int index,int[] arr,int target,List<List<Integer>> result,List<Integer> temp){
        if(index==arr.length){
            if(target==0) result.add(new ArrayList<>(temp));
            return;
        }
        if(arr[index]<=target){
            temp.add(arr[index]);
            findCombinations(index,arr,target-arr[index],result,temp);
            temp.remove(temp.size()-1);
        }
        findCombinations(index+1,arr,target,result,temp);
    }
}