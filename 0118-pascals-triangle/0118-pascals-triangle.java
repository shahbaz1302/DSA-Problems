class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList();
        for(int i=1;i<=numRows;i++){
            result.add(generateRows(i));
        }
        return result;
    }

    public List<Integer> generateRows(int rowIndex){
        int ans=1;
        List<Integer> list=new ArrayList();
        list.add(ans);
        for(int i=1;i<rowIndex;i++){
            ans=ans*(rowIndex-i);
            ans=ans/i;
            list.add(ans);
        }
        return list;
    }
}