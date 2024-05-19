
import java.util.Scanner;

public class Proveedor extends Persona {

    private String rfc;
    private String paginaWeb;

    public Proveedor(String nombre, String telefono, String domicilio, String email, String rfc, String paginaWeb) {
        super(nombre, telefono, domicilio, email);
        this.rfc = rfc;
        this.paginaWeb = paginaWeb;
    }

    public Proveedor() {
    }

    public String queSoy() {
        return "Proveedor";
    }

    public void capturar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Captura datos del proveedor ----------");
        super.capturar();
        System.out.print("RFC                 : ");
        rfc = sc.nextLine();
        System.out.print("Pagina web          : ");
        paginaWeb = sc.nextLine();
        System.out.println("");
    }

    public void mostrar() {
        System.out.println("----------Datos del proveedor ----------");
        super.mostrar();
        System.out.println("RFC                  : " + rfc);
        System.out.println("Pagina Web           : " + paginaWeb);
        System.out.println("");
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc() {
        this.rfc = rfc;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb() {
        this.paginaWeb = paginaWeb;
    }
}
