
//n=3   1+2+3=6

class Solution {
    public static void main(String[] args) {
        int n=3;
        int ans = sumOfN(n,0);     //initially i is 0
        System.out.println(ans);
    }
    public static int sumOfN(int i,int sum){
        if(i<1){
            return sum;
        }
        return sumOfN(i-1,sum+i);
    }
}
