
// Example 1:
// Input: seq = "(()())"
// Output: [0,1,1,1,1,0]
// Example 2:

// Input: seq = "()(())()"
// Output: [0,0,0,1,1,0,1,1]

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth=0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                depth++;
                ans[i]=depth%2;
            }
            else{
                ans[i]=depth%2;
                depth--;
            }
        }
        return ans;
    }
}
