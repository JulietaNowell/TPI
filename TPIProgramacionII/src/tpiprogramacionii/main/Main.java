
package tpiprogramacionii.main;

/**
 * Punto de entrada de la aplicación.
 * Solo delega la ejecución a la clase AppMenu, que contiene
 * el bucle principal del programa y el manejo del menú.
 */
public class Main {
    
    public static void main(String[] args) {
        AppMenu app = new AppMenu(); // Crear la aplicación de menú
        app.run(); // Iniciar el bucle principal (mostrar menú y procesar opciones)
        
    }

  
}
