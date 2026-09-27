
// LowerBound-Smallest index which is greater than or equal to x.arr[ind>=x

import java.util.*;
class Main {
    public static void main(String[] args) {
          int[] arr ={1,2,3,3,5,8,9,10,10,11};
          int x=9;
          System.out.println(lowerBound(arr,x));
    }
    public static int lowerBound(int[] arr,int target) {
        int ans=arr.length+1;  //if no condition satisfy
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
