import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sucursal {
    private String nombreSucursal;
    private List<Libro> libros;
    private List<Miembro> miembros;
    private List<Prestamo> prestamos;

    public Sucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.libros = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

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
