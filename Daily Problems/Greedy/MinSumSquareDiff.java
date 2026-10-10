// Example 1:
// Input: nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0
// Output: 579
// Explanation: The elements in nums1 and nums2 cannot be modified because k1 = 0 and k2 = 0. 
// The sum of square difference will be: (1 - 2)2 + (2 - 10)2 + (3 - 20)2 + (4 - 19)2 = 579.
  
// Example 2:
// Input: nums1 = [1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1
// Output: 43
// Explanation: One way to obtain the minimum sum of square difference is: 
// - Increase nums1[0] once.
// - Increase nums2[2] once.
// The minimum of the sum of square difference will be: 
// (2 - 5)2 + (4 - 8)2 + (10 - 7)2 + (12 - 9)2 = 43.
// Note that, there are other ways to obtain the minimum of the sum of square difference, but there is no way to obtain a sum smaller than 43.

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int[] diff = new int[n];
        int maxDiff=0;
        long k=(long)k1+k2;
        long total=0;
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            maxDiff=Math.max(maxDiff,diff[i]);
            total+=diff[i];
        }
        if(k>=total){
            return 0;
        }
        int low=0,high=maxDiff;
        //find the minimum maximum difference possible
        while(low<high){
            int mid=low+(high-low)/2;
            long operations=0;
            for(int d:diff){
                operations+=Math.max(0,d-mid);
            }
            if(operations<=k){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        int target=low;
        long operation=0;
        long ans=0;
        for(int d:diff){
            int reduced=Math.min(d,target);
            operation+=Math.max(0, d - target);
            ans+=(long)reduced*reduced;
        }
        long remaining=k-operation;
        ans-=remaining*(2L*target-1);
        return ans;
    }
}
