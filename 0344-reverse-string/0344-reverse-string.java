class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(i<j){
            swap(s,i,j);
            i++;
            j--;
        }
    }

    public void swap(char[] a,int s, int e){
        char temp=a[s];
        a[s]=a[e];
        a[e]=temp;
    }
}