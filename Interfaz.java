/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* CC2008
* AUTOR: Denil Parada
* FECHA: 01/09/2024
* DESCRIPCION: Interfaz de usuario para interactuar con el sistema de gestión de la biblioteca.
*/
import java.util.Scanner;

public class Interfaz {
    private Gestionador gestionador;
    private Scanner scanner;

    /**
     * Constructor que inicializa el gestor y el scanner para la interfaz.
     * @param gestionador El gestor de la biblioteca.
     */
    public Interfaz(Gestionador gestionador) {
        this.gestionador = gestionador;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y permite al usuario interactuar con el sistema.
     */
    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("1. Ingresar datos de libro");
            System.out.println("2. Ingresar datos de miembro");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Mostrar estadísticas detalladas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    ingresarDatosLibro();
                    break;
                case 2:
                    ingresarDatosMiembro();
                    break;
                case 3:
                    registrarPrestamo();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void ingresarDatosLibro() {
        System.out.print("Ingrese el nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal sucursal = gestionador.buscarSucursalPorNombre(nombreSucursal);
        if (sucursal == null) {
            System.out.println("Sucursal no encontrada. Creando nueva sucursal.");
            sucursal = new Sucursal(nombreSucursal);
            gestionador.agregarSucursal(sucursal);
        }

        System.out.print("Ingrese ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Ingrese título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese año de publicación: ");
        String anioPublicacion = scanner.nextLine();
        System.out.print("Ingrese género: ");
        String genero = scanner.nextLine();

        Libro libro = new Libro(ISBN, titulo, autor, anioPublicacion, genero);
        sucursal.agregarLibro(libro);
        System.out.println("Libro registrado exitosamente.");
    }

    private void ingresarDatosMiembro() {
        System.out.print("Ingrese el nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal sucursal = gestionador.buscarSucursalPorNombre(nombreSucursal);
        if (sucursal == null) {
            System.out.println("Sucursal no encontrada. Creando nueva sucursal.");
            sucursal = new Sucursal(nombreSucursal);
            gestionador.agregarSucursal(sucursal);
        }

        System.out.print("Ingrese ID del miembro: ");
        String ID = scanner.nextLine();
        System.out.print("Ingrese nombre del miembro: ");
        String nombre = scanner.nextLine();

        Miembro miembro = new Miembro(ID, nombre);
        sucursal.registrarMiembro(miembro);
        System.out.println("Miembro registrado exitosamente.");
    }

    private void registrarPrestamo() {
        System.out.print("Ingrese el nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal sucursal = gestionador.buscarSucursalPorNombre(nombreSucursal);
        if (sucursal == null) {
            System.out.println("Sucursal no encontrada.");
            return;
        }

        System.out.print("Ingrese ISBN del libro: ");
        String ISBN = scanner.nextLine();
        System.out.print("Ingrese ID del miembro: ");
        String ID = scanner.nextLine();
        System.out.print("Ingrese la fecha de préstamo (dd/mm/yyyy): ");
        String fechaPrestamo = scanner.nextLine();
        System.out.print("Ingrese la fecha de devolución esperada (dd/mm/yyyy): ");
        String fechaDevolucionEsperada = scanner.nextLine();

        if (sucursal.registrarPrestamo(ID, ISBN, fechaPrestamo, fechaDevolucionEsperada)) {
            System.out.println("Préstamo registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el préstamo. Asegúrese de que el libro y el miembro existan.");
        }
    }

    private void mostrarEstadisticas() {
        System.out.println(gestionador.generarEstadisticasGlobales());
    }

    public static void main(String[] args) {
        Gestionador gestionador = new Gestionador();
        Interfaz interfaz = new Interfaz(gestionador);
        interfaz.mostrarMenuPrincipal();
    }
}
