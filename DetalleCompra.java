
import java.util.InputMismatchException;
import java.util.Scanner;

public class DetalleCompra {

    private int cantidad;
    private float precio;
    private String idMaterial;

    public DetalleCompra(int cantidad, float precio, String idMaterial) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.idMaterial = idMaterial;
    }

    public DetalleCompra() {

    }

    public void capturar() {
        boolean continuarCiclo = true;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Cantidad     : ");
                cantidad = sc.nextInt();
                System.out.print("Precio       : ");
                precio = sc.nextFloat();
                System.out.print("Id Material  : ");
                idMaterial = sc.nextLine();
                continuarCiclo = false;
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Debes ingresar solamente valores numericos");
                System.out.println("Intentalo de nuevo");
                System.out.println("");
            }
        } while (continuarCiclo);
    }

    public void mostrar() {
        System.out.println("Cantidad     : " + cantidad);
        System.out.println("Precio       : " + precio);
        System.out.println("Id Material  : " + idMaterial);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

}
