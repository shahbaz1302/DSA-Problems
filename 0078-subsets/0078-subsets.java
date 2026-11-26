class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        powerSet(0,nums,result,new ArrayList());
        return result;
    }

    public void powerSet(int index,int[] arr,List<List<Integer>> result, List<Integer> temp){
        if(index==arr.length){
            result.add(new ArrayList(temp));
            return;
        }
        temp.add(arr[index]);
        powerSet(index+1,arr,result,temp);
        temp.remove(temp.size()-1);
        powerSet(index+1,arr,result,temp);
    }
}