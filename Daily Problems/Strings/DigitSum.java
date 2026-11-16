class Solution {
    public String digitSum(String s, int k) {
        //Repeat until the string length is <= k
        while(s.length() > k){
            StringBuilder sb = new StringBuilder();

            //Divide the string into group of size k
            for(int i=0;i<s.length();i+=k){
                int sum=0;
                for(int j=i;j<Math.min(i+k,s.length());j++){
                    sum+=s.charAt(j)-'0';
                }
                sb.append(sum);
            }
            s=sb.toString();
        }
        return s;
    }
}
