
import java.util.Scanner;
import java.io.Serializable;

public class Operacion implements Basica, Serializable {

    protected String nombreMaterial;
    protected String idMaterial;
    protected int cantidad;

    public Operacion() {

    }

    public Operacion(String nombreMaterial, String idMaterial, int cantidad) {
        this.nombreMaterial = nombreMaterial;
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
    }

    public String queSoy() {
        return "Operacion";
    }

    public void mostrar() {
        System.out.println("Nombre del material  :    " + nombreMaterial);
    }

    public void capturar() {
        Scanner lee = new Scanner(System.in);
        System.out.println("");
    }

    protected String getNombreMaterial() {
        return nombreMaterial;
    }

    protected void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    protected String getIdMaterial() {
        return idMaterial;
    }

    protected void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    protected int getCantidad() {
        return cantidad;
    }

    protected void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
