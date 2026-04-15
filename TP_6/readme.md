Objetivo:  
Conocer el funcionamiento de un validador en Angular para asegurar la integridad de los datos dentro de un formulario reactivo antes de que sean procesados o enviados al servidor.  

Este proyecto consiste en una aplicación con backend en Spring Boot y frontend en Angular que permite validar si un nombre de usuario ya existe en la base de datos.

Ejecución del Backend:  
 * Abrir el proyecto backend en algun ide  
 * Ejecutar la aplicación Spring Boot  
El servidor se iniciará en:  
    * http://localhost:8080


Ejecución del Frontend  
 * Abrir una terminal en la carpeta raíz del frontend  
 * Ejecutar:  
     * ng serve
 * Acceder por:  
     * http://localhost:4200


Verificación de funcionamiento  
Ingresar un nombre de usuario en el formulario  
Si el nombre ya existe en la base de datos: ej. **Rodo**  
Se mostrará un mensaje indicando que está en uso


Endpoint utilizado  
GET http://localhost:8080/api/exists?username={valor}  

Devuelve:  
true → el usuario ya existe  
false → el usuario está disponible
