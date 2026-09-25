
// Input: n = 5
// Output: 1
// Explanation: 5 is an odd digit.

// Input: n = 25
// Output: 1
// Explanation: The only odd digit in 25 is 5.

class Solution {
    public int countOddDigit(int n) {
      int count=0;
      while(n>0){
        int mod=n%10;
        if(mod%2==1) count++;
        n/=10;
      }
      return count;
    }
}
