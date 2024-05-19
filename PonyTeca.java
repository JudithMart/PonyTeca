
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.util.Scanner;

public class PonyTeca {

    private String email;
    private String telefono;
    private String paginaWeb;
    private String domicilio;

    private Operacion operaciones[] = new Operacion[100];
    private Persona personas[] = new Persona[100];
    private Compra compras[] = new Compra[100];
    private Material materiales[] = new Material[100];
    private Prestamo prestamos[] = new Prestamo[1000];
    private Devolucion devoluciones[] = new Devolucion[1000];
    private int cDevoluciones;
    private Inventario inventario;
    private int cPrestamos;
    private int cMateriales;
    private int cOperaciones;
    private int cPersonas;
    private int cCompras;
    private int cInventarios;
    private int cProveedores;
    private int cAlumnos;
    public Inventario material = new Inventario();

    public PonyTeca(String email, String telefono, String paginaWeb, String domicilio) {
        this.email = email;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.domicilio = domicilio;
        inventario = new Inventario();

        cargarDatosP();
        cargarDatosA();
        cargarDatosL();
        cargarDatosE();
        cargarDatosR();
        cargarDatosT();
        cargarDatosD();
        cargarDatosPr();
        cargarDatosC();
        material.cargarDatosP();
    }

//Material
    public void capturarDevolucion() {
        devoluciones[cDevoluciones] = new Devolucion();
        devoluciones[cDevoluciones].capturar(material);
        boolean led = false;
        for (int i = 0; i < cPrestamos; i++) {
            if (devoluciones[cDevoluciones].getIdPrestamo().equals(prestamos[i].getIdPrestamo())) {
                led = true;
                devoluciones[cDevoluciones].setNombreAlumno(prestamos[i].getNombreAlumno());
                if (devoluciones[cDevoluciones].mostrarDev(material, prestamos[i].getNombreAlumno())) {
                    prestamos[i].setIdPrestamo(" ");
                    prestamos[i].setLed(false);
                }
            }
        }
        if (led == false) {
            System.out.println("Prestamo no existente\n");
        }

        cDevoluciones++;
    }

    public void mostrarEnciclopedias() {
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Enciclopedia")) {
                materiales[i].mostrar();
            }
        }
    }

    public void capturarEnciclopedia() {
        materiales[cMateriales] = new Enciclopedia();
        materiales[cMateriales].capturar();
        cMateriales++;
    }

    public void mostrarEnciclopedias(String cadena) {
        String megaCadena;
        Enciclopedia e;
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Enciclopedia")) {
                e = (Enciclopedia) materiales[i];
            } else {
                continue;
            }

            megaCadena = e.getTitulo() + e.getNumPag() + e.getCantidad() + e.getAnoPublicacion()
                    + e.getIdMaterial() + e.getIsbn() + e.getVolumen() + e.getEditorial() + e.getTomo() + e.getTema();
            if (megaCadena.contains(cadena)) {
                materiales[i].mostrar();
            }
            megaCadena = "";

        }
    }

    public void mostrarLibros() {
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Libro")) {
                materiales[i].mostrar();
            }
        }
    }

    public void capturarLibro() {
        materiales[cMateriales] = new Libro();
        materiales[cMateriales].capturar();
        cMateriales++;
    }

    public void mostrarLibros(String cadena) {
        String megaCadena;
        Libro l;
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Libro")) {
                l = (Libro) materiales[i];
            } else {
                continue;
            }

            megaCadena = l.getTitulo() + l.getNumPag() + l.getCantidad() + l.getAnoPublicacion()
                    + l.getIdMaterial() + l.getIsbn() + l.getGenero() + l.getEditorial() + l.getAutor();
            if (megaCadena.contains(cadena)) {
                materiales[i].mostrar();
            }
            megaCadena = "";
        }
    }

    public void mostrarRevistas() {
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Revista")) {
                materiales[i].mostrar();
            }
        }
    }

    public void capturarRevista() {
        materiales[cMateriales] = new Revista();
        materiales[cMateriales].capturar();
        cMateriales++;
    }

    public void mostrarRevistas(String cadena) {
        String megaCadena;
        Revista r;
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Revista")) {
                r = (Revista) materiales[i];
            } else {
                continue;
            }

            megaCadena = r.getTitulo() + r.getNumPag() + r.getCantidad() + r.getAnoPublicacion()
                    + r.getIdMaterial() + r.getTipo() + r.getIssn() + r.getEditorial();
            if (megaCadena.contains(cadena)) {
                materiales[i].mostrar();
            }
            megaCadena = "";
        }
    }

    public void mostrarTesis() {
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Tesis")) {
                materiales[i].mostrar();
            }
        }
    }

    public void capturarTesis() {
        materiales[cMateriales] = new Tesis();
        materiales[cMateriales].capturar();
        cMateriales++;
    }

    public void mostrarTesis(String cadena) {
        String megaCadena;
        Tesis t;
        for (int i = 0; i < cMateriales; i++) {
            if (materiales[i].queSoy().equals("Tesis")) {
                t = (Tesis) materiales[i];
            } else {
                continue;
            }

            megaCadena = t.getTitulo() + t.getNumPag() + t.getCantidad() + t.getAnoPublicacion()
                    + t.getIdMaterial() + t.getArea() + t.getAutor();
            if (megaCadena.contains(cadena)) {
                materiales[i].mostrar();
            }
            megaCadena = "";
        }
    }

    //PERSONAS/////// 
    public void mostrarAlumnos() {
        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].queSoy().equals("Alumno")) {
                personas[i].mostrar();
            }
        }
    }

    public void capturarAlumno() {
        personas[cPersonas] = new Alumno();
        personas[cPersonas].capturar();
        cPersonas++;
    }

    public void mostrarAlumnos(String cadena) {
        String megaCadena;
        Alumno a;
        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].queSoy().equals("Alumno")) {
                a = (Alumno) personas[i];
            } else {
                continue;
            }

            megaCadena = a.getNombre() + a.getTelefono() + a.getDomicilio() + a.getEmail()
                    + a.getCarrera() + a.getNumControl() + a.getSexo();
            if (megaCadena.contains(cadena)) {
                personas[i].mostrar();
            }
            megaCadena = "";
        }
    }

    public void mostrarProveedores() {
        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].queSoy().equals("Proveedor")) {
                personas[i].mostrar();
            }
        }
    }

    public void capturarProveerdor() {
        personas[cPersonas] = new Proveedor();
        personas[cPersonas].capturar();
        cPersonas++;
    }

    public void mostrarProveedores(String cadena) {
        String megaCadena;
        Proveedor p;
        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].queSoy().equals("Proveedor")) {
                p = (Proveedor) personas[i];
            } else {
                continue;
            }

            megaCadena = p.getNombre() + p.getTelefono() + p.getDomicilio() + p.getEmail()
                    + p.getRfc() + p.getPaginaWeb();
            if (megaCadena.contains(cadena)) {
                personas[i].mostrar();
            }
            megaCadena = "";
        }
    }

    //DETALLES
    public void mostrarDevoluciones() {
        for (int i = 0; i < cDevoluciones; i++) {
            devoluciones[i].mostrar();
        }
    }

    public void mostrarDevoluciones(String cadena) {
        String megaCadena;
        Devolucion d;
        for (int i = 0; i < cDevoluciones; i++) {
            if (operaciones[i].queSoy().equals("Devolucion")) {
                d = (Devolucion) devoluciones[i];
            } else {
                continue;
            }

            megaCadena = d.getNombreMaterial() + d.getIdMaterial() + d.getCantidad() + d.getFechaDevolucion()
                    + d.getNombreAlumno() + d.getIdPrestamo();
            if (megaCadena.contains(cadena)) {
                operaciones[i].mostrar();
            }
            megaCadena = "";
        }
    }

    public void mostrarPrestamos() {
        boolean led5 = false;
        for (int i = 0; i < cPrestamos; i++) {
            if (prestamos[i].getLed() == true) {
                prestamos[i].mostrar();
                led5 = true;
            }
        }
        if (led5 == false) {
            System.out.println("\nNo hay prestamos pendientes\n");
        }
    }

    public void capturarPrestamo() {
        prestamos[cPrestamos] = new Prestamo();
        prestamos[cPrestamos].capturar(material, this);
        cPrestamos++;

    }

    public void mostrarPrestamos(String cadena) {
        String megaCadena;
        Prestamo p;
        for (int i = 0; i < cOperaciones; i++) {
            if (operaciones[i].queSoy().equals("Prestamo")) {
                p = new Prestamo();
            } else {
                continue;
            }

            megaCadena = p.getNombreMaterial() + p.getIdMaterial() + p.getCantidad() + p.getFechaPrestamo()
                    + p.getFechaEntrega() + p.getNombreAlumno() + p.getIdPrestamo();
            if (megaCadena.contains(cadena)) {
                operaciones[i].mostrar();
            }
            megaCadena = "";
        }
    }

    //COMPRA 
    public void mostrarCompras() {
        for (int i = 0; i < cCompras; i++) {
            if (compras[i].queSoy().equals("Compra")) {
                compras[i].mostrar();
            }
        }
    }

    public void capturarCompra() {
        compras[cCompras] = new Compra();
        compras[cCompras].capturar(material, this);
        cCompras++;
    }

    public void mostrarCompras(String cadena) {
        String megaCadena;
        Compra c;
        for (int i = 0; i < cCompras; i++) {
            if (compras[i].queSoy().equals("Compra")) {
                c = (Compra) compras[i];
            } else {
                continue;
            }
            megaCadena = c.getRfc();
            if (megaCadena.contains(cadena)) {
                compras[i].mostrar();
            }
            megaCadena = "";
        }
    }

    // GUARDAR DATOS 
    //persona
    public void guardarDatosP() {
        FileOutputStream fs = null; //guardar en el archivo 
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Proveedor.dat");//asociarlo a un archivo
            obj = new ObjectOutputStream(fs);  //clase para guardar los objetos
            for (int i = 0; i < cPersonas; i++) {
                if (personas[i].queSoy().equals("Proveedor")) {
                    obj.writeObject(personas[i]);//vaciar datos
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }

    public void guardarDatosA() {
        FileOutputStream fs = null; //guardar en el archivo 
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Alumno.dat");//asociarlo a un archivo
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cPersonas; i++) {
                if (personas[i].queSoy().equals("Alumno")) {
                    obj.writeObject(personas[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }
    }

    //MATERIAL
    public void guardarDatosL() {
        FileOutputStream fs = null;
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Libro.dat");
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cMateriales; i++) {
                if (materiales[i].queSoy().equals("Libro")) {
                    obj.writeObject(materiales[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }

    public void guardarDatosE() {
        FileOutputStream fs = null;
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Enciclopedia.dat");
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cMateriales; i++) {
                if (materiales[i].queSoy().equals("Enciclopedia")) {
                    obj.writeObject(materiales[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }

    public void guardarDatosR() {
        FileOutputStream fs = null;
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Revista.dat");
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cMateriales; i++) {
                if (materiales[i].queSoy().equals("Revista")) {
                    obj.writeObject(materiales[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }

    public void guardarDatosT() {
        FileOutputStream fs = null;
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Tesis.dat");
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cMateriales; i++) {
                if (materiales[i].queSoy().equals("Tesis")) {
                    obj.writeObject(materiales[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }

    //DETALLE
    public void guardarDatosD() {
        FileOutputStream fs = null;
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Devolucion.dat");
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cOperaciones; i++) {
                if (operaciones[i].queSoy().equals("Devolucion")) {
                    obj.writeObject(operaciones[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }

    public void guardarDatosPr() {
        FileOutputStream fs = null;
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Prestamo.dat");
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cPrestamos; i++) {
                if (prestamos[i].queSoy().equals("Prestamo")) {
                    obj.writeObject(prestamos[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }
    //Compra

    public void guardarDatosC() {
        FileOutputStream fs = null;
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Compra.dat");
            obj = new ObjectOutputStream(fs);
            for (int i = 0; i < cCompras; i++) {
                if (compras[i].queSoy().equals("Compra")) {
                    obj.writeObject(compras[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }

    }

    //CARGAR DATOS
    //persona
    public void cargarDatosP() {
        FileInputStream fe = null; //asociar un archivo de entrada
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Proveedor.dat");
            obj = new ObjectInputStream(fe);
            personas[cPersonas] = (Proveedor) obj.readObject();//recorrer el archivo---- readObject jala un objeto
            while (personas[cPersonas] != null) {
                cPersonas++;
                personas[cPersonas] = (Proveedor) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }

    }

    public void cargarDatosA() {
        FileInputStream fe = null; //asociar un archivo de entrada
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Alumno.dat");
            obj = new ObjectInputStream(fe);
            personas[cPersonas] = (Alumno) obj.readObject();//recorrer el archivo---- readObject jala un objeto
            while (personas[cPersonas] != null) {
                cPersonas++;
                personas[cPersonas] = (Alumno) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }

    }

    //Material
    public void cargarDatosL() {
        FileInputStream fe = null; //asociar un archivo de entrada
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Libro.dat");
            obj = new ObjectInputStream(fe);
            materiales[cMateriales] = (Libro) obj.readObject();//recorrer el archivo---- readObject jala un objeto
            while (materiales[cMateriales] != null) {
                cMateriales++;
                materiales[cMateriales] = (Libro) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }

    }

    public void cargarDatosE() {
        FileInputStream fe = null;
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Enciclopedia.dat");
            obj = new ObjectInputStream(fe);
            materiales[cMateriales] = (Enciclopedia) obj.readObject();
            while (materiales[cMateriales] != null) {
                cMateriales++;
                materiales[cMateriales] = (Enciclopedia) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }
    }

    public void cargarDatosR() {
        FileInputStream fe = null;
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Revista.dat");
            obj = new ObjectInputStream(fe);
            materiales[cMateriales] = (Revista) obj.readObject();
            while (materiales[cMateriales] != null) {
                cMateriales++;
                materiales[cMateriales] = (Revista) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }
    }

    public void cargarDatosT() {
        FileInputStream fe = null;
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Tesis.dat");
            obj = new ObjectInputStream(fe);
            materiales[cMateriales] = (Tesis) obj.readObject();
            while (materiales[cMateriales] != null) {
                cMateriales++;
                materiales[cMateriales] = (Tesis) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }
    }

    //	Operacion
    public void cargarDatosD() {
        FileInputStream fe = null;
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Devolucion.dat");
            obj = new ObjectInputStream(fe);
            devoluciones[cDevoluciones] = (Devolucion) obj.readObject();
            while (devoluciones[cDevoluciones] != null) {
                cDevoluciones++;
                devoluciones[cDevoluciones] = (Devolucion) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }
    }

    public void cargarDatosPr() {
        FileInputStream fe = null;
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Prestamo.dat");
            obj = new ObjectInputStream(fe);
            prestamos[cPrestamos] = (Prestamo) obj.readObject();
            while (prestamos[cPrestamos] != null) {
                cPrestamos++;
                prestamos[cPrestamos] = (Prestamo) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }
    }

    //COMPRA
    public void cargarDatosC() {
        FileInputStream fe = null;
        ObjectInputStream obj = null;

        try {
            fe = new FileInputStream("Compra.dat");
            obj = new ObjectInputStream(fe);
            compras[cCompras] = (Compra) obj.readObject();
            while (compras[cCompras] != null) {
                cCompras++;
                compras[cCompras] = (Compra) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }
    }

    //VERIFICAR NOMBRES 
    public boolean verificarN(String nombre) {

        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarP(String rfcP) {
        Proveedor p;
        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].queSoy().equals("Proveedor")) {
                p = (Proveedor) personas[i];
                if (p.getRfc().equals(rfcP)) {
                    return true;
                }
            }
        }
        return false;
    }

}
