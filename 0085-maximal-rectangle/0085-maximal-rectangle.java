class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length, maxArea=0;
        int[][] preSum=new int[m][n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=matrix[j][i]-'0';
                if(matrix[j][i]=='0') sum=0;
                preSum[j][i]=sum;
            }
        }
        for(int i=0;i<m;i++){
            maxArea=Math.max(maxArea,largestRectangleArea(preSum[i]));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element=st.pop();
                int nse=i,pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element=st.pop();
            int nse=heights.length,pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(maxArea,heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
}