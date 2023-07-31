
public class Supervisor extends Empleado {
    String encargadoArea;
    int horasTrabajadas;

    public void setInfo(String nombre, String ocupacionAct, String estado, int edad, int id, String encargadoArea, int horas) {
        this.nombre = nombre;
        this.ocupacionActual = ocupacionAct;
        this.estado = estado;
        this.encargadoArea = encargadoArea;
        this.edad = edad;
        this.id = id;
        this.horasTrabajadas = horas;
    }

    public String getInfo() {
        return ("Empleado: " + nombre + " Edad: " + edad + " años\nEstado " + estado + "\nEspecialidad " + ocupacionActual + "\nArea designada: " + encargadoArea + "\nID: " + id + "\nHoras totales: " + horasTrabajadas);
    }

    public int getId() {
        return id;
    }
    

    @Override
    public void action() {
        System.out.println("Supervisando el trabajo de los empleados.");
    }
}




