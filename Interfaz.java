import java.util.Scanner;

public class Interfaz {
    private Gestionador gestionador;

    public Interfaz(Gestionador gestionador) {
        this.gestionador = gestionador;
    }

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú Principal");
            System.out.println("1. Ingresar datos de libro");
            System.out.println("2. Ingresar datos de miembro");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Mostrar estadísticas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

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
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public void ingresarDatosLibro() {
        Scanner scanner = new Scanner(System.in);
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
        // Aquí puedes seleccionar una sucursal para agregar el libro
        System.out.print("Ingrese el nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal sucursal = buscarSucursalPorNombre(nombreSucursal);
        if (sucursal != null) {
            sucursal.agregarLibro(libro);
            System.out.println("Libro registrado exitosamente.");
        } else {
            System.out.println("Sucursal no encontrada.");
        }
    }

    public void ingresarDatosMiembro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del miembro: ");
        String ID = scanner.nextLine();
        System.out.print("Ingrese nombre del miembro: ");
        String nombre = scanner.nextLine();

        Miembro miembro = new Miembro(ID, nombre);
        // Aquí puedes seleccionar una sucursal para registrar el miembro
        System.out.print("Ingrese el nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal sucursal = buscarSucursalPorNombre(nombreSucursal);
        if (sucursal != null) {
            sucursal.registrarMiembro(miembro);
            System.out.println("Miembro registrado exitosamente.");
        } else {
            System.out.println("Sucursal no encontrada.");
        }
    }

    public void registrarPrestamo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID del miembro: ");
        String ID = scanner.nextLine();
        System.out.print("Ingrese ISBN del libro: ");
        String ISBN = scanner.nextLine();
        System.out.print("Ingrese la fecha de préstamo (dd/mm/yyyy): ");
        String fechaPrestamo = scanner.nextLine();
        System.out.print("Ingrese la fecha de devolución esperada (dd/mm/yyyy): ");
        String fechaDevolucionEsperada = scanner.nextLine();

        // Buscar miembro y libro en las sucursales
        Miembro miembro = buscarMiembroPorID(ID);
        Libro libro = buscarLibroPorISBN(ISBN);
        if (miembro != null && libro != null) {
            Prestamo prestamo = new Prestamo(libro, miembro, fechaPrestamo, fechaDevolucionEsperada);
            // Aquí puedes seleccionar una sucursal para registrar el préstamo
            System.out.print("Ingrese el nombre de la sucursal: ");
            String nombreSucursal = scanner.nextLine();
            Sucursal sucursal = buscarSucursalPorNombre(nombreSucursal);
            if (sucursal != null) {
                sucursal.registrarPrestamo(prestamo);
                System.out.println("Préstamo registrado exitosamente.");
            } else {
                System.out.println("Sucursal no encontrada.");
            }
        } else {
            System.out.println("Miembro o libro no encontrado.");
        }
    }

    public void mostrarEstadisticas() {
        System.out.println(gestionador.generarEstadisticasGlobales());
    }

    private Sucursal buscarSucursalPorNombre(String nombre) {
        for (Sucursal sucursal : gestionador.getSucursales()) {
            if (sucursal.getNombreSucursal().equals(nombre)) {
                return sucursal;
            }
        }
        return null;
    }

    private Miembro buscarMiembroPorID(String ID) {
        for (Sucursal sucursal : gestionador.getSucursales()) {
            for (Miembro miembro : sucursal.getMiembros()) {
                if (miembro.getID().equals(ID)) {
                    return miembro;
                }
            }
        }
        return null;
    }

    private Libro buscarLibroPorISBN(String ISBN) {
        for (Sucursal sucursal : gestionador.getSucursales()) {
            for (Libro libro : sucursal.getLibros()) {
                if (libro.getISBN().equals(ISBN)) {
                    return libro;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Interfaz de gestión de la biblioteca.";
    }
}
