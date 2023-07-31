public class PromotorVentas extends Empleado {
    String direccionSucursal;
    int cantidadProducto;

    public void setInfo(String nombre, String ocupacionAct, String estado, int edad, int id, String direccionSucursal, int cantidadProducto) {
        this.nombre = nombre;
        this.ocupacionActual = ocupacionAct;
        this.estado = estado;
        this.direccionSucursal = direccionSucursal;
        this.edad = edad;
        this.id = id;
        this.cantidadProducto = cantidadProducto;
    }

    public String getInfo() {
        return ("Empleado: " + nombre + "\nEdad: " + edad + " años\nEstado " + estado + "\nEspecialidad "
                + ocupacionActual + "\nArea designada: " + direccionSucursal + "\nID: " + id + "\nCantidad de productos: "+ cantidadProducto);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    @Override
    public void action() {
        System.out.println("Realizando la tareas de  promotor  y ventas.");
    }
}