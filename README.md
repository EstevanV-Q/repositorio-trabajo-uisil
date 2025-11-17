# Guía de Archivos en Java

Este proyecto contiene una guía práctica y completa sobre el manejo de archivos en Java, desarrollada como parte de un workshop de Git. Incluye ejercicios progresivos que cubren las operaciones más comunes con archivos y directorios.

## 📋 Contenido

El proyecto está organizado en 4 ejercicios principales:

### Ejercicio 1: Lectura de Archivos
- Lectura línea por línea usando `BufferedReader`
- Uso de `try-with-resources` para manejo automático de recursos
- Manejo de excepciones `IOException`
- Demostración de diferentes métodos de lectura

**Clase:** `Ejercicio1LecturaArchivos.java`

### Ejercicio 2: Escritura de Archivos
- Escritura de archivos usando `FileWriter` y `BufferedWriter`
- Escritura usando `PrintWriter`
- Modo append (agregar al final del archivo)
- Escritura de múltiples líneas

**Clase:** `Ejercicio2EscrituraArchivos.java`

### Ejercicio 3: Copia de Archivos
- Copia de archivos usando método tradicional (`FileInputStream`/`FileOutputStream`)
- Copia usando la clase `Files` de NIO (método moderno)
- Verificación de existencia de archivos
- Obtención del tamaño de archivos

**Clase:** `Ejercicio3CopiaArchivos.java`

### Ejercicio 4: Manejo de Directorios
- Creación de directorios
- Listado de contenido de directorios
- Verificación de existencia de directorios
- Eliminación de directorios
- Recorrido recursivo de directorios

**Clase:** `Ejercicio4ManejoDirectorios.java`

### Clase Principal
La clase `Main.java` integra todos los ejercicios y proporciona un menú interactivo para ejecutarlos de forma individual o en secuencia.

## 🚀 Requisitos

- Java JDK 8 o superior
- Maven 3.6 o superior (para compilación)
- Git (para control de versiones)

## 📦 Compilación y Ejecución

### Compilar el proyecto con Maven:
```bash
mvn clean compile
```

### Ejecutar la clase principal:
```bash
mvn exec:java -Dexec.mainClass="com.mycompany.tarea.Main"
```

O compilar manualmente y ejecutar:
```bash
javac -d target/classes src/main/java/com/mycompany/tarea/*.java
java -cp target/classes com.mycompany.tarea.Main
```

### Ejecutar ejercicios individuales:
```bash
# Ejercicio 1
java -cp target/classes com.mycompany.tarea.Ejercicio1LecturaArchivos

# Ejercicio 2
java -cp target/classes com.mycompany.tarea.Ejercicio2EscrituraArchivos

# Ejercicio 3
java -cp target/classes com.mycompany.tarea.Ejercicio3CopiaArchivos

# Ejercicio 4
java -cp target/classes com.mycompany.tarea.Ejercicio4ManejoDirectorios
```

## 📁 Estructura del Proyecto

```
tarea/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── mycompany/
│                   └── tarea/
│                       ├── Main.java
│                       ├── Ejercicio1LecturaArchivos.java
│                       ├── Ejercicio2EscrituraArchivos.java
│                       ├── Ejercicio3CopiaArchivos.java
│                       └── Ejercicio4ManejoDirectorios.java
├── pom.xml
├── .gitignore
└── README.md
```

## 🔧 Conceptos Aprendidos

### Manejo de Archivos
- **FileReader/FileWriter**: Clases básicas para lectura/escritura de caracteres
- **BufferedReader/BufferedWriter**: Mejoran el rendimiento con buffer
- **FileInputStream/FileOutputStream**: Para lectura/escritura de bytes
- **PrintWriter**: Facilita la escritura formateada

### NIO (New I/O)
- **Files**: Clase utilitaria moderna para operaciones con archivos
- **Path**: Representa rutas de archivos de forma multiplataforma
- **DirectoryStream**: Para iterar sobre contenido de directorios

### Buenas Prácticas
- Uso de `try-with-resources` para cierre automático de recursos
- Manejo adecuado de excepciones `IOException`
- Verificación de existencia antes de operaciones
- Separación de responsabilidades en clases diferentes

## 📝 Historial de Commits

Este proyecto fue desarrollado con commits progresivos, cada ejercicio representa un commit separado:

1. `Configuración inicial: Agregado .gitignore para proyecto Maven`
2. `Ejercicio 1: Implementación de lectura de archivos con BufferedReader`
3. `Ejercicio 2: Implementación de escritura de archivos con FileWriter y PrintWriter`
4. `Ejercicio 3: Implementación de copia de archivos con métodos tradicional y NIO`
5. `Ejercicio 4: Implementación de manejo de directorios con operaciones CRUD`
6. `Clase principal: Integración de todos los ejercicios con menú interactivo`
7. `Documentación: Agregado README con guía completa del proyecto`

## 👨‍💻 Autor

Proyecto desarrollado como parte del Workshop Básico de Git.

## 📄 Licencia

Este proyecto es de uso educativo y puede ser utilizado libremente para fines de aprendizaje.

## 🔗 Recursos Adicionales

- [Documentación oficial de Java - I/O](https://docs.oracle.com/javase/tutorial/essential/io/)
- [Java NIO Tutorial](https://docs.oracle.com/javase/tutorial/essential/io/fileio.html)
- [Guía de Git](https://git-scm.com/doc)

---

**Nota:** Este proyecto fue creado siguiendo las mejores prácticas de Git, con commits descriptivos y una estructura clara que facilita el aprendizaje y la colaboración.

