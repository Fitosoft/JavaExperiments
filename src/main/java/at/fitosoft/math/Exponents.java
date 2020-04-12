package at.fitosoft.math;

public final class Exponents {
    private Exponents() {
        // hidden constructor
    }

    public static double significant(double x) {
        final double absX = Math.abs(x);
        return absX / Math.pow(10, Math.floor(Math.log10(absX)));
    }
}
