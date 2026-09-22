class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int min=matrix[i][0];
             int minColInd=0;
            for(int j=1;j<matrix[0].length;j++){
                  if(matrix[i][j]<min){
                    min=matrix[i][j];
                    minColInd=j;
                  }
            }
            boolean isLucky=true;
            for(int k=0;k<matrix.length;k++){
                if(matrix[k][minColInd]>min){
                    isLucky=false;
                    break;
                }
            }
            if(isLucky){
                res.add(min);
            }
        }
        return res;
    }
}
