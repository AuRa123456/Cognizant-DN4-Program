public class Main {
    public static double futureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        } else {
            return futureValue(principal, rate, years - 1) * (1 + rate);
        }
    }

    public static void main(String[] args) {
        double principal = 10000;
        double rate = 0.08; // 8%
        int years = 9;

        double result = futureValue(principal, rate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, result);
    }
}