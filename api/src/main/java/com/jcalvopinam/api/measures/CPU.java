package com.jcalvopinam.api.measures;

import java.lang.management.ManagementFactory;
import java.util.Random;

import com.jcalvopinam.api.model.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class CPU {

    public static void log(Object message) {
        System.out.println(message);
    }

    public static float calcCPU(long cpuStartTime, long elapsedStartTime, int cpuCount) {
        long end = System.nanoTime();
        long totalAvailCPUTime = cpuCount * (end - elapsedStartTime);
        long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() - cpuStartTime;
        float per = ((float) totalUsedCPUTime) / (float) totalAvailCPUTime;
        return per;
    }

    static boolean isPrime(int n) {
        // 2 is the smallest prime
        if (n <= 2) {
            return n == 2;
        }
        // even numbers other than 2 are not prime
        if (n % 2 == 0) {
            return false;
        }
        // check odd divisors from 3 to the square root of n
        for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Valor getCPUMeasure() {

        String errorMessage = "";
        float counter = 0, average = 0;
        int max = 30;
        for (int i = 1; i <= max; i++) {
            long start = System.nanoTime();
            // number of available processors;
            int cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
            Random random = new Random(start);
            int seed = Math.abs(random.nextInt());

//            log("\n \n CPU USAGE DETAILS \n\n");
//            log("Starting Test with " + cpuCount + " CPUs and random number:" + seed);

            int primes = 10000;
            long startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();

            start = System.nanoTime();

            while (primes != 0) {
                if (isPrime(seed)) {
                    primes--;
                }
                seed++;
            }

            float cpuPercent = calcCPU(startCPUTime, start, cpuCount);
            counter += cpuPercent;

            if (i == max) {
                average = counter / max;
            }
//            log("CPU USAGE : " + cpuPercent + " % ");

        }
        log("<CPU> Velocidad en nano: " + average);
        String result = String.valueOf(average);
        if (result.length() > 5)
            result = result.substring(0, 5);
        return new Valor(result, errorMessage);
    }

}