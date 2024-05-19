
import java.util.Scanner;

public class Libro extends Material {

    private String isbn;
    private String genero;
    private String editorial;
    private String autor;

    public Libro() {

    }

    public String queSoy() {
        return "Libro";
    }

    public Libro(String titulo, int numPag, int cantidad, String anoPublicacion, String idMaterial,
            String isbn, String genero, String editorial, String autor, boolean disponible) {

        super(titulo, numPag, cantidad, anoPublicacion, idMaterial, disponible);
        this.isbn = isbn;
        this.genero = genero;
        this.editorial = editorial;
        this.autor = autor;
    }

    public void capturar() {

        System.out.println("");
        Scanner leer = new Scanner(System.in);
        System.out.print("----------Captura Datos De Libro----------");
        System.out.println("");
        super.capturar();
        System.out.print("ISBN                  :  ");
        isbn = leer.nextLine();
        System.out.print("Genero                :  ");
        genero = leer.nextLine();
        System.out.print("Editorial             :  ");
        editorial = leer.nextLine();
        System.out.print("Autor                 :  ");
        autor = autor = leer.nextLine();

    }

    public void mostrar() {
        System.out.println("");
        System.out.println("----------Datos de Libro----------");
        System.out.println("");
        super.mostrar();
        System.out.println("ISBN                :  " + isbn);
        System.out.println("Genero              :  " + genero);
        System.out.println("Editorial           :  " + editorial);
        System.out.println("Autor               :  " + autor);
        System.out.println("");

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
