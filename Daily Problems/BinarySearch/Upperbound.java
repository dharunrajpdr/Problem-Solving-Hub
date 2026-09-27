
// Upperbound-smallest index greater than x.arr[ind>x

class Main {
    public static void main(String[] args) {
          int[] arr ={2,3,6,7,8,8,11,11,11,12};
          int x=7;
          System.out.println(upperBound(arr,x));
    }
    public static int upperBound(int[] arr,int target) {
        int ans=arr.length+1;  //if no condition satisfy
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>target){
                ans=mid;
                //look for smaller index on the left 
                right=mid-1;
            }
            else{
               left=mid+1;
            }
        }
        return ans;
    }
}
