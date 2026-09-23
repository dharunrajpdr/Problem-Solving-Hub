class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int target=sum-x;
        int n=nums.length;
        if(target<0) return -1;
        if(target==0) return n;
        int left=0,right=0,len=-1;
        sum=0;
        while(right<n){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left++];
            }
            if(sum==target){
                len=Math.max(len,right-left+1);
            }
            right++;
        }
        return len==-1?-1:n-len;
    }
}
