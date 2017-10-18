/*
 * MIT License
 *
 * Copyright (c) 2017 JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

    /**
     * El código de ejemplo calcula un bloque de 10000 números primos para determinar la utilización de la CPU. La
     * prueba se repite 5 veces para obtener un promedio de CPU
     */
    public Valor getCPUMeasure() {

        String result = "";
        String errorMessage = "";

        int numMuestras = 5;
        float muestra = 0;
        float promedio = 0;

        for (int i = 1; i <= numMuestras; i++) {
            long tiempoInicial = System.nanoTime();
            int numCPUs = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
            Random numAleatorio = new Random(tiempoInicial);
            int semilla = Math.abs(numAleatorio.nextInt());

            logCPU.info("Petición [" + i + "]: Cantidad de CPUs:" + numCPUs + " semilla aleatoria:" + semilla);

            int numPrimos = 10000;
            long inicioCPU = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
            tiempoInicial = System.nanoTime();

            while (numPrimos != 0) {
                if (esPrimo(semilla)) {
                    numPrimos--;
                }
                semilla++;
            }

            float calcularCPU = calcCPU(inicioCPU, tiempoInicial, numCPUs);
            muestra += calcularCPU;

            if (i == numMuestras) {
                promedio = muestra / numMuestras;
            }

        }

        result = String.valueOf(promedio);

        if (result.length() > 5)
            result = result.substring(0, 5);

        logCPU.info("Uso de CPU:" + result);

        return new Valor(result, errorMessage);
    }

    private float calcCPU(long inicioCPU, long tiempoInicial, int numCPUs) {
        long tiempoFinal = System.nanoTime();
        long totalTipoCPU = numCPUs * (tiempoFinal - tiempoInicial);
        long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() - inicioCPU;
        return ((float) totalUsedCPUTime * 100) / (float) totalTipoCPU;
    }

    private boolean esPrimo(int n) {
        if (n <= 2)
            return n == 2;

        if (n % 2 == 0)
            return false;

        for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
            if (n % i == 0)
                return false;

        }
        return true;
    }
}