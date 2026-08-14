class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        printSequences(0,new ArrayList<>(),result,nums);
        return result;
    }

    public static void printSequences(int index, List<Integer> list,List<List<Integer>> result, int[] arr) {
        result.add(new ArrayList<>(list));
        for(int i=index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            printSequences(i+1,list,result,arr);
            list.remove(list.size()-1);
        }
    }
}