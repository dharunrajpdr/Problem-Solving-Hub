
// Input: s = "anagram", t = "nagaram"
// Output: true
  
// Input: s = "rat", t = "car"
// Output: false

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int freq[]=new int[26];
        s=s.toLowerCase();
        t=t.toLowerCase();
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}
