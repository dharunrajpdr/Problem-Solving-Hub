//using recursion function 


class Solution {
    public static void main(String[] args) {
        int n=3;
        int ans = sumOfN(n);     //initially i is 0
        System.out.println(ans);
    }
    public static int sumOfN(int n){
        if(n==0){
            return 0;
        }
        return n+sumOfN(n-1);
    }
}
