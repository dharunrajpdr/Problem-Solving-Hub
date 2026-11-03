class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int moves=0;
        for(int num:nums){
            moves+=Math.abs(num-max);
        }
        return moves;
    }
}
