
// Example 1:
// Input: n = 153
// Output: true
// Explanation: Number of digits : 3.
// 13 + 53 + 33 = 1 + 125 + 27 = 153.
// Therefore, it is an Armstrong number.

// Example 2:
// Input: n = 12
// Output: false
// Explanation: Number of digits : 2.
// 12 + 22 = 1 + 4 = 5.
// Therefore, it is not an Armstrong number.

class Main {
    public static void main(String[] args) {
        int n=153;
        System.out.println(isArmstrong(n));
    }
   public static boolean isArmstrong(int n) {
       int length=String.valueOf(n).length();
       int n1=n;
       int sum=0;
       while(n>0){
        int mod=n%10;
        sum+=(int)Math.pow(mod,length);
        n/=10;
       }
       return n1==sum;
    }
}
