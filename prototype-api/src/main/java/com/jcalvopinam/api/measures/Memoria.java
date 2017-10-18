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

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcalvopinam.api.utils.Commons;
import com.jcalvopinam.api.utils.Valor;

import sun.misc.Unsafe;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@SuppressWarnings("restriction")
public class Memoria {

    private static final Logger logMemoria = LoggerFactory.getLogger(Memoria.class);

    Commons common = new Commons();
    String result = "";
    String errorMessage = "";
    long elapsedTime = 0;

    public Valor getTiempoEscrituraMemoria() {

        result = "";
        errorMessage = "";

        try {
            long startTime = System.nanoTime();

            Unsafe unsafe = getUnsafe();

            long value = Long.MAX_VALUE;
            long bytes = Long.SIZE;
            long memoryAddress = unsafe.allocateMemory(bytes);

            unsafe.putLong(memoryAddress, value);

            elapsedTime = System.nanoTime() - startTime;

            logMemoria.info("<Memoria> Tiempo de escritura en nano: " + elapsedTime);

        } catch (Exception e) {
            logMemoria.error("Ha ocurrido un error inesperado: " + e.getMessage());
            errorMessage = e.getMessage();
        }

        result = common.formatearResultado(elapsedTime);

        return new Valor(result, errorMessage);
    }

    public Valor getTiempoLecturaMemoria() {
        result = "";
        errorMessage = "";
        elapsedTime = 0;

        try {
            long startTime = System.nanoTime();
            Unsafe unsafe = getUnsafe();

            long bytes = Long.SIZE;
            long memoryAddress = unsafe.allocateMemory(bytes);

            long readValue = unsafe.getLong(memoryAddress);

            logMemoria.info("[Long] Reading " + readValue + " from the " + memoryAddress + " address.");

            unsafe.freeMemory(memoryAddress);

            elapsedTime = System.nanoTime() - startTime;
            logMemoria.info("<Memoria> Tiempo de lectura en nano: " + elapsedTime);
            result = String.valueOf(elapsedTime);

        } catch (Exception e) {
            logMemoria.error("Ha ocurrido un error inesperado: " + e.getMessage());
            errorMessage = e.getMessage();
        }

        result = common.formatearResultado(elapsedTime);

        return new Valor(result, errorMessage);
    }

    private Unsafe getUnsafe() throws Exception {
        Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (sun.misc.Unsafe) field.get(null);
    }

}
