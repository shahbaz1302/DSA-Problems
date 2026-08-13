class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,result,new ArrayList<>());
        return result;
    }

    public void findCombinations(int index,int[] arr,int target,List<List<Integer>> result,List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<arr.length;i++) {
            if (arr[i] > target) break;
            temp.add(arr[i]);
            findCombinations(i,arr,target-arr[i],result,temp);
            temp.remove(temp.size()-1);
        }
    }
}