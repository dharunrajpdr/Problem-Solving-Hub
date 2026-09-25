
// Input: n = 121
// Output: true
// Explanation: When read from left to right : 121.
// When read from right to left : 121.

// Input: n = 123
// Output: false
// Explanation: When read from left to right : 123.
// When read from right to left : 321.


class Solution {
    public boolean isPalindrome(int n) {
         int n1=n;
         int rev=0;
         while(n1>0){
            int mod=n1%10;
            rev=rev*10+mod;
            n1/=10;
         }
        return n==rev;
    }
}
