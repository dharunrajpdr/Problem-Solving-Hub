
// Example 1:
// Input: n = 6
// Output: 3
// Explanation: Prime numbers in the range [1, 6] are 2, 3, 5.

// Example 2:
// Input: n = 10
// Output: 4
// Explanation: Prime numbers in the range [1, 10] are 2, 3, 5, 7.

class Main {
    public static void main(String[] args) {
        int n=10;
        System.out.println(primeUptoN(n));
    }
   public static int primeUptoN(int n){
       int count=0;
       for(int i=1;i<=n;i++){
           if(isPrime(i)){
               count++;
           }
       }
       return count;
   }
    public static boolean isPrime(int n) {
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
       return true;
    }
}
