class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(sum>=9){
            sb.append('9');
            sum-=9;
            num--;
        }
        if(num>0 && sum>0){
            sb.append((char)('0'+sum));
            num--;
        }
        while(num>0){
            sb.append('0');
            num--;
        }
        return sb.toString();
    }
}
