class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        printSequences(0,new ArrayList<>(),result,nums);
        return result;
    }

    public void printSequences(int index,List<Integer> list,List<List<Integer>> result,int[] arr){
        if(index==arr.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[index]);
        printSequences(index+1,list,result,arr);
        list.remove(list.size()-1);
        printSequences(index+1,list,result,arr);
    }
}