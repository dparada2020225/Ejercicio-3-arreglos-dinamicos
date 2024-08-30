public class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private String fechaPrestamo;
    private String fechaDevolucionEsperada;

    public Prestamo(Libro libro, Miembro miembro, String fechaPrestamo, String fechaDevolucionEsperada) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

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
        return "Prestamo [libro=" + libro + ", miembro=" + miembro + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucionEsperada=" + fechaDevolucionEsperada + "]";
    }
}
