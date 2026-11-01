class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<min){
                min=num;
            }
        }
        int moves=0;
        for(int num:nums){
            moves+=(num-min);
        }
        return moves;
    }
}
