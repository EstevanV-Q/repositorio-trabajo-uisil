package com.mycompany.tarea;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Ejercicio 4: Manejo de Directorios
 * 
 * Esta clase demuestra operaciones con directorios en Java:
 * - Crear directorios
 * - Listar contenido de directorios
 * - Verificar existencia de directorios
 * - Eliminar directorios
 * - Recorrer directorios recursivamente
 */
public class Ejercicio4ManejoDirectorios {
    
    /**
     * Crea un directorio si no existe
     * 
     * @param rutaDirectorio Ruta del directorio a crear
     * @return true si se creó exitosamente o ya existía, false en caso contrario
     */
    public static boolean crearDirectorio(String rutaDirectorio) {
        try {
            Path directorio = Paths.get(rutaDirectorio);
            
            if (Files.exists(directorio)) {
                System.out.println("El directorio ya existe: " + rutaDirectorio);
                return true;
            }
            
            Files.createDirectories(directorio); // Crea también los directorios padre si no existen
            System.out.println("Directorio creado exitosamente: " + rutaDirectorio);
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al crear el directorio: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Lista el contenido de un directorio
     * 
     * @param rutaDirectorio Ruta del directorio a listar
     */
    public static void listarDirectorio(String rutaDirectorio) {
        try {
            Path directorio = Paths.get(rutaDirectorio);
            
            if (!Files.exists(directorio) || !Files.isDirectory(directorio)) {
                System.err.println("El directorio no existe o no es un directorio: " + rutaDirectorio);
                return;
            }
            
            System.out.println("\n=== Contenido del directorio: " + rutaDirectorio + " ===");
            
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {
                for (Path archivo : stream) {
                    if (Files.isDirectory(archivo)) {
                        System.out.println("[DIR]  " + archivo.getFileName());
                    } else {
                        long tamanio = Files.size(archivo);
                        System.out.println("[ARCH] " + archivo.getFileName() + " (" + tamanio + " bytes)");
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error al listar el directorio: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Verifica si una ruta es un directorio
     * 
     * @param ruta Ruta a verificar
     * @return true si es un directorio, false en caso contrario
     */
    public static boolean esDirectorio(String ruta) {
        Path path = Paths.get(ruta);
        return Files.exists(path) && Files.isDirectory(path);
    }
    
    /**
     * Elimina un directorio vacío
     * 
     * @param rutaDirectorio Ruta del directorio a eliminar
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    public static boolean eliminarDirectorio(String rutaDirectorio) {
        try {
            Path directorio = Paths.get(rutaDirectorio);
            
            if (!Files.exists(directorio)) {
                System.out.println("El directorio no existe: " + rutaDirectorio);
                return false;
            }
            
            Files.delete(directorio);
            System.out.println("Directorio eliminado exitosamente: " + rutaDirectorio);
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al eliminar el directorio: " + e.getMessage());
            System.err.println("Nota: El directorio debe estar vacío para poder eliminarlo.");
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Recorre un directorio recursivamente y muestra su estructura
     * 
     * @param rutaDirectorio Ruta del directorio raíz
     * @param nivel Nivel de indentación (usado para la recursión)
     */
    public static void recorrerDirectorioRecursivo(String rutaDirectorio, int nivel) {
        try {
            Path directorio = Paths.get(rutaDirectorio);
            
            if (!Files.exists(directorio) || !Files.isDirectory(directorio)) {
                return;
            }
            
            // Indentación según el nivel
            String indentacion = "  ".repeat(nivel);
            
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {
                for (Path elemento : stream) {
                    if (Files.isDirectory(elemento)) {
                        System.out.println(indentacion + "[DIR] " + elemento.getFileName());
                        // Llamada recursiva
                        recorrerDirectorioRecursivo(elemento.toString(), nivel + 1);
                    } else {
                        long tamanio = Files.size(elemento);
                        System.out.println(indentacion + "[ARCH] " + elemento.getFileName() + " (" + tamanio + " bytes)");
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error al recorrer el directorio: " + e.getMessage());
        }
    }
    
    /**
     * Método principal para probar el manejo de directorios
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 4: Manejo de Directorios\n");
        
        // Crear algunos directorios de prueba
        String dir1 = "directorio_prueba";
        String dir2 = "directorio_prueba/subdirectorio";
        String dir3 = "directorio_prueba/subdirectorio/nivel2";
        
        System.out.println("--- Creando directorios ---");
        crearDirectorio(dir1);
        crearDirectorio(dir2);
        crearDirectorio(dir3);
        
        System.out.println("\n--- Verificando directorios ---");
        System.out.println("¿Es directorio '" + dir1 + "'? " + esDirectorio(dir1));
        System.out.println("¿Es directorio 'archivo.txt'? " + esDirectorio("archivo.txt"));
        
        System.out.println("\n--- Listando directorio raíz ---");
        listarDirectorio(".");
        
        System.out.println("\n--- Recorrido recursivo del directorio de prueba ---");
        recorrerDirectorioRecursivo(dir1, 0);
        
        System.out.println("\nEjercicio completado.");
        System.out.println("Nota: Los directorios creados pueden eliminarse manualmente o con el método eliminarDirectorio()");
    }
}

