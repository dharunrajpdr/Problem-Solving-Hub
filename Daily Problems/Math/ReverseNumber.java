
// Input: n = 25
// Output: 52
// Explanation: Reverse of 25 is 52.

// Input: n = 123
// Output: 321
// Explanation: Reverse of 123 is 321.

class Solution {
    public int reverseNumber(int n) {
         int rev=0;
         while(n>0){
            int mod=n%10;
            rev=rev*10+mod;
            n/=10;
         }
         return rev;
    }
}
