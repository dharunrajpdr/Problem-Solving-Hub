
// Example 1:
// Input: s = "][]["
// Output: 1
// Explanation: You can make the string balanced by swapping index 0 with index 3.
// The resulting string is "[[]]".
  
// Example 2:
// Input: s = "]]][[["
// Output: 2
// Explanation: You can do the following to make the string balanced:
// - Swap index 0 with index 4. s = "[]][][".
// - Swap index 1 with index 5. s = "[[][]]".
// The resulting string is "[[][]]".

class Solution {
    public int minSwaps(String s) {
        int imbalance=0;
        int swap=0;
        for(char c:s.toCharArray()){
            if(c=='['){
                imbalance++;
            }
            else{
                imbalance--;
            }
            if(imbalance<0){
                swap++;
                imbalance=1;
            }
        }
        return swap;
    }
}
