/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* CC2008
* AUTOR: Denil Parada
* FECHA: 01/09/2024
* DESCRIPCION: Clase que gestiona los préstamos de libros a los miembros, incluyendo detalles del libro, miembro y las fechas de préstamo y devolución esperada.
*/
public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private String fechaPrestamo;
    private String fechaDevolucionEsperada;

    /**
     * Constructor para registrar un préstamo de libro a un miembro.
     * @param libro El libro que se presta.
     * @param miembro El miembro que recibe el libro.
     * @param fechaPrestamo La fecha en que se realiza el préstamo.
     * @param fechaDevolucionEsperada La fecha esperada para la devolución del libro.
     */
    public Prestamo(Libro libro, Miembro miembro, String fechaPrestamo, String fechaDevolucionEsperada) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    // Getters y setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(String fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", miembro=" + miembro +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaDevolucionEsperada='" + fechaDevolucionEsperada + '\'' +
                '}';
    }
}
