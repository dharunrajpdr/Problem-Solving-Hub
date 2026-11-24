class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            long prod = 1;
            long gcd = 0;
            long lcm = 1;
            for(int j=i;j<n;j++){
                prod *= nums[j];
                gcd = gcd(gcd,nums[j]);
                lcm = lcm / gcd(lcm,nums[j]) * nums[j];
                if(prod == gcd * lcm){
                    ans = Math.max(ans,j-i+1);
                }
                if(prod > 1_000_000_000_001L) break;
            }
        }
        return ans;
    }
    private static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}
