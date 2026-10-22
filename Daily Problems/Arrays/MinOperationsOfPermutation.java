// You are given an integer array nums of length n, where nums is a permutation of the integers from 0 to n - 1.
// You may perform only the following operations:
// Reverse the entire array.
// Rotate Left by One: Move the first element to the end of the array, and rest elements to left by one position.
// Return an integer denoting the minimum number of operations required to sort the array in increasing order. If it is not possible to sort the array using only the given operations, return -1.
// Example 1:
// Input: nums = [0,2,1]
// Output: 2
// Explanation:
// Rotate Left by one: [2, 1, 0]
// Reverse the array: [0, 1, 2]
// The array becomes sorted in 2 operations, which is minimal

class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        //Find the position of 0
        int start=0;
        while(nums[start]!=0){
             start++;
        }
        boolean asc=true;
        boolean desc=true;
        //check circular order
        for(int i=1;i<n;i++){
            int value =nums[(start+i)%n];
            if(value!=i){
                asc=false;
            }
            if(value!=n-i){
                desc=false;
            }
            if(!asc && !desc){
                return -1;
            }
        }
        if(asc){
            return Math.min(start,n-start+2); 
        }
        return Math.min(n-start,start+2);
    }
}
