package com.jcalvopinam.api.measures;

import java.lang.reflect.Field;

import com.jcalvopinam.api.model.Valor;

import sun.misc.Unsafe;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 *
 */

@SuppressWarnings("restriction")
public class Memoria {

    public Valor getTiempoEscrituraMemoria() {
        String result = "";
        String errorMessage = "";

        try {
            long startTime = System.nanoTime();

            Unsafe unsafe = getUnsafe();

            // Writing to a memory - MAX VALUE of Long
            long value = Long.MAX_VALUE;
            long bytes = Long.SIZE;
            // Allocate given memory size
            long memoryAddress = unsafe.allocateMemory(bytes);
            // Write value to the allocated memory
            unsafe.putLong(memoryAddress, value);

            // Output the value written and the memory address
//            System.out.println("[Long] Writing " + value + " under the " + memoryAddress + " address.");
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("<Memoria> Tiempo de escritura en nano: " + elapsedTime);

            result = String.valueOf(elapsedTime);

        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        if (result.length() > 5)
            result = result.substring(0, 5);
        return new Valor(result, errorMessage);
    }

    public Valor getTiempoLecturaMemoria() {
        String result = "";
        String errorMessage = "";

        try {
            long startTime = System.nanoTime();
            Unsafe unsafe = getUnsafe();

            long bytes = Long.SIZE;
            // Allocate given memory size
            long memoryAddress = unsafe.allocateMemory(bytes);

            // Read the value from the memory
            long readValue = unsafe.getLong(memoryAddress);

            // Output the value from
            System.out.println("[Long] Reading " + readValue + " from the " + memoryAddress + " address.");

            // C style! Release the Kraken... Memory!! :)
            unsafe.freeMemory(memoryAddress);

            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("<Memoria> Tiempo de lectura en nano: " + elapsedTime);
            result = String.valueOf(elapsedTime);

        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        if (result.length() > 5)
            result = result.substring(0, 5);
        return new Valor(result, errorMessage);
    }

    private Unsafe getUnsafe() throws Exception {
        // Get the Unsafe object instance
        Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (sun.misc.Unsafe) field.get(null);
    }

}
