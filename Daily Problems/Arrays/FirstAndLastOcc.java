
// Example 1:
// Input: nums = [5, 7, 7, 8, 8, 10], target = 8
// Output: [3, 4]
// Explanation:The target is 8, and it appears in the array at indices 3 and 4, so the output is [3,4]

// Example 2:
// Input: nums = [5, 7, 7, 8, 8, 10], target = 6
// Output: [-1, -1]
// Expalantion: The target is 6, which is not present in the array. Therefore, the output is [-1, -1].

import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] arr ={2,4,6,8,8,8,11,13};
        int x=8;
        int[] ans=firstAndLast(arr,x);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] firstAndLast(int[] arr,int x){
        int[] res = new int[2];
        int first=-1,last=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                if(first==-1){
                    first=i;
                }
                last=i;
            }
        }
        res[0]=first;
        res[1]=last;
        return res;
            
    }
}
