
import java.util.Scanner;

public class Tesis extends Material {

    private String area;
    private String autor;

    public Tesis() {

    }

    public String queSoy() {
        return "Tesis";
    }

    public Tesis(String titulo, int numPag, int cantidad, String anoPublicacion, String idMaterial,
            String area, String autor, boolean disponible) {

        super(titulo, numPag, cantidad, anoPublicacion, idMaterial, disponible);
        this.area = area;
        this.autor = autor;

    }

    public void capturar() {

        System.out.println("");
        Scanner leer = new Scanner(System.in);
        System.out.print("----------Captura Datos De Tesis----------");
        System.out.println("");
        super.capturar();
        System.out.print("Area                  :  ");
        area = leer.nextLine();
        System.out.print("Autor                 :  ");
        autor = leer.nextLine();

    }

    public void mostrar() {

        System.out.println("");
        System.out.println("----------Datos de Tesis----------");
        System.out.println("");
        super.mostrar();
        System.out.println("Area                :   " + area);
        System.out.println("Autor               :   " + autor);
        System.out.println("");

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
