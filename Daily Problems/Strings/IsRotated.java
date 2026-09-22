class Solution {
    public static boolean isRotated(String s1, String s2) {
        // code here
        if(s1.length()<2) return false;
        
        char[] arr=s1.toCharArray();
        int k=2;
        int n=arr.length;
        //left rotate and check 
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
        String s3=new String(arr);
        
        //again back to initial one
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        
        //right rotate and check 
        
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        String s4 = new String(arr);
        return s3.equals(s2)  || s4.equals(s2);
    }
    public static void reverse(char[] arr,int left,int right){
        while(left<right){
            char ch = arr[left];
            arr[left]=arr[right];
            arr[right]=ch;
            left++;
            right--;
        }
    }
}
