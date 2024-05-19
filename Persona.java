import java.util.Scanner;
import java.io.Serializable;
public abstract class Persona implements Basica, Serializable
{
	 protected  String nombre;
	 protected  String telefono;
	 protected  String domicilio;
	 protected  String email;
	 
	
	
	 public Persona() {
	 }
	
     public Persona (String nombre, String telefono, String domicilio, String email){
		this.nombre=nombre;
		this.telefono=telefono;
		this.domicilio=domicilio;
		this.email=email;
	 }
	 
     public abstract String queSoy();
	
      
	 
	 public void mostrar()
	     {
                 
		 System.out.println("Nombre Completo      : "+nombre);
                 System.out.println("Telefono             : "+telefono);		 
		 System.out.println("Domicilio            : "+domicilio);	
	         System.out.println("Email                : "+email);	
	     }
	 
	 
	 public void capturar()
	     {
	    Scanner lee=new Scanner(System.in);
		System.out.println ("");
		System.out.print("Nombre completo     : "); nombre = lee.nextLine();
		System.out.print("Telefono            : "); telefono = lee.nextLine();
		System.out.print("Domicilio           : "); domicilio = lee.nextLine(); 
		System.out.print("Email               : "); email = lee.nextLine();
         }
		

     protected  String getNombre(){
		return nombre;}	
	 protected  void setNombre(String nombre){
		this. nombre=nombre;}
		
	  protected  String getTelefono(){
		return telefono;}	
	 protected  void setTelefono(String telefono){
		this. telefono=telefono;}
		
	 protected  String getDomicilio(){
		return domicilio;}	
	 protected  void setDomicilio(String domicilio){
		this. domicilio=domicilio;}
		
	 protected  String getEmail(){
		return email;}	
	 protected  void setEmail(String email){
		this. email=email;}
}
