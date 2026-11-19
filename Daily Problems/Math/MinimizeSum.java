class Solution {
    public int minimizeSum(int[] nums) {
       int n = nums.length;
       Arrays.sort(nums);
       
       //Case 1: changing the two largest element
       int ans = nums[n-3]-nums[0];

       //Case 2: changing the smallest and the largest
       ans = Math.min(ans,nums[n-2]-nums[1]);

       //Case 3: changing the two smallest element
       ans = Math.min(ans,nums[n-1]-nums[2]);

       return ans;
    }
}
