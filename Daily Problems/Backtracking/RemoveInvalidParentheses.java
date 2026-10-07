// Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
// Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

// Example 1:
// Input: s = "()())()"
// Output: ["(())()","()()()"]
  
// Example 2:
// Input: s = "(a)())()"
// Output: ["(a())()","(a)()()"]
  
// Example 3:
// Input: s = ")("
// Output: [""]

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int left=0;
        int right=0;
        //Find minimum number of '(' and ')'
        for(char c:s.toCharArray()){
            if(c=='('){
                left++;
            }
            else if(c==')'){
                if(left>0) left--;
                else right++;
            }
        }
       backtrack(s,0,left,right,res);
       return res;
    }
    private void backtrack(String s,int index,int leftRemove,int rightRemove,List<String> res){
        //No parenteses need to be removed
        if(leftRemove==0 && rightRemove==0){
            if(isValid(s)){
                res.add(s);
            }
            return;
        }
        //else 
        for(int i=index;i<s.length();i++){
            //To avoid generating duplicate
            if(i>index && s.charAt(i)==s.charAt(i-1)){
                continue;
            }
            char c=s.charAt(i);
            //Remove an extra '('
            if(c=='(' && leftRemove>0){
                String next=s.substring(0,i)+s.substring(i+1,s.length());
                backtrack(next,i,leftRemove-1,rightRemove,res);
            }
            //Remove an extra ')'
            if(c==')' && rightRemove>0){
                String next=s.substring(0,i)+s.substring(i+1,s.length());
                backtrack(next,i,leftRemove,rightRemove-1,res);
            }
        }
    }
    private boolean isValid(String s){
        int balance=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                balance++;
            }
            else if(c==')'){
                balance--;
                if(balance<0){
                    return false;
                }
            }
        }
        return true;
    }
}
