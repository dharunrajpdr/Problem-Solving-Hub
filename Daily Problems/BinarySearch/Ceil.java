
// ceil - smallest in an array >=x
// x=25
// arr ={10,20,30,40,50} ceil=30

class Main {
    public static void main(String[] args) {
          int[] arr ={10,20,30,40,50};
          int x=25;
          System.out.println(ceil(arr,x));
    }
    public static int ceil(int[] arr,int target) {
        int ans=-1;  //if no condition satisfy
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans=arr[mid];
                //look for smaller index on the left 
                high=mid-1;
            }
            else{
               low=mid+1;
            }
        }
        return ans;
    }
}
