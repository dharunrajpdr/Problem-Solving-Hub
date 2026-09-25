
// Input: n = 4
// Output: 1
// Explanation: There is only 1 digit in 4

// Input: n = 14
// Output: 2
// Explanation: There are 2 digits in 14.

class Solution {
    public int countDigit(int n) {
       int count=0;
       if(n==0) return 1;
       while(n>0){
        count++;
        n/=10;
       }
       return count;
    }
}
