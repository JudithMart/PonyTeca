
import java.util.InputMismatchException;
import java.util.Scanner;

public class Enciclopedia extends Material {

    private String isbn;
    private String volumen;
    private String editorial;
    private int tomo;
    private String tema;

    public Enciclopedia() {
    }

    public String queSoy() {
        return "Enciclopedia";
    }

    public Enciclopedia(String titulo, int numPag, int cantidad, String anoPublicacion, String idMaterial,
            String isbn, String volumen, String editorial, int tomo, String tema, boolean disponible) {

        super(titulo, numPag, cantidad, anoPublicacion, idMaterial, disponible);
        this.isbn = isbn;
        this.volumen = volumen;
        this.editorial = editorial;
        this.tomo = tomo;
        this.tema = tema;

    }

    public void capturar() {
        boolean continuarCiclo = true;
        do {
            try {
                System.out.println("");
                Scanner leer = new Scanner(System.in);
                System.out.print("----------Captura Datos De Enciclopedia----------");
                System.out.println("");
                super.capturar();
                System.out.print("ISBN             :  ");
                isbn = leer.nextLine();
                System.out.print("Volumen          :  ");
                volumen = leer.nextLine();
                System.out.print("Editorial        :  ");
                editorial = leer.nextLine();
                System.out.print("Tomo             :  ");
                tomo = leer.nextInt();
                leer.nextLine();
                System.out.print("Tema             :  ");
                tema = leer.nextLine();
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
        System.out.println("");
        System.out.println("----------Datos de Enciclopedia----------");
        System.out.println("");
        super.mostrar();
        System.out.println("ISBN                :   " + isbn);
        System.out.println("Volumen             :   " + volumen);
        System.out.println("Editorial           :   " + editorial);
        System.out.println("Tomo                :   " + tomo);
        System.out.println("Tema                :   " + tema);
        System.out.println("");
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getTomo() {
        return tomo;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

}
