
// Example 1:
// Input: n = 2
// Output: 2
// Explanation: 2! = 1 * 2 = 2.

// Example 2:
// Input: n = 0
// Output: 1
// Explanation: 0! is defined as 1.

class Solution {
    public int factorial(int n) {
        if(n==0) return 1;
        int fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
}
