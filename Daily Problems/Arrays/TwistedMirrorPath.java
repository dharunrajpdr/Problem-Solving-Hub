class Solution {
    public int uniquePaths(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int MOD=1_000_000_007;
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        //Robot starts at (0,0)
        right[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r = right[i][j];
                int d = down[i][j];
                //Empty cell
                if(grid[i][j]==0){
                    long ways = ((long)r+d)%MOD;
                    //Move right
                    if(j+1<n){
                        right[i][j+1]=(int)((right[i][j+1]+ways)%MOD);
                    }
                    //Move down
                    if(i+1<m){
                        down[i+1][j]=(int)((down[i+1][j]+ways)%MOD);
                    }
                }
                //Mirror cell (i.e grid[i][j]==1)
                else{
                    //Entered mirror while moving right
                    //Reflection direction changes to down
                    //Move down
                    if(i+1<m){
                        down[i+1][j]=(int)((down[i+1][j]+(long)r)%MOD);
                    }
                    //Entered mirror while moving down
                    //Reflection direction changes to right
                    //Move right
                    if(j+1<n){
                        right[i][j+1]=(int)((right[i][j+1]+(long)d)%MOD);
                    }
                }

            }
        }
        return (int)(((long)right[m-1][n-1]+down[m-1][n-1])%MOD);
    }
}
