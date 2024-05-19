
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class Inventario implements Basica {

    private String idMaterial;
    private String fechaRecepcion;
    private int cProductos = 0, cPrestados = 0;
    private boolean comprobador = false;
    private String titulo;
    private int cantidad;
    private String anoPublicacion;
    private int contador = 0;
    private int cNombres = 0;
     private Prestamo prest = new Prestamo();
    private Material productos[] = new Material[1000];
    private Material prestados[] = new Material[1000];
    private Persona personas[] = new Persona[1000];

    public Inventario(String idMaterial, String fechaRecepcion) {
        this.idMaterial = idMaterial;
        this.fechaRecepcion = fechaRecepcion;
    }

    public Inventario() {

    }

    public void agregar() {
        productos[cProductos] = new Material();
        productos[cProductos].setDisponible(true);
        productos[cProductos].setTitulo(titulo);
        productos[cProductos].setAnoPublicacion(anoPublicacion);
        productos[cProductos].setIdMaterial(idMaterial);

        for (int i = cProductos; i < cProductos + cantidad; i++) {
            contador++;
            productos[i] = new Material();
            productos[i].setTitulo(titulo);
            productos[i].setAnoPublicacion(anoPublicacion);
            productos[i].setIdMaterial(idMaterial + "-" + contador);
            productos[i].setDisponible(true);
            System.out.println(productos[i].getIdMaterial());

        }
        cProductos = cProductos + cantidad;
    }

    public void guardarMaterial() {
        FileOutputStream fs = null; //guardar en el archivo 
        ObjectOutputStream obj = null;
        try {
            fs = new FileOutputStream("Inventario.dat");//asociarlo a un archivo
            obj = new ObjectOutputStream(fs);  //clase para guardar los objetos
            for (int i = 0; i < cProductos; i++) {
                if (productos[i].queSoy().equals("Material")) {
                    obj.writeObject(productos[i]);//vaciar datos
                }
            }
        } catch (Exception e) {
            System.out.println("Datos guardados");
        }
    }

    public void cargarDatosP() {
        FileInputStream fe = null;
        ObjectInputStream obj = null;
        cProductos = 0;
        try {
            fe = new FileInputStream("Inventario.dat");
            obj = new ObjectInputStream(fe);
            productos[cProductos] = (Material) obj.readObject();
            while (productos[cProductos] != null) {
                cProductos++;
                productos[cProductos] = (Material) obj.readObject();
            }
        } catch (Exception e) {
            System.out.println("Datos cargados");
        }

    }

    public boolean prestar(String idPrestamo, int cantidad1) {

        for (int i = 0; i < cProductos; i++) {
            if (productos[i].getIdMaterial().equals(idPrestamo)) {

                if (productos[i].getDisponible() == true) {
                    prestados[cPrestados] = new Material(productos[i].getTitulo(), productos[i].getNumPag(), productos[i].getCantidad(),
                            productos[i].getAnoPublicacion(), productos[i].getIdMaterial(), false);
                    titulo = productos[i].getTitulo();
                    System.out.println("\nMaterial: " + titulo + "\n");
                    productos[i].setDisponible(false);
                    comprobador = true;
                    return true;
                } else {
                    return false;
                }
            }
            comprobador = false;
        }
        if (comprobador == false) {
            System.out.println("No existe");
        }
        return false;

    }

    
	
    public boolean devolver(String idPrestamo, int cantidad1) {
        boolean led = false;
        for (int i = 0; i < cProductos; i++) {
            if (productos[i].getIdMaterial().equals(idPrestamo)) {
                if (productos[i].getDisponible() == false) {
                    prestados[cPrestados] = new Material("NULL", 0, 0, "Null", "Null", true);
                    productos[i].setDisponible(true);
                    titulo = productos[i].getTitulo();
                    System.out.println("Nombre del material    :" + titulo);
                    led = true;
                    break;
                } else {
                    comprobador = false;
                }
            }
        }
        if (led == false) {
            System.out.println("Prestamo no existente\n");
        }
        return led;
    }

    public void mostrar() {
    }

    public void capturar() {
    }

    @Override
    public String queSoy() {
        return "Inventario";
    }

    public boolean getComprobador() {
        return comprobador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setAnoPublicacion(String anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Material[] getProductos() {
        return productos;
    }

    public void setProductos(Material[] productos) {
        this.productos = productos;
    }

    public Material[] getPrestados() {
        return prestados;
    }

    public void setPrestados(Material[] prestados) {
        this.prestados = prestados;
    }
}
