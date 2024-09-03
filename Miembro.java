/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* CC2008
* AUTOR: Denil Parada
* FECHA: 01/09/2024
* DESCRIPCION: Clase que representa a un miembro del sistema de biblioteca, incluyendo detalles como el ID y nombre del miembro.
*/
public class Miembro {
    private String ID;
    private String nombre;

    public Miembro(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

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
