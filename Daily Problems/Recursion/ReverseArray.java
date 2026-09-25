//i/p :[1,2,3,4,5]
//o/p :[5,4,3,2,1]

import java.util.*;
class Main {
    public static void main(String[] args) {
       int[] arr ={1,2,3,4,5};
       int n=arr.length;
       reverseArray(arr,0,n);
       System.out.println(Arrays.toString(arr));
     }
    public static void reverseArray(int[] arr,int i,int n){
        if(i>=n/2){
            return;
        }
        swap(arr,i,n-i-1);
        reverseArray(arr,i+1,n);
    }
    public static void swap(int[] arr,int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
