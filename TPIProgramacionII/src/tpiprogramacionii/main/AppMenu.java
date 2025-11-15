
package tpiprogramacionii.main;

import java.util.Scanner;
import tpiprogramacionii.dao.EmpleadoDAO;
import tpiprogramacionii.dao.LegajoDAO;
import tpiprogramacionii.service.EmpleadoService;
import tpiprogramacionii.service.LegajoService;


class AppMenu {
        // Scanner único para leer entradas de usuario desde la consola
        private final Scanner scanner;
        // Controlador del menú que contiene toda la lógica de interacción
        private final MenuController menuController;
        // Servicios de la capa de negocio
        private final EmpleadoService empleadoService;
        private final LegajoService legajoService;
        // Bandera para controlar el ciclo principal de la aplicación
        private boolean running;

        /**
        * Clase principal de la aplicación de consola.
        * Se encarga de:
        * - Crear los DAOs y Services (cadena de dependencias).
        * - Crear el MenuController, que maneja la lógica del menú.
        * - Mostrar el menú principal en un bucle hasta que el usuario elija salir.
        */
        public AppMenu() {
            
            
            this.scanner = new Scanner(System.in);
            // DAOs
            // DAO de Legajo (se usa también dentro de EmpleadoDAO)
            LegajoDAO legajoDAO = new LegajoDAO();
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(legajoDAO);
            
            // Services 
            // Servicio que encapsula la lógica de negocio de legajos
            this.legajoService = new LegajoService(legajoDAO);
            this.empleadoService = new EmpleadoService(empleadoDAO, legajoDAO);
            
            // Controller
            // Controlador del menú, que usará los servicios para atender las opciones del usuario
            this.menuController = new MenuController(scanner, empleadoService, legajoService);
            
            // La aplicación comienza en estado "ejecutándose"
            this.running = true;
        }

        /**
        * Punto de entrada de la aplicación.
        * Crea una instancia de AppMenu y ejecuta el bucle principal.
        */
         public static void main(String[] args) {
               AppMenu app = new AppMenu();
               app.run();
         }
         
         /**
        * Bucle principal de la aplicación.
        * Muestra el menú, lee la opción y delega al método processOption.
        * El bucle se mantiene mientras la bandera 'running' sea true.
        */
         public void run() {
              while (running) {
              try {
                  // Mostrar opciones del menú principal
                  MenuDisplay.mostrarMenuPrincipal();
                  int opcion = Integer.parseInt(scanner.nextLine());
                  processOption(opcion);
               } catch (NumberFormatException e) {
                  System.out.println("Entrada invalida. Por favor, ingrese un numero.");
               }
              }
              // Cerramos el scanner al terminar la aplicación
             scanner.close();
         }
          
         /**
        * Procesa la opción seleccionada por el usuario en el menú principal.
        * Cada caso del switch delega la operación concreta al MenuController.
        */
         private void processOption(int opcion) {
             switch (opcion) {
                  case 1 -> menuController.crearEmpleado();
                  case 2 -> menuController.buscarEmpleadoPorId();
                  case 3 -> menuController.listarEmpleados();
                  case 4 -> menuController.actualizarAreaEmpleado();
                  case 5 -> menuController.eliminarEmpleadoPorId();
                  case 6 -> menuController.buscarEmpleadoPorDni();
                  case 7 -> menuController.listarLegajos();
                  case 8 -> menuController.buscarLegajoPorId();
                  case 9 -> menuController.actualizarCategoriaLegajo();
                  case 10 -> menuController.actualizarEstadoLegajo();
                  case 11 -> menuController.eliminarLegajoPorId();
                  case 0 -> {
                  System.out.println("Saliendo...");
                  running = false;  // Se corta el bucle principal en run()
                 }
            default -> System.out.println("Opcion no valida.");
            }
         }                    
}
