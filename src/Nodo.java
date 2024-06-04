import java.util.Scanner;

public class Nodo {
	String dni; // Dato a guardar.
	String nombre; // Nombre
	String apellido; // Apellido
	String direccion; // Direccion
	String email;
	String celular;
	Nodo nodoSig; // Nodo siguiente.
	Scanner scan = new Scanner(System.in);

	/**
	 * Instanciar un nodo sin valores.
	 */
	public Nodo(){}

	/**
	 * Instanciar un nodo solo con su dato.
	 * @param d Dato a guardar.
	 */
	public Nodo(String d) {
		dni= d;
		System.out.println("Cual es su nombre?");
		nombre = scan.nextLine();
		System.out.println("Cual es su apellido?");
		apellido = scan.nextLine();
		System.out.println("Cual es su direccion?");
		direccion = scan.nextLine();
		System.out.println("Cual es su correo?");
		email = scan.nextLine();
		System.out.println("Cual es su celular?");
		celular = scan.nextLine();
		nodoSig= null;
	}
	

	public Nodo(String dni, String nombre, String apellido, String direccion, String email, String celular) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Nodo{" +
				"dato=" + dni +
				", nodoSig=" + nodoSig +
				'}';
	}
}
