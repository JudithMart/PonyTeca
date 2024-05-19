
import java.util.Scanner;

public class Revista extends Material {

    private String tipo;
    private String issn;
    private String editorial;

    public Revista() {

    }

    public String queSoy() {
        return "Revista";
    }

    public Revista(String titulo, int numPag, int cantidad, String anoPublicacion, String idMaterial,
            String tipo, String issn, String editorial, boolean disponible) {

        super(titulo, numPag, cantidad, anoPublicacion, idMaterial, disponible);
        this.tipo = tipo;
        this.issn = issn;
        this.editorial = editorial;

    }

    public void capturar() {

        System.out.println("");
        Scanner leer = new Scanner(System.in);
        System.out.print("----------Captura De Datos De Revista----------");
        System.out.println("");
        super.capturar();
        System.out.print("Tipo                  :  ");
        tipo = leer.nextLine();
        System.out.print("ISSN                  :  ");
        issn = leer.nextLine();
        System.out.print("Editorial             :  ");
        editorial = leer.nextLine();

    }

    public void mostrar() {

        System.out.println("");
        System.out.println("----------Datos de Revista----------");
        System.out.println("");
        super.mostrar();
        System.out.println("Tipo                :   " + tipo);
        System.out.println("ISSN                :   " + issn);
        System.out.println("Editorial           :   " + editorial);
        System.out.println("");

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
