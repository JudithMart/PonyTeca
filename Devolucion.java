
import java.util.Scanner;
import java.util.Set;

public class Devolucion extends Operacion {

    private String fechaDevolucion;
    private String nombreAlumno;
    private String idPrestamo;

    private Operacion prestamos[] = new Operacion[1000];

    public Devolucion() {

    }

    public String queSoy() {
        return "Devolucion";
    }

    public Devolucion(String nombreMaterial, String idMaterial, int cantidad,
            String fechaDevolucion, String nombreAlumno, String idPrestamo) {
        super(nombreMaterial, idMaterial, cantidad);
        this.fechaDevolucion = fechaDevolucion;
        this.nombreAlumno = nombreAlumno;
        this.idPrestamo = idPrestamo;

    }

    public void capturar(Inventario material) {
        Scanner leer = new Scanner(System.in);
        System.out.println("");
        System.out.print("----------Captura Datos De Devolucion----------");
        System.out.println("");
        super.capturar();
        System.out.print("Id prestamo        : ");
        idPrestamo = leer.nextLine();

        super.setNombreMaterial(material.getTitulo());

    }

    public boolean mostrarDev(Inventario material, String nombre) {
        if (material.devolver(idPrestamo, super.getCantidad())) {
            System.out.println("Nombre Alumno      : " + nombre + "\n");
            return true;
        }
        return false;
    }

    public void mostrar() {
        Scanner leer = new Scanner(System.in);

        System.out.println("");
        System.out.print("----------------Datos de Devolucion----------");
        System.out.println("");
        super.mostrar();
        System.out.println("Fecha devolucion                 :    10/06/22");
        System.out.println("Nombre                           :    " + nombreAlumno);
        System.out.println("Id prestamo                      :    " + idPrestamo + "\n");

        System.out.println("");
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String alumnoNombre) {
        this.nombreAlumno = alumnoNombre;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

}
