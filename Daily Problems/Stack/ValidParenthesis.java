
// Input:
// "{[()]}"
// Output:
// true

// Input:
// "{[(])}"
// Output:
// false

import java.util.*;
class Main {
    public static void main(String[] args) {
        String s="{[()]}";
        System.out.println(validParenthesis(s));
    }
    public static boolean validParenthesis(String s){
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(')');
            }
            else if(c=='['){
                st.push(']');
            }
            else if(c=='{'){
                st.push('}');
            }
            else{
                if(st.isEmpty() || c!=st.pop()){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
