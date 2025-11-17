package com.mycompany.tarea;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Ejercicio 3: Copia de Archivos
 * 
 * Esta clase demuestra diferentes formas de copiar archivos en Java:
 * - Copia usando FileInputStream y FileOutputStream
 * - Copia usando la clase Files de NIO (Java 7+)
 * - Manejo de excepciones y verificación de archivos
 */
public class Ejercicio3CopiaArchivos {
    
    /**
     * Copia un archivo usando FileInputStream y FileOutputStream
     * Método tradicional de Java
     * 
     * @param archivoOrigen Ruta del archivo origen
     * @param archivoDestino Ruta del archivo destino
     * @return true si la copia fue exitosa, false en caso contrario
     */
    public static boolean copiarArchivoTradicional(String archivoOrigen, String archivoDestino) {
        try (FileInputStream entrada = new FileInputStream(archivoOrigen);
             FileOutputStream salida = new FileOutputStream(archivoDestino)) {
            
            byte[] buffer = new byte[1024]; // Buffer de 1KB
            int bytesLeidos;
            
            while ((bytesLeidos = entrada.read(buffer)) != -1) {
                salida.write(buffer, 0, bytesLeidos);
            }
            
            System.out.println("Archivo copiado exitosamente (método tradicional):");
            System.out.println("  Origen: " + archivoOrigen);
            System.out.println("  Destino: " + archivoDestino);
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Copia un archivo usando la clase Files de NIO (método moderno)
     * Esta es la forma recomendada en Java 7+
     * 
     * @param archivoOrigen Ruta del archivo origen
     * @param archivoDestino Ruta del archivo destino
     * @return true si la copia fue exitosa, false en caso contrario
     */
    public static boolean copiarArchivoNIO(String archivoOrigen, String archivoDestino) {
        try {
            Path origen = Paths.get(archivoOrigen);
            Path destino = Paths.get(archivoDestino);
            
            // Copiar el archivo, reemplazando si existe
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println("Archivo copiado exitosamente (método NIO):");
            System.out.println("  Origen: " + archivoOrigen);
            System.out.println("  Destino: " + archivoDestino);
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Verifica si un archivo existe
     * 
     * @param rutaArchivo Ruta del archivo a verificar
     * @return true si el archivo existe, false en caso contrario
     */
    public static boolean archivoExiste(String rutaArchivo) {
        Path archivo = Paths.get(rutaArchivo);
        return Files.exists(archivo);
    }
    
    /**
     * Obtiene el tamaño de un archivo en bytes
     * 
     * @param rutaArchivo Ruta del archivo
     * @return Tamaño del archivo en bytes, o -1 si hay error
     */
    public static long obtenerTamanioArchivo(String rutaArchivo) {
        try {
            Path archivo = Paths.get(rutaArchivo);
            return Files.size(archivo);
        } catch (IOException e) {
            System.err.println("Error al obtener el tamaño del archivo: " + e.getMessage());
            return -1;
        }
    }
    
    /**
     * Método principal para probar la copia de archivos
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 3: Copia de Archivos\n");
        
        String archivoOrigen = "archivo_escritura.txt";
        String archivoDestino1 = "archivo_copia_tradicional.txt";
        String archivoDestino2 = "archivo_copia_nio.txt";
        
        // Verificar que el archivo origen existe
        if (!archivoExiste(archivoOrigen)) {
            System.out.println("ADVERTENCIA: El archivo origen no existe: " + archivoOrigen);
            System.out.println("Ejecuta primero el Ejercicio 2 para crear archivos de prueba.");
            return;
        }
        
        // Mostrar información del archivo origen
        long tamanio = obtenerTamanioArchivo(archivoOrigen);
        System.out.println("Tamaño del archivo origen: " + tamanio + " bytes\n");
        
        // Copiar usando método tradicional
        System.out.println("--- Método Tradicional ---");
        copiarArchivoTradicional(archivoOrigen, archivoDestino1);
        
        System.out.println();
        
        // Copiar usando NIO
        System.out.println("--- Método NIO (Moderno) ---");
        copiarArchivoNIO(archivoOrigen, archivoDestino2);
        
        System.out.println("\nEjercicio completado. Revisa los archivos copiados.");
    }
}

