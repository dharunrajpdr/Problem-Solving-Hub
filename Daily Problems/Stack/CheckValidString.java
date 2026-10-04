
// Example 1:
// Input: s = "()"
// Output: true
  
// Example 2:
// Input: s = "(*)"
// Output: true
  
// Example 3:
// Input: s = "(*))"
// Output: true
  
// Example 4:
// Input: s = "("
// Output: false

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> lp = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                lp.push(i);
            }
            else if(c=='*'){
                stars.push(i);
            }
            else{
                if(!lp.isEmpty()){
                    lp.pop();
                }
                else if(!stars.isEmpty()){
                    stars.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!lp.isEmpty() && !stars.isEmpty()){
            if(lp.peek()<stars.peek()){
                lp.pop();
                stars.pop();
            }
            else{
                stars.pop();
            }
        }
        return lp.isEmpty();
    }
}
 
