/**
 * Created by terry on 1/6/15.
 */
public class Pow {
    public double pow(double x, int n) {
        if (n < 0) {
            return 1.0 / power(x, Math.abs(n));
        } else {
            return power(x, n);
        }
    }

    private double power(double x, int n) {
        if (n == 0) { // base case
            return 1;
        }

        double v = power(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Pow().pow(2, 2));
        System.out.println(new Pow().pow(2, -2));
    }
}
