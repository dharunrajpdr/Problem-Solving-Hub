
// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
  
// Example 2:
// Input: n = 1
// Output: ["()"]

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"",0,0,n);            //open=0,close=0,n=total 
        return res;
    }
    private void backtrack(List<String> res,String current,int open,int close,int n){
        //we use all 2*n parentheses
        if(current.length()==2*n){
            res.add(current);
            return;
        }
        //Add 'C'
        if(open<n){
            backtrack(res,current+"(",open+1,close,n);
        }
        //Add ')'
        if(close<open){
            backtrack(res,current+")",open,close+1,n);
        }
    }
}
