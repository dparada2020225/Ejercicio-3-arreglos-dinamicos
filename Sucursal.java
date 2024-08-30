import java.util.ArrayList;
import java.util.List;

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

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public void registrarMiembro(Miembro miembro) {
        this.miembros.add(miembro);
    }

    public void registrarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    public String generarEstadisticas() {
        // Implementación de generación de estadísticas
        return "Estadísticas generadas.";
    }

    @Override
    public String toString() {
        return "Sucursal [nombreSucursal=" + nombreSucursal + "]";
    }
}
