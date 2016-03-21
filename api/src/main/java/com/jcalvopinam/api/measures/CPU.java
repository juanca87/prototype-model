package com.jcalvopinam.api.measures;

import java.lang.management.ManagementFactory;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcalvopinam.api.utils.Valor;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

public class CPU {

    private static final Logger logCPU = LoggerFactory.getLogger(CPU.class);

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

        }

        logCPU.info("<CPU> Velocidad en nano: " + average);
        String result = String.valueOf(average);

        if (result.length() > 5)
            result = result.substring(0, 5);

        return new Valor(result, errorMessage);
    }

    private static float calcCPU(long cpuStartTime, long elapsedStartTime, int cpuCount) {
        long end = System.nanoTime();
        long totalAvailCPUTime = cpuCount * (end - elapsedStartTime);
        long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() - cpuStartTime;
        float per = ((float) totalUsedCPUTime) / (float) totalAvailCPUTime;
        return per;
    }

    private static boolean isPrime(int n) {
        if (n <= 2) {
            return n == 2;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}