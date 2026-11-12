class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen=0;
        //Find the longest increasing subarray
        for(int start=0;start<nums.length;start++){
            int currLen=1;
            for(int pos=start+1;pos<nums.length;pos++){
                if(nums[pos]>nums[pos-1]){
                    currLen++;
                }
                else{
                    break;
                }
            }
            maxLen=Math.max(maxLen,currLen);
        }
        //Find the longest decreasing subarray
        for(int start=0;start<nums.length;start++){
            int currLen=1;
            for(int pos=start+1;pos<nums.length;pos++){
                if(nums[pos]<nums[pos-1]){
                    currLen++;
                }
                else{
                    break;
                }
            }
            maxLen=Math.max(maxLen,currLen);
        }
        return maxLen;
    }
}
