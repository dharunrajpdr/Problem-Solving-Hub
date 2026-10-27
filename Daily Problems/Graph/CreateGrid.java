class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for(int i=0;i<m;i++){
            //char[] rows = new char[n];
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(i==0 || j==n-1){
                    //rows[j]='.';
                    sb.append('.');
                }
                else{
                   // rows[j]='#';
                    sb.append('#');
                }
            }
            //grid[i]=new String(rows);
            grid[i]=sb.toString();
        }
        return grid;
    }
}
