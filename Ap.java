
import java.util.Scanner;

public class Ap {

    private static String cadena;

    public static void main(String[] args) {
        PonyTeca biblioteca = new PonyTeca("BibliotecaMx@Hotmail.edu", "443322131", "ww.ponyteca.com", "Morelia");
        int opcion;
        int opcion2;
        Scanner lee = new Scanner(System.in);
        do {
            opcion2 = mostrarMenu();
            switch (opcion2) {
                case 111:
                    biblioteca.mostrarEnciclopedias();
                    break;
                case 112:
                    biblioteca.capturarEnciclopedia();
                    break;
                case 113:
                    System.out.println("------ Introduce la Enciclopedia que deseas buscar ------");
                    biblioteca.mostrarEnciclopedias(lee.nextLine());
                    break;
                case 121:
                    biblioteca.mostrarRevistas();
                    break;
                case 122:
                    biblioteca.capturarRevista();
                    break;
                case 123:
                    System.out.println("------ Introduce la Revista que deseas buscar ------");
                    biblioteca.mostrarRevistas(lee.nextLine());
                    break;
                case 131:
                    biblioteca.mostrarLibros();
                    break;
                case 132:
                    biblioteca.capturarLibro();
                    break;
                case 133:
                    System.out.println("------ Introduce el Libro que deseas buscar ------");
                    biblioteca.mostrarLibros(lee.nextLine());
                    break;
                case 141:
                    biblioteca.mostrarTesis();
                    break;
                case 142:
                    biblioteca.capturarTesis();
                    break;
                case 143:
                    System.out.println("------ Introduce la Tesis que deseas buscar ------");
                    biblioteca.mostrarTesis(lee.nextLine());
                    break;
                case 211:
                    biblioteca.mostrarProveedores();
                    break;
                case 212:
                    biblioteca.capturarProveerdor();
                    break;
                case 213:
                    System.out.println("------ Introduce el proveedor que deseas buscar ------");
                    biblioteca.mostrarProveedores(lee.nextLine());
                    break;
                case 221:
                    biblioteca.mostrarAlumnos();
                    break;
                case 222:
                    biblioteca.capturarAlumno();
                    break;
                case 223:
                    System.out.println("------ Introduce el alumno que deseas buscar ------");
                    biblioteca.mostrarAlumnos(lee.nextLine());
                    break;
                case 311:
                    biblioteca.mostrarCompras();
                    break;
                case 312:
                    biblioteca.capturarCompra();
                    break;
                case 313:
                    System.out.println("------ Introduce la compra que deseas buscar ------");
                    biblioteca.mostrarCompras(lee.nextLine());
                    break;
                case 321:
                    biblioteca.mostrarDevoluciones();
                    break;
                case 322:
                    biblioteca.capturarDevolucion();
                    break;
                case 323:
                    System.out.println("------ Introduce la devolucion que deseas buscar ------");
                    biblioteca.mostrarDevoluciones(lee.nextLine());
                    break;

                case 331:
                    biblioteca.mostrarPrestamos();
                    break;
                case 332:
                    biblioteca.capturarPrestamo();
                    break;
                case 333:
                    System.out.println("------ Introduce el prestamo que deseas buscar ------");
                    biblioteca.mostrarPrestamos(lee.nextLine());
                    break;
            }
        } while (opcion2 != 0);
        biblioteca.guardarDatosP();
        biblioteca.guardarDatosA();
        biblioteca.guardarDatosL();
        biblioteca.guardarDatosE();
        biblioteca.guardarDatosR();
        biblioteca.guardarDatosT();
        biblioteca.guardarDatosD();
        biblioteca.guardarDatosPr();
        biblioteca.guardarDatosC();
        biblioteca.material.guardarMaterial();
    }

    public static int mostrarMenu() {
        Scanner leer = new Scanner(System.in);
        System.out.println("--------      BIENVENIDO A TU PONYTECA       ------");
        System.out.println("");
        System.out.print("1.MATERIAL    2.USUARIOS     3.SERVICIOS    0.SALIR");
        int opcion2 = leer.nextInt() * 100;

        switch (opcion2) {
            case 100:
                System.out.println("1.Enciclopedias   2.Revistas   3.Libros   4.Tesis   0.Salir");
                opcion2 = opcion2 + leer.nextInt() * 10;

                if (opcion2 == 0) {
                    return 0;
                }
                System.out.println("----- ¿Que desea hacer? -----");
                System.out.println("");
                System.out.println("1.Mostrar    2.Agregar    3.Buscar   0.Salir");
                opcion2 = opcion2 + leer.nextInt();

                break;

            case 200:
                System.out.println("1.Proveedores    2.Alumnos   0.Salir");
                opcion2 = opcion2 + leer.nextInt() * 10;

                if (opcion2 == 0) {
                    return 0;
                }
                System.out.println("----- ¿Que desea hacer? -----");
                System.out.println("");
                System.out.println("1.Mostrar    2.Agregar    3.Buscar   0.Salir");
                opcion2 = opcion2 + leer.nextInt();
                break;

            case 300:
                System.out.println("1.Compras    2.Devolucion    3.Prestamo    0.Salir");
                opcion2 = opcion2 + leer.nextInt() * 10;
                if (opcion2 == 0) {
                    return 0;
                }
                System.out.println("----- ¿Que desea hacer? -----");
                System.out.println("");
                System.out.println("1.Mostrar    2.Agregar    3.Buscar   0.Salir");
                opcion2 = opcion2 + leer.nextInt();
                break;
        }
        return opcion2;

    }

}
