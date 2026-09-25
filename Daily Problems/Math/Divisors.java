
// Example 1:
// Input: n = 6
// Output = [1, 2, 3, 6]
// Explanation: The divisors of 6 are 1, 2, 3, 6.

// Example 2:
// Input: n = 8
// Output: [1, 2, 4, 8]
// Explanation: The divisors of 8 are 1, 2, 4, 8.

import java.util.*;
class Main {
    public static void main(String[] args) {
      int n=8;
      int[] ans = divisors(n);
      System.out.println(Arrays.toString(ans));
    }
    public static int[] divisors(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0){
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        int i=0;
        for(int num:list){
            res[i++]=num;
        }
        return res;
    }
}
