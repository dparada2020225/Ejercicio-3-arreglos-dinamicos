/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* CC2008
* AUTOR: Denil Parada
* FECHA: 01/09/2024
* DESCRIPCION: Clase que representa una sucursal de la biblioteca
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sucursal {
    private String nombreSucursal;
    private List<Libro> libros;
    private List<Miembro> miembros;
    private List<Prestamo> prestamos;

    /**
     * Constructor que inicializa una nueva sucursal con su nombre.
     * @param nombreSucursal El nombre de la sucursal.
     */
    public Sucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.libros = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    /**
     * Agrega un libro a la lista de libros de la sucursal.
     * @param libro El libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Registra un miembro en la lista de miembros de la sucursal.
     * @param miembro El miembro a registrar.
     */
    public void registrarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    /**
     * Registra un préstamo de un libro a un miembro en la sucursal.
     * @param ID El identificador del miembro.
     * @param ISBN El ISBN del libro prestado.
     * @param fechaPrestamo La fecha en que se realiza el préstamo.
     * @param fechaDevolucionEsperada La fecha esperada para la devolución del libro.
     * @return true si el préstamo se ha registrado correctamente, false en caso contrario.
     */
    public boolean registrarPrestamo(String ID, String ISBN, String fechaPrestamo, String fechaDevolucionEsperada) {
        Libro libro = libros.stream().filter(l -> l.getISBN().equals(ISBN)).findFirst().orElse(null);
        Miembro miembro = miembros.stream().filter(m -> m.getID().equals(ID)).findFirst().orElse(null);
        if (libro != null && miembro != null) {
            Prestamo prestamo = new Prestamo(libro, miembro, fechaPrestamo, fechaDevolucionEsperada);
            prestamos.add(prestamo);
            return true;
        }
        return false;
    }

    /**
     * Genera estadísticas de los préstamos de la sucursal.
     * @return Una cadena con las estadísticas de los préstamos.
     */
    public String generarEstadisticas() {
        if (prestamos.isEmpty()) {
            return "No hay préstamos registrados.";
        }

        Map<String, Long> generoCount = prestamos.stream()
            .collect(Collectors.groupingBy(prestamo -> prestamo.getLibro().getGenero(), Collectors.counting()));

        Map<String, Long> libroCount = prestamos.stream()
            .collect(Collectors.groupingBy(prestamo -> prestamo.getLibro().getTitulo(), Collectors.counting()));

        String generoMasSolicitado = generoCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("Ninguno");

        String libroMasPrestado = libroCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("Ninguno");

        return String.format("Estadísticas de la Sucursal %s:\nTotal de préstamos: %d\nGénero más solicitado: %s\nLibro más prestado: %s",
                             nombreSucursal, prestamos.size(), generoMasSolicitado, libroMasPrestado);
    }

    // Getters
    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
