import java.util.List;
import java.util.ArrayList;

public class Concesionario {
    private List<Vehiculo> vehiculos = new ArrayList<>(); // Lista de vehículos disponibles
    private List<Venta> ventas = new ArrayList<>(); // Lista de ventas realizadas

    // Método para agregar un vehículo al inventario
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    // Método para realizar una venta de un vehículo
    public void realizarVenta(String codigoVehiculo, double monto, String apellido, String nombre, String documento) {
        Vehiculo vehiculoVendido = null;
        // Buscar el vehículo en el inventario
        for (Vehiculo v : vehiculos) {
            if (v.getCodigo().equals(codigoVehiculo)) {
                vehiculoVendido = v;
                break;
            }
        }
        // Si se encuentra el vehículo, se registra la venta
        if (vehiculoVendido != null) {
            ventas.add(new Venta(monto, vehiculoVendido, apellido, nombre, documento));
            vehiculos.remove(vehiculoVendido);
            System.out.println("Venta realizada: " + nombre + " " + apellido + " ha comprado " + vehiculoVendido.getMarca());
        } else {
            System.out.println("Error: Vehículo con código " + codigoVehiculo + " no encontrado.");
        }
    }

    // Método para mostrar el inventario actual
    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    // Método para mostrar el historial de ventas
    public void mostrarVentas() {
        System.out.println("Ventas realizadas:");
        for (Venta v : ventas) {
            System.out.println(v);
        }
    }
}
