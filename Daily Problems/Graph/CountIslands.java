class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long sum=dfs(grid,i,j);
                    if(sum%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private long dfs(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
            return 0;
        }
        int value=grid[i][j];
        grid[i][j]=0;
        long sum=value;
        sum+=dfs(grid,i-1,j);    //up
        sum+=dfs(grid,i+1,j);    //down
        sum+=dfs(grid,i,j-1);    //left
        sum+=dfs(grid,i,j+1);    //right
        
        return sum;
    }
}
