package com.mycompany.tarea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ejercicio 2: Escritura de Archivos
 * 
 * Esta clase demuestra diferentes formas de escribir archivos en Java:
 * - Escritura usando FileWriter y BufferedWriter
 * - Escritura usando PrintWriter
 * - Modo append (agregar al final del archivo)
 * - Manejo de excepciones
 */
public class Ejercicio2EscrituraArchivos {
    
    /**
     * Escribe texto en un archivo (sobrescribe si existe)
     * 
     * @param rutaArchivo La ruta del archivo a escribir
     * @param contenido El contenido a escribir
     */
    public static void escribirArchivo(String rutaArchivo, String contenido) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo))) {
            escritor.write(contenido);
            escritor.newLine(); // Agregar salto de línea
            System.out.println("Archivo escrito exitosamente: " + rutaArchivo);
            
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Agrega texto al final de un archivo existente (modo append)
     * 
     * @param rutaArchivo La ruta del archivo
     * @param contenido El contenido a agregar
     */
    public static void agregarAlArchivo(String rutaArchivo, String contenido) {
        try (BufferedWriter escritor = new BufferedWriter(
                new FileWriter(rutaArchivo, true))) { // true = modo append
            
            escritor.write(contenido);
            escritor.newLine();
            System.out.println("Contenido agregado al archivo: " + rutaArchivo);
            
        } catch (IOException e) {
            System.err.println("Error al agregar contenido al archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Escribe múltiples líneas usando PrintWriter
     * 
     * @param rutaArchivo La ruta del archivo
     * @param lineas Array de líneas a escribir
     */
    public static void escribirMultiplesLineas(String rutaArchivo, String[] lineas) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
            System.out.println("Múltiples líneas escritas en: " + rutaArchivo);
            
        } catch (IOException e) {
            System.err.println("Error al escribir múltiples líneas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Método principal para probar la escritura de archivos
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 2: Escritura de Archivos\n");
        
        String archivo1 = "archivo_escritura.txt";
        String archivo2 = "archivo_multiple.txt";
        
        // Escribir un archivo simple
        escribirArchivo(archivo1, "Esta es la primera línea del archivo.");
        escribirArchivo(archivo1, "Esta línea sobrescribe la anterior.");
        
        // Agregar contenido al archivo
        agregarAlArchivo(archivo1, "Esta línea se agregó al final.");
        agregarAlArchivo(archivo1, "Otra línea más agregada.");
        
        // Escribir múltiples líneas
        String[] lineas = {
            "Línea 1",
            "Línea 2",
            "Línea 3",
            "Línea 4"
        };
        escribirMultiplesLineas(archivo2, lineas);
        
        System.out.println("\nEjercicio completado. Revisa los archivos generados.");
    }
}

