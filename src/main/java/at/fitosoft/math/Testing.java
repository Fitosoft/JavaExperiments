package at.fitosoft.math;

public class Testing {
    private static double calc(double x) {
        double base = Math.pow(10, Math.round(Math.log10(x)));
        System.out.println(base);
        return x / base;
    }

    public static void main(String[] args) {
        System.out.println(calc(1));
        System.out.println(calc(2));
        System.out.println(calc(3));
        System.out.println(calc(9));
        System.out.println(calc(0.001234));
        System.out.println(calc(1000));
        System.out.println(calc(12345));
    }
}
