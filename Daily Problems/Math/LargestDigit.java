

// Example 1:
// Input: n = 25
// Output: 5
// Explanation: The largest digit in 25 is 5.

// Example 2:
// Input: n = 99
// Output: 9
// Explanation: The largest digit in 99 is 9.

class Solution {
    public int largestDigit(int n) {
        int max=0;
        while(n>0){
            int mod=n%10;
            if(mod>max) max=mod;
            n/=10;
        }
        return max;
    }
}
