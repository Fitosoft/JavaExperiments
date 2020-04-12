package at.fitosoft.math;

public class SeriesNine {
    private static int qSum(int number) {
        int sum = 0;
        int lastValue = Math.abs(number);

        while (lastValue > 0) {
            int remainder = lastValue % 10;
            sum += remainder;
            lastValue = lastValue / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int sed = 1; sed <= 1000; sed ++) {
            int value = sed * 9;
            System.out.println(sed + "\t" + value + "\t" + qSum(value));
        }
    }
}
