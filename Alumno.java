
import java.util.InputMismatchException;
import java.util.Scanner;

public class Alumno extends Persona {

    private String carrera;
    private String numControl;
    private char sexo;

    public Alumno(String nombre, String telefono, String domicilio, String email, String carrera, String numControl, char sexo) {
        super(nombre, telefono, domicilio, email);
        this.carrera = carrera;
        this.numControl = numControl;
        this.sexo = sexo;
    }

    public Alumno() {
    }

    public String queSoy() {
        return "Alumno";
    }

    public void capturar() {
        boolean continuarCiclo = true;
        do {
            try {
                Scanner leer = new Scanner(System.in);
                System.out.print("-------------Captura Datos del Alumno-------------");
                System.out.println("");
                super.capturar();
                System.out.print("Carrera            :  ");
                carrera = leer.nextLine();
                System.out.print("Numero de control  :  ");
                numControl = leer.nextLine();
                System.out.print("Sexo               :  ");
                sexo = leer.nextLine().charAt(0);
                System.out.println("");
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

        System.out.println("-------------Datos del Alumno-------------");
        System.out.println("");
        super.mostrar();
        System.out.println("Carrera              :  " + carrera);
        System.out.println("Numero de control    :  " + nombre);
        System.out.println("Sexo                 :  " + sexo);
        System.out.println("");
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
