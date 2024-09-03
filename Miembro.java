/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* CC2008
* AUTOR: Denil Parada
* FECHA: 01/09/2024
* DESCRIPCION: Clase que representa a un miembro de la biblioteca con identificación y nombre.
*/
public class Miembro {
    private String ID;
    private String nombre;

    /**
     * Constructor para crear un miembro de la biblioteca.
     * @param ID El identificador único del miembro.
     * @param nombre El nombre del miembro.
     */
    public Miembro(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    // Getters y setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Miembro{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
