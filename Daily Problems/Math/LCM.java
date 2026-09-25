
// Example 1:
// Input: n1 = 4, n2 = 6
// Output: 12
// Explanation: 4 * 3 = 12, 6 * 2 = 12.
// 12 is the lowest integer that is divisible both 4 and 6.

// Example 2:
// Input: n1 = 3, n2 = 5
// Output: 15
// Explanation: 3 * 5 = 15, 5 * 3 = 15.
// 15 is the lowest integer that is divisible both 3 and 5.

class Main {
    public static void main(String[] args) {
       int n1=4;
       int n2=6;
        int lcm=(n1*n2)/gcd(n1,n2);
       System.out.println(lcm);
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
