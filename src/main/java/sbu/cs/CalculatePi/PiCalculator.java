package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    private static BigDecimal pi = new BigDecimal("0");

    private static class BellardAlgorithm implements Runnable {

        private final int startPoint;
        private final MathContext mc = new MathContext(1001);

        public BellardAlgorithm(int startPoint) {
            this.startPoint = startPoint;
        }
        @Override
        public void run() {
            BigDecimal sum = new BigDecimal("0");
            for (int i = startPoint; i < startPoint + 50; i++) {
                BigDecimal a = new BigDecimal("-32").divide(BigDecimal.valueOf(4L * i + 1), mc);
                BigDecimal b = new BigDecimal("-1").divide(BigDecimal.valueOf(4L * i + 3), mc);
                BigDecimal c = new BigDecimal("256").divide(BigDecimal.valueOf(10L * i + 1), mc);
                BigDecimal d = new BigDecimal("-64").divide(BigDecimal.valueOf(10L * i + 3), mc);
                BigDecimal e = new BigDecimal("-4").divide(BigDecimal.valueOf(10L * i + 5), mc);
                BigDecimal f = new BigDecimal("-4").divide(BigDecimal.valueOf(10L * i + 7), mc);
                BigDecimal g = new BigDecimal("1").divide(BigDecimal.valueOf(10L * i + 9), mc);
                BigDecimal firstMul = new BigDecimal("-1").pow(i).divide(new BigDecimal("2").pow(10 * i + 6), mc);
                sum = sum.add(firstMul.multiply(a.add(b).add(c).add(d).add(e).add(f).add(g)));
            }
            sum(sum);
        }

        private static synchronized void sum(BigDecimal n) {
            pi = pi.add(n);
        }
    }

    public String calculate(int floatingPoint)
    {
        ExecutorService pool = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 20; i++) {
            BellardAlgorithm num = new BellardAlgorithm(50 * i);
            pool.execute(num);
        }
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.getMessage();
        }

        return pi.toString().substring(0, floatingPoint + 2);
    }

    public static void main(String[] args) {

    }
}
