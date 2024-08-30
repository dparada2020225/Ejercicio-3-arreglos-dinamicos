import java.util.ArrayList;
import java.util.List;

public class Gestionador {
    private List<Sucursal> sucursales;

    public Gestionador() {
        this.sucursales = new ArrayList<>();
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public String generarEstadisticasGlobales() {
        // Implementación de generación de estadísticas globales
        return "Estadísticas globales generadas.";
    }

    @Override
    public String toString() {
        return "Gestionador con " + sucursales.size() + " sucursales.";
    }
}
