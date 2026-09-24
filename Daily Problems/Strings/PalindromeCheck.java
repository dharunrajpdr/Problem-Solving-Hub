
// Input : s = "hannah"
// Output : true

// Input : s = "aabbaaa"
// Output : false

class Solution {   
    public boolean palindromeCheck(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
