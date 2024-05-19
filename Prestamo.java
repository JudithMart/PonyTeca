
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Prestamo extends Operacion {

    private String fechaPrestamo;
    private String fechaEntrega;
    private String nombreAlumno;
    private String idPrestamo2;
    private String idPrestamo;
    private boolean led = true;

    public Prestamo() {
    }

    @Override
    public String queSoy() {
        return "Prestamo";
    }

    public Prestamo(String nombreMaterial, String idMaterial, int cantidad,
            String fechaPrestamo, String fechaEntrega, String nombreAlumno, String idPrestamo) {
        super(nombreMaterial, idMaterial, cantidad);
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.nombreAlumno = nombreAlumno;
        this.idPrestamo = idPrestamo;
    }

    public void capturar(Inventario material, PonyTeca nombre) {
        boolean h;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("");
            System.out.print("----------Ingresa De Datos Del prestamo----------");
            System.out.println("");
            super.capturar();
            System.out.print("Nombre usuario       :    ");
            nombreAlumno = leer.nextLine();
            if (nombre.verificarN(nombreAlumno) == false) {
                System.out.println("Nombre de alumno no registrado ");
                h = false;
                continue;
            }
            System.out.print("ID Prestamo         :    ");
            idPrestamo = leer.nextLine();
            idPrestamo2 = idPrestamo;
            h = material.prestar(idPrestamo, super.getCantidad());
            if (h == false) {
                System.out.println("Intenta otro ID");
            } else {

                System.out.print("Fecha de Entrega     :    ");
                fechaEntrega = leer.nextLine();
            }
            super.setNombreMaterial(material.getTitulo());
            System.out.println("");

        } while (h == false);
    }

    public void mostrar() {
        Scanner leer = new Scanner(System.in);
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFinal = sdf.format(fechaActual);
        System.out.println("");
        System.out.print("----------------Datos Del Prestamo----------");
        System.out.println("");
        super.mostrar();
        System.out.println("Fecha de Prestamo    :    " + fechaFinal);
        System.out.println("Fecha de Entrega     :    " + fechaEntrega);
        System.out.println("Nombre del Alumno    :    " + nombreAlumno);
        System.out.println("ID Prestamo          :    " + idPrestamo2);

        System.out.println("");
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public boolean getLed() {
        return led;
    }

    public void setLed(boolean led) {
        this.led = led;
    }

}
