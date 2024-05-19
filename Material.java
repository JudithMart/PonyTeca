
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

public class Material implements Basica, Serializable {

    protected String titulo;
    protected int numPag;
    protected int cantidad;
    protected String anoPublicacion;
    protected boolean disponible;
    protected String idMaterial;

    public Material() {
    }

    public String queSoy() {
        return "Material";
    }

    public Material(String titulo, int numPag, int cantidad, String anoPublicacion, String idMaterial, boolean disponible) {
        this.titulo = titulo;
        this.numPag = numPag;
        this.cantidad = cantidad;
        this.anoPublicacion = anoPublicacion;
        this.idMaterial = idMaterial;
        this.disponible = disponible;
    }

    public void capturar() {
        boolean continuarCiclo = true;
        do {
            try {
                Scanner leer = new Scanner(System.in);
                System.out.print("Titulo                :  ");
                titulo = leer.nextLine();
                System.out.print("Numero de paginas     :  ");
                numPag = leer.nextInt();
               /* System.out.print("Cantidad              :  ");
                cantidad = leer.nextInt();*/
                leer.nextLine();
                System.out.print("Ano de Publicacion    :  ");
                anoPublicacion = leer.nextLine();
                System.out.print("Id del material       :  ");
                idMaterial = leer.nextLine();
                System.out.print("Esta disponible       :  ");
                disponible = leer.nextBoolean();

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
        System.out.println("Titulo               :   " + titulo);
        System.out.println("Numero de paginas    :   " + numPag);
        //System.out.println("Cantidad             :   " + cantidad);
        System.out.println("Ano de Publicacion   :   " + anoPublicacion);
        System.out.println("Id del material      :   " + idMaterial);
        System.out.println("Esta disponible      :   " + disponible);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(String anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

}
