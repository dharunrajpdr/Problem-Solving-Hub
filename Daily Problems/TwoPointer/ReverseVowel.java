
// Input: s = "geeksforgeeks"
// Output: "geeksforgeeks"
// Explanation: The vowels are: e, e, o, e, e. Reverse of these is also e, e, o, e, e.
  
// Input: s = "practice"
// Output: "prectica"
// Explanation: The vowels are a, i, e. Reverse of these is e, i, a.

class Solution {
    public String reverseVowel(String s) {
        char[] arr =s.toCharArray();
        int left=0;
        int right=s.length()-1;
        String st="aeiou";
        while(left<right){
            if(st.indexOf(arr[left])==-1){
                left++;
            }
            else if(st.indexOf(arr[right])==-1){
                right--;
            }
            else{
                char c=arr[left];
                arr[left]=arr[right];
                arr[right]=c;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
