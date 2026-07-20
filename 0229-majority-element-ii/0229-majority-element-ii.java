class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int min=(int)(nums.length/3)+1;
        int count1=0,count2=0;
        int element1=0,element2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=element2){
                count1=1;
                element1=nums[i];
            }
            else if(count2==0 && nums[i]!=element1){
                count2=1;
                element2=nums[i];
            }
            else if(nums[i]==element1) count1++;
            else if(nums[i]==element2) count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1=0;count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element1) count1++;
            if(nums[i]==element2) count2++;
        }
        if(count1>=min && element1!=element2) result.add(element1);
        if(count2>=min) result.add(element2);
        return result;
    }
}