// Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
// Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
// Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
// In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
// For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
// You can insert the characters '(' and ')' at any position of the string to balance it if needed.
// Return the minimum number of insertions needed to make s balanced.

 

// Example 1:
// Input: s = "(()))"
// Output: 1
// Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
  
// Example 2:
// Input: s = "())"
// Output: 0
// Explanation: The string is already balanced.

class Solution {
    public int minInsertions(String s) {
        int insertions=0;
        int need=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                need=need+2;
                //if need is odd,then insert '(' to complete the pair
                if(need%2==1){
                    insertions++;
                    need--; 
                }
            }
            else{
                need--;
                //No opening is available for this
                if(need<0){
                    insertions++;
                    need=1;
                }
            }
        }
        //Insert any remaining required closing parenthesis
        return insertions+need;
    }
}
