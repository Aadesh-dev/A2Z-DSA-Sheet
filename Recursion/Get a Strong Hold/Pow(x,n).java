class Solution {
    public double myPow(double x, int n) {
        double res = 1.00000;
        for(int i = 1; i <= Math.abs((long) n); i++) {
            res *= x;
        }
        return n >= 0 ? res : 1.00000/res;
    }
}
//Time: O(n), Space: O(1)

class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? recMyPow(x, n) : 1 / recMyPow(x, n);
    }

    static double recMyPow(double x, int n) {
        if(n == 0) return 1;
        long power = Math.abs((long) n);
        if(power % 2 == 0) {
            return recMyPow(x * x, (int) (power / 2));
        } else {
            return x * recMyPow(x, (int) (power - 1));
        }
    }
}
//Time: O(log(n)), Space: O(log(n))

//https://www.youtube.com/watch?v=l0YC3876qxg&ab_channel=takeUforward