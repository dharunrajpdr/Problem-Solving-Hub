class Solution {
    private final int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int count=0,previousSum=0,evenCount=1,oddCount=0;
        for(int num:arr){
            previousSum+=num;
            if(previousSum%2==0){
                count+=oddCount;
                evenCount++;
            }
            else{
                count+=evenCount;
                oddCount++;
            }
            count%=MOD;
        }
        return count;

    }
}
