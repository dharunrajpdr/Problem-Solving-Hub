class Solution {
    public int findMax(int n) {
        int maxSum = digitSum(n);
        int ans = n;
        int power = 1;
        while (n / power > 0) {
            int candidate = (n / power - 1) * power + (power - 1);
            if (candidate >= 1) {
                int sum = digitSum(candidate);

                if (sum > maxSum || (sum == maxSum && candidate > ans)) {
                    maxSum = sum;
                    ans = candidate;
                }
            }
            power *= 10;
        }
        return ans;
    }

    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
