package com.mycompany.tarea;

import java.util.Scanner;

/**
 * Clase Principal - Guía de Archivos en Java
 * 
 * Esta clase integra todos los ejercicios de manejo de archivos
 * y proporciona un menú interactivo para ejecutarlos.
 */
public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Muestra el menú principal
     */
    public static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("   GUÍA DE ARCHIVOS EN JAVA");
        System.out.println("========================================");
        System.out.println("1. Ejercicio 1: Lectura de Archivos");
        System.out.println("2. Ejercicio 2: Escritura de Archivos");
        System.out.println("3. Ejercicio 3: Copia de Archivos");
        System.out.println("4. Ejercicio 4: Manejo de Directorios");
        System.out.println("5. Ejecutar todos los ejercicios en secuencia");
        System.out.println("0. Salir");
        System.out.println("========================================\n");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Ejecuta el ejercicio 1
     */
    public static void ejecutarEjercicio1() {
        System.out.println("\n--- EJERCICIO 1: LECTURA DE ARCHIVOS ---\n");
        
        // Primero crear un archivo de prueba
        String archivoPrueba = "archivo_prueba.txt";
        Ejercicio2EscrituraArchivos.escribirArchivo(archivoPrueba, 
            "Este es un archivo de prueba para el ejercicio de lectura.");
        Ejercicio2EscrituraArchivos.agregarAlArchivo(archivoPrueba, 
            "Segunda línea del archivo.");
        Ejercicio2EscrituraArchivos.agregarAlArchivo(archivoPrueba, 
            "Tercera línea del archivo.");
        
        // Ahora leer el archivo
        Ejercicio1LecturaArchivos.leerArchivo(archivoPrueba);
        Ejercicio1LecturaArchivos.leerArchivoConTryWithResources(archivoPrueba);
    }
    
    /**
     * Ejecuta el ejercicio 2
     */
    public static void ejecutarEjercicio2() {
        System.out.println("\n--- EJERCICIO 2: ESCRITURA DE ARCHIVOS ---\n");
        Ejercicio2EscrituraArchivos.main(new String[0]);
    }
    
    /**
     * Ejecuta el ejercicio 3
     */
    public static void ejecutarEjercicio3() {
        System.out.println("\n--- EJERCICIO 3: COPIA DE ARCHIVOS ---\n");
        Ejercicio3CopiaArchivos.main(new String[0]);
    }
    
    /**
     * Ejecuta el ejercicio 4
     */
    public static void ejecutarEjercicio4() {
        System.out.println("\n--- EJERCICIO 4: MANEJO DE DIRECTORIOS ---\n");
        Ejercicio4ManejoDirectorios.main(new String[0]);
    }
    
    /**
     * Ejecuta todos los ejercicios en secuencia
     */
    public static void ejecutarTodos() {
        System.out.println("\n=== EJECUTANDO TODOS LOS EJERCICIOS ===\n");
        ejecutarEjercicio1();
        System.out.println("\n" + "=".repeat(50) + "\n");
        ejecutarEjercicio2();
        System.out.println("\n" + "=".repeat(50) + "\n");
        ejecutarEjercicio3();
        System.out.println("\n" + "=".repeat(50) + "\n");
        ejecutarEjercicio4();
        System.out.println("\n=== TODOS LOS EJERCICIOS COMPLETADOS ===\n");
    }
    
    /**
     * Método principal
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido a la Guía de Archivos en Java");
        System.out.println("Este proyecto contiene ejercicios prácticos sobre manejo de archivos.");
        
        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        ejecutarEjercicio1();
                        break;
                    case 2:
                        ejecutarEjercicio2();
                        break;
                    case 3:
                        ejecutarEjercicio3();
                        break;
                    case 4:
                        ejecutarEjercicio4();
                        break;
                    case 5:
                        ejecutarTodos();
                        break;
                    case 0:
                        System.out.println("\n¡Gracias por usar la Guía de Archivos en Java!");
                        break;
                    default:
                        System.out.println("\nOpción no válida. Por favor, seleccione una opción del menú.");
                }
                
                if (opcion != 0) {
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine();
                }
                
            } catch (NumberFormatException e) {
                System.out.println("\nError: Por favor, ingrese un número válido.");
                opcion = -1;
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
}

