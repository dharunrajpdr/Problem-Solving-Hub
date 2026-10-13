// Example 1:
// Input: nums = [1,2,3]
// Output: 12
// Explanation:
// A possible rearrangement for nums is [2,1,3], which gives the maximum alternating score among all possible rearrangements.
// The alternating score is calculated as:
// score = 22 - 12 + 32 = 4 - 1 + 9 = 12

// Example 2:
// Input: nums = [1,-1,2,-2,3,-3]
// Output: 16

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int mid=n/2;
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long smallersum=0;
        long largersum=0;
        for(int i=0;i<mid;i++){
            smallersum+=(int)Math.pow(nums[i],2);
        }
        for(int i=mid;i<nums.length;i++){
            largersum+=(int)Math.pow(nums[i],2);
        }
        return largersum-smallersum;
    }
}
