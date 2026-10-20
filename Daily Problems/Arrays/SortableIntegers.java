class Solution {
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int k=1;k<=n;k++){
            if(n%k!=0){
                continue;
            }
            boolean valid=true;
            int preMax=Integer.MIN_VALUE;
            for(int start=0;start<n;start+=k){
                int end=start+k;
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                int descend=0;
                for(int i=start;i<end;i++){
                    min=Math.min(min,nums[i]);
                    max=Math.max(max,nums[i]);

                    int next=(i+1==end)?start:i+1;
                    if(nums[i]>nums[next]){
                        descend++;
                    }
                }
                if(descend>1){
                    valid=false;
                    break;
                }
                if(preMax>min){
                    valid=false;
                    break;
                }
                preMax=max;
            }
            if(valid){
                ans+=k;
            }
        }
        return ans;
    }
}
