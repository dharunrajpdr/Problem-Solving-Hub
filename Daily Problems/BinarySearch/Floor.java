
// // floor - largest in an array <=x
// x=25
// arr ={10,20,30,40,50} floor=20


class Main {
    public static void main(String[] args) {
          int[] arr ={10,20,30,40,50};
          int x=25;
          System.out.println(floor(arr,x));
    }
    public static int floor(int[] arr,int target) {
        int ans=-1;  //if no condition satisfy
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=target){
                ans=arr[mid];
                //look for smaller index on the left 
                low=mid+1;
            }
            else{
               high=mid-1;
            }
        }
        return ans;
    }
}
