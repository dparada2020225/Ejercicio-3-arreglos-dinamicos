/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* CC2008
* AUTOR: Denil Parada
* FECHA: 01/09/2024
* DESCRIPCION: Clase responsable de gestionar las sucursales, incluyendo la creación, búsqueda y generación de estadísticas globales.
*/
import java.util.ArrayList;
import java.util.List;

public class Gestionador {
    private List<Sucursal> sucursales;

    public Gestionador() {
        this.sucursales = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public Sucursal buscarSucursalPorNombre(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombreSucursal().equals(nombre)) {
                return sucursal;
            }
        }
        return null; // Retorna null si no se encuentra la sucursal
    }

    public String generarEstadisticasGlobales() {
        StringBuilder estadisticasGlobales = new StringBuilder("Estadísticas Globales:\n");
        for (Sucursal sucursal : sucursales) {
            estadisticasGlobales.append(sucursal.generarEstadisticas()).append("\n");
        }
        return estadisticasGlobales.toString();
    }
}
