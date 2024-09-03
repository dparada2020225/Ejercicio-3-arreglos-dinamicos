/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* CC2008
* AUTOR: Denil Parada
* FECHA: 01/09/2024
* DESCRIPCION: Clase encargada de gestionar las sucursales y sus operaciones.
*/
import java.util.ArrayList;
import java.util.List;

public class Gestionador {
    private List<Sucursal> sucursales;

    /**
     * Constructor que inicializa la lista de sucursales.
     */
    public Gestionador() {
        this.sucursales = new ArrayList<>();
    }

    /**
     * Agrega una sucursal a la lista de sucursales.
     * @param sucursal La sucursal a agregar.
     */
    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    /**
     * Obtiene la lista de sucursales.
     * @return Lista de sucursales.
     */
    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    /**
     * Busca una sucursal por nombre.
     * @param nombre Nombre de la sucursal a buscar.
     * @return Sucursal encontrada o null si no se encuentra.
     */
    public Sucursal buscarSucursalPorNombre(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombreSucursal().equals(nombre)) {
                return sucursal;
            }
        }
        return null; // Retorna null si no se encuentra la sucursal
    }

    /**
     * Genera estadísticas globales de todas las sucursales.
     * @return Cadena con las estadísticas globales.
     */
    public String generarEstadisticasGlobales() {
        StringBuilder estadisticasGlobales = new StringBuilder("Estadísticas Globales:\n");
        for (Sucursal sucursal : sucursales) {
            estadisticasGlobales.append(sucursal.generarEstadisticas()).append("\n");
        }
        return estadisticasGlobales.toString();
    }
}
