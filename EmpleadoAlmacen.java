public class EmpleadoAlmacen extends Empleado {
    String areaDeTrabajo;
    int numeroAlmacen;

    public void setInfo(String nombre, String ocupacionAct, String estado, int edad, int id, String areaDeTrabajo, int numAlmacen) {
        this.nombre = nombre;
        this.ocupacionActual = ocupacionAct;
        this.estado = estado;
        this.areaDeTrabajo = areaDeTrabajo;
        this.edad = edad;
        this.id = id;
        this.numeroAlmacen = numAlmacen;
    }

    public String getInfo() {
        return ("Empleado: " + nombre + "\nEdad: " + edad + " años\nEstado " + estado + "\nEspecialidad "
                + ocupacionActual + "\nArea designada: " + areaDeTrabajo + "\nID: " + id + "\nAlmacen Designado: "+ numeroAlmacen);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    @Override
    public void action() {
        System.out.println("Realizando las  tareas de almacen.");
    }
}