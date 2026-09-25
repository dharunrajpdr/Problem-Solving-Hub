
// Example 1:
// Input: n = 6
// Output: true
// Explanation: Proper divisors of 6 are 1, 2, 3.
// 1 + 2 + 3 = 6.

// Example 2:
// Input: n = 4
// Output: false
// Explanation: Proper divisors of 4 are 1, 2.
// 1 + 2 = 3.

class Main {
    public static void main(String[] args) {
        int n=6;
        System.out.println(isPerfect(n));
    }
   public static boolean isPerfect(int n) {
        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
       return n==sum;
    }
}
