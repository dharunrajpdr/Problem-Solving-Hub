// Input: s = "xxyyxy" 
// Output: true
// Explanation: The string can be split into "xxyy" + "xy". Both substrings contain an equal number of consecutive 'x' and 'y' characters.
// Input: s = "xyx"
// Output: false
// Explanation: The last 'x' cannot form a valid substring because it is not followed by a matching 'y'. 

class Solution {
    public boolean findPattern(String s) {
        // code here
        int count=0;
        for(char c:s.toCharArray()){
            if(c=='x'){
                count++;
            }
            else if(c=='y'){
                count--;
                if(count<0){
                    return false;
                }
            }
        }
        return count==0;
    }
}
