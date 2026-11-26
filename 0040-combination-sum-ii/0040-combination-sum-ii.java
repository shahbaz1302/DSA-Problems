class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0,candidates,target,result,new ArrayList());
        return result;
    }

    public void findCombination(int index,int[] arr, int target, List<List<Integer>> result,List<Integer> temp){
        if(target==0){
            result.add(new ArrayList(temp));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            temp.add(arr[i]);
            findCombination(i+1,arr,target-arr[i],result,temp);
            temp.remove(temp.size()-1);
        }
    }
}