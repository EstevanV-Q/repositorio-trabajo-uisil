package com.mycompany.tarea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 1: Lectura de Archivos
 * 
 * Esta clase demuestra diferentes formas de leer archivos en Java:
 * - Lectura línea por línea usando BufferedReader
 * - Manejo de excepciones
 * - Cierre adecuado de recursos
 */
public class Ejercicio1LecturaArchivos {
    
    /**
     * Lee un archivo de texto línea por línea y muestra su contenido
     * 
     * @param rutaArchivo La ruta del archivo a leer
     */
    public static void leerArchivo(String rutaArchivo) {
        BufferedReader lector = null;
        
        try {
            lector = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            int numeroLinea = 1;
            
            System.out.println("=== Contenido del archivo: " + rutaArchivo + " ===");
            
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea " + numeroLinea + ": " + linea);
                numeroLinea++;
            }
            
            System.out.println("\nArchivo leído exitosamente. Total de líneas: " + (numeroLinea - 1));
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el recurso en el bloque finally
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Lee un archivo usando try-with-resources (Java 7+)
     * Esta es la forma recomendada de manejar recursos
     * 
     * @param rutaArchivo La ruta del archivo a leer
     */
    public static void leerArchivoConTryWithResources(String rutaArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            System.out.println("\n=== Lectura con try-with-resources ===");
            
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        // El recurso se cierra automáticamente aquí
    }
    
    /**
     * Método principal para probar la lectura de archivos
     */
    public static void main(String[] args) {
        String archivoPrueba = "archivo_prueba.txt";
        
        // Crear un archivo de prueba primero
        System.out.println("Ejercicio 1: Lectura de Archivos\n");
        System.out.println("Nota: Asegúrate de tener un archivo llamado 'archivo_prueba.txt' en el directorio del proyecto.");
        
        // Intentar leer el archivo
        leerArchivo(archivoPrueba);
        leerArchivoConTryWithResources(archivoPrueba);
    }
}

