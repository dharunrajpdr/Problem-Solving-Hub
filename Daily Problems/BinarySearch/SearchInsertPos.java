class Main {
    public static void main(String[] args) {
          int[] arr ={2,3,6,7,8,8,11,11,11,12};
          int x=1;
          System.out.println(lowerBound(arr,x));
    }
    public static int lowerBound(int[] arr,int target) {
        int ans=0;  //if no condition satisfy
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>=target){
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
