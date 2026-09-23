import java.util.*;
class Main {
    public static void main(String[] args) {
        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0,right=m-1;
        int top=0,bottom=n-1;
        List<Integer> list = new ArrayList<>();
        while(top<=bottom && left<=right){
        //for moving right
        for(int i=left;i<=right;i++){
            list.add(matrix[top][i]);
        }
        top++;
        //for moving bottom
        for(int i=top;i<=bottom;i++){
            list.add(matrix[i][right]);
        }
        right--;
        //for moving left
        for(int i=right;i>=left;i--){
            list.add(matrix[bottom][i]);
        }
        bottom--;
        //for moving top
        for(int i=bottom;i>=top;i--){
            list.add(matrix[i][left]);
        }
        left++;
        }
        System.out.println(list);
    }
}
