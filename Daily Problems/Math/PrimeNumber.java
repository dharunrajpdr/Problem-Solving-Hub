
// Example 1:
// Input: n = 5
// Output: true
// Explanation: The only divisors of 5 are 1 and 5 , So the number 5 is prime.

// Example 2:
// Input: n = 8
// Output: false
// Explanation: The divisors of 8 are 1, 2, 4, 8, thus it is not a prime number.

class Main {
    public static void main(String[] args) {
        int n=5;
        System.out.println(isPrime(n));
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
