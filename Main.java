import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Supervisor supervisor;
    static PromotorVentas promotor;
    static ArrayList<EmpleadoAlmacen> newEmpleado = new ArrayList<>();
    static ArrayList<Producto> newPorducto = new ArrayList<>();
    static Random rand = new Random();

    public static void main(String[] args) {
        listaDeEmpleados();
        iniciarSesion();
    }

    // Terminado
    public static void listaDeEmpleados() {
        EmpleadoAlmacen EA1 = new EmpleadoAlmacen();
        EmpleadoAlmacen EA2 = new EmpleadoAlmacen();
        EmpleadoAlmacen EA3 = new EmpleadoAlmacen();
        EmpleadoAlmacen EA4 = new EmpleadoAlmacen();
        EmpleadoAlmacen EA5 = new EmpleadoAlmacen();
        EmpleadoAlmacen EA6 = new EmpleadoAlmacen();
        EmpleadoAlmacen EA7 = new EmpleadoAlmacen();
        EmpleadoAlmacen EA8 = new EmpleadoAlmacen();
        PromotorVentas EA9 = new PromotorVentas();
        Supervisor S1 = new Supervisor();

        EA1.setInfo("Juan Carlos Gomez Herrera", "Ayudante", "Activo", 43, 1001, "Bodega", 4);
        EA2.setInfo("Luis Hernandez Farrera", "Cajero", "Activo", 24, 1024, "Caja", 5);
        EA3.setInfo("Pedro Pablo Gomez Rodriguez", "Ayudante", "Activo", 25, 1021, "Bodega", 4);
        EA4.setInfo("Jose Lopez Gomez", "Ayudante", "Suspendido", 39, 1032, "Bodega", 3);
        EA5.setInfo("Miguel Angel Ramirez Herrera", "Proveedor", "Activo", 38, 1880, "Sucursal", 1);
        EA6.setInfo("Francisco Javier De la Cruz", "Cajero", "Activo", 25, 1034, "Caja", 3);
        EA7.setInfo("Carlos Rodriguez Pozo", "Proveedor", "Activo", 24, 1825, "Sucursales", 4);
        EA8.setInfo("Ricardo Ernesto, Perez", "Limpeza", "Activo", 48, 1244, "Tienda", 4);
        EA9.setInfo("Luis Ferrera Hernandez", "Promotor", "Activo", 35, 1832, "Sucursales", 40);
        S1.setInfo("Joel Isai Tovilla Gomez", "Supervisor", "Activo", 56, 2023, "Sucursal", 12);

        supervisor = S1;
        newEmpleado.add(EA1);
        newEmpleado.add(EA2);
        newEmpleado.add(EA3);
        newEmpleado.add(EA4);
        newEmpleado.add(EA5);
        newEmpleado.add(EA6);
        newEmpleado.add(EA7);
        newEmpleado.add(EA8);
        promotor = EA9;
    }

    // Terminado
    public static void iniciarSesion() {
        int pass, cont = 1;
        boolean ban = true;

        System.out.println("========== Iniciar sesion ==========");
        System.out.println("Para salir escriba un 3");

        while (ban) {
            System.out.print("Ingrese su ID: ");
            try {
                pass = sc.nextInt();
                if (cont == 3 || pass == 3) {
                    ban = false;
                } else {
                    switch (pass) {
                        case 1001:
                        case 1024:
                        case 1021:
                        case 1032:
                        case 1034:
                        case 1244:
                            System.out.println("Acciones actuales");
                            newEmpleado.get(2).action();
                            menuEmpleadoAlmacen();
                            ban = false;
                            break;
                        case 1880:
                        case 1825:
                        case 1832:
                            System.out.println("Acciones actuales");
                            newEmpleado.get(2).action();
                            menuProveedor();
                            ban = false;
                            break;
                        case 2023:
                            System.out.println("Acciones actuales");
                            supervisor.action();
                            menuSupervisor();
                            ban = false;
                            break;
                        default:
                            cont = cont + 1;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada, Intente de nuevo");
                sc.nextLine();
            }
        }
    }

    // Terminado
    public static void menuProveedor() {
        String nomProducto;
        int cantidadPaquete, selec;
        double precioPorUnidad, precioPorPaquete;
        boolean ban = true;

        System.out.println("=========== Acceso de Proveedor ===========");

        while (ban) {
            try {
                System.out.print("Añadir el producto pedido: ");
                nomProducto = sc.next();
                System.out.print("Cuantos paquetes vienen: ");
                cantidadPaquete = sc.nextInt();
                System.out.print("Precio por Unidad: ");
                precioPorUnidad = sc.nextDouble();
                System.out.print("Precio por paquete (Si no se vende por paquete entonces ponga el precio de unidad)");
                precioPorPaquete = sc.nextDouble();

                Producto newP = new Producto();
                newP.setCantidadPaquete(cantidadPaquete);
                newP.setNomProducto(nomProducto);
                newP.setPrecioPorPaquete(precioPorPaquete);
                newP.setPrecioPorUnidad(precioPorUnidad);

                newPorducto.add(newP);

                System.out.print("Seguir añadiendo\n1.Si\nCualquier numero para salir\n> ");
                selec = sc.nextInt();
                if (selec != 1) {
                    ban = false;
                    iniciarSesion();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada, Intente de nuevo");
                sc.nextLine();
            }
        }
    }

    // Inconcluso aun
    public static void menuEmpleadoAlmacen() {
        boolean ban = true;
        int selec;
        String nomPro;
        System.out.println("========== Acceso Empleado ==========");
        while (ban) {
            try {
                System.out.print("1.Ver lista de elementos\n2.Vender elemento\n3.Salir\n> ");
                selec = sc.nextInt();
                switch (selec) {
                    case 1:
                        if (newPorducto.size() != 0) {
                            for (int i = 0; i < newPorducto.size(); i++) {
                                if (newPorducto.get(i).getPrecioPorPaquete() != newPorducto.get(i).precioPorUnidad) {
                                    System.out.println("----------------\n" + newPorducto.get(i).getNomProducto()
                                            + "\nTotal en existencia: "
                                            + newPorducto.get(i).getCantidadPaquete() + "\nPrecio por paquete: "
                                            + newPorducto.get(i).precioPorPaquete + "\nPrecio por unidad: "
                                            + newPorducto.get(i).precioPorUnidad + "\n");
                                } else {
                                    System.out.println("----------------\n" + newPorducto.get(i).getNomProducto()
                                            + "\nTotal en existencia: "
                                            + newPorducto.get(i).getCantidadPaquete() + "\nPrecio por unidad: "
                                            + newPorducto.get(i).precioPorUnidad + "\n");
                                }
                            }
                        } else {
                            System.out.println("!!! No hay productos almacenados ahora");
                        }
                        break;
                    case 2:
                        if (newPorducto.size() != 0) {
                            System.out.print("Buscar por nombre del producto: ");
                            nomPro = sc.next();
                            for (int i = 0; i < newPorducto.size(); i++) {
                                if (newPorducto.get(i).getNomProducto().equals(nomPro)) {
                                    int cant;
                                    if (newPorducto.get(i).getPrecioPorPaquete() != newPorducto.get(i).precioPorUnidad) {
                                        System.out.println(newPorducto.get(i).getNomProducto() + "\nTotal en existencia: "
                                                + newPorducto.get(i).getCantidadPaquete() + "\nPrecio por paquete: "
                                                + newPorducto.get(i).precioPorPaquete + "\nPrecio por unidad: "
                                                + newPorducto.get(i).precioPorUnidad);
                                                System.out.print("\nVender cantidad: ");
                                                cant = sc.nextInt();
                                        if (cant > newPorducto.get(i).getCantidadPaquete()) {
                                            System.out.println("\nAcutualmente no hay sufiente o sin existencia\n");
                                        } else {                                          
                                            System.out.println(newPorducto.get(i).getCantidadPaquete());
                                            newPorducto.get(i).setCantidadPaquete(newPorducto.get(i).getCantidadPaquete() - cant);
                                        }

                                    } else {
                                        System.out.println(newPorducto.get(i).getNomProducto()
                                                + "\nTotal en existencia: "
                                                + newPorducto.get(i).getCantidadPaquete() + "\nPrecio por unidad: "
                                                + newPorducto.get(i).precioPorUnidad);
                                                System.out.print("\nVender cantidad: ");
                                                cant = sc.nextInt();
                                        if (cant > newPorducto.get(i).getCantidadPaquete()) {
                                            System.out.println("\nAcutualmente no hay sufiente o sin existencia\n");
                                        } else {                                          
                                            System.out.println(newPorducto.get(i).getCantidadPaquete());
                                            newPorducto.get(i).setCantidadPaquete(newPorducto.get(i).getCantidadPaquete() - cant);
                                        }
                                    }
                                    i = newPorducto.size();
                                }
                            }
                        } else {
                            System.out.println("!!! No hay productos almacenados ahora");
                        }
                        break;
                    case 3:
                        ban = false;
                        iniciarSesion();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada, Intente de nuevo");
                sc.nextLine();
            }
        }
    }

    // Terminado
    public static void menuSupervisor() {
        boolean ban = true;
        int selec;
        System.out.println("========== Acceso Supervisor ==========");

        while (ban) {
            System.out.print("Opciones\n1.ver lista de empleados\n2.Opciones de empleado\n3.Salir\n> ");
            try{

            selec = sc.nextInt();
            switch (selec) {
                case 1:
                    for (int i = 0; i < newEmpleado.size(); i++) {
                        System.out.println("---------------------\n" + newEmpleado.get(i).getInfo() + "\n");
                    }
                    break;
                case 2:
                    vistaSuper();
                    break;
                case 3:
                    ban = false;
                    iniciarSesion();
                    break;
            }
            } catch (InputMismatchException e){
                System.out.println("Error de entreda, intente de nuevo");
                sc.nextLine(); 
            }
        }
    }

    // Terminado acceso del supervisor unicamente
    public static void vistaSuper() {
        boolean ban = true;
        int selec, id;
        System.out.println("Opciones");
        while (ban) {
            System.out.print("1.Despedir empleado\n2.Suspender empleado\n3.Salir\n> ");
            try {
                selec = sc.nextInt();
                switch (selec) {
                    case 1:
                        System.out.print("Ingrese su ID para confirmar: ");
                        id = sc.nextInt();
                        if (id == supervisor.getId()) {
                            System.out.print("Ingrese la del empleado ID: ");
                            id = sc.nextInt();
                            for (int i = 0; i < newEmpleado.size(); i++) {
                                if (id == newEmpleado.get(i).getId()) {
                                    newEmpleado.get(i).setEstado("Despedido");
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese su ID para confirmar: ");
                        id = sc.nextInt();
                        if (id == supervisor.getId()) {
                            System.out.print("Ingrese la ID del empleado: ");
                            id = sc.nextInt();
                            for (int i = 0; i < newEmpleado.size(); i++) {
                                if (id == newEmpleado.get(i).getId()) {
                                    newEmpleado.get(i).setEstado("Suspendido");
                                }
                            }
                        }
                        break;
                    case 3:
                        ban = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de entreda, intente de nuevo");
                sc.nextLine();
            }
        }

    }
}
