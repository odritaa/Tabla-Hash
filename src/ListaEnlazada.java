import java.util.Scanner;

public class ListaEnlazada {
	/*
		Atributos
	 */
	Scanner scanner= new Scanner(System.in);
	protected Nodo inicio,fin; //punteros para saber donde este el inicio y el fin
	int cont = 0; // Contador que indica el numero de elementos.
	/*
		Metodos
	 */
	public ListaEnlazada() {
		inicio= null;
		fin= null;
	}
	/**
	 * Hardcodeo del codigo
	 * @param dni Se usa como clave.
	 */
	public void hardcodear(String dni, String nombre, String apellido, String direccion, String email, String celular) {
		if (noRepeat(dni)) {
			if (!estaVacia()) { // Si la lista no esta vacia continua.
				fin.nodoSig= new Nodo(dni, nombre, apellido, direccion, email, celular);  // El fin previo ahora apunta a nuestro nuevo nodo.
				fin= fin.nodoSig; // Nuestro nodo es el nodo final.
			}
			else {
				inicio = fin = new Nodo(dni, nombre, apellido, direccion, email, celular); // Si la lista esta vacia inicio = fin.
			}
			cont++; // Se incrementa el contador.
		   }
		else {System.out.println("EL ELEMENTO QUE DESEA INGRESAR YA ESTA EN LA LISTA.");}
	}
    
    /**
	 * Metodo para insertar al final de la lista
	 * @param elemento Dato almacenado en el nodo.
	 */
	public void insertar(String elemento) {
		if (noRepeat(elemento)) {
			if (!estaVacia()) { // Si la lista no esta vacia continua.
				fin.nodoSig= new Nodo(elemento);  // El fin previo ahora apunta a nuestro nuevo nodo.
				fin= fin.nodoSig; // Nuestro nodo es el nodo final.
			}
			else {
				inicio = fin = new Nodo(elemento); // Si la lista esta vacia inicio = fin.
			}
			cont++; // Se incrementa el contador.
		   }
		else {System.out.println("EL ELEMENTO QUE DESEA INGRESAR YA ESTA EN LA LISTA.");}
	}
	 
	/**
	 * Metodo para insertar al final de la lista
	 * @param elemento Dato almacenado en el nodo.
	 */
	public void insertar(String dni, String nombre, String apellido, String direccion, String mail, String celular) {
		if (noRepeat(dni)) {
			if (!estaVacia()) { // Si la lista no esta vacia continua.
				fin.nodoSig = new Nodo(dni,nombre,apellido,direccion,mail,celular);  // El fin previo ahora apunta a nuestro nuevo nodo.
				fin= fin.nodoSig; // Nuestro nodo es el nodo final.
			}
			else {
				inicio = fin = new Nodo(dni,nombre,apellido,direccion,mail,celular); // Si la lista esta vacia inicio = fin.
			}
			cont++; // Se incrementa el contador.
		   }
		else {System.out.println("EL ELEMENTO QUE DESEA INGRESAR YA ESTA EN LA LISTA.");}
	}

	/**
	 * METODO PARA VER SI UN ELEMENTO YA ESTA EN LA LISTA
	 * @param x
	 * @return False = Elemento ya esta en la lista. True = Elemento no esta en la lista.
	 */
	public boolean noRepeat(String x) {
		
		Nodo recorrer= inicio;   // El recorrer empieza en el inicio de la lista.
		while(recorrer != null) {  // mientras recorrer no este vacio
			if(recorrer.dni.equalsIgnoreCase(x)) {
			   return false;
			}
			recorrer= recorrer.nodoSig; // recorrer pasa a nodo siguiente y repite hasta que este vacio
		}
		return true;
	}
	
	/**
	 * Muestra la lista.
	 */
	public void mostrarListaNod() {
		Nodo recorrer= inicio;   // El recorrer empieza en el inicio de la lista.
		while(recorrer != null) {  // mientras recorrer no este vacio
			if (recorrer.nodoSig == null){ // Si el nodo siguiente de recorrer es null. Este es el final.
				System.out.println(recorrer.dni);
			} else{ // En caso contrario sigue a otro nodo.
				System.out.print(recorrer.dni + " ---> ");
			}
			recorrer= recorrer.nodoSig; // recorrer pasa a nodo siguiente y repite hasta que este vacio
		}
	}

	/**
	 * metodo para saber si la lista esta  vacia
	 * @return Vacia = True. noVacia = False.
	 */
	 public boolean estaVacia(){
		 return inicio == null;
	}

	/**
	 * Metodo para vaciar la lista.
	 */
	public void vaciar(){
		inicio = null; // Para vaciarla ni inicio ni fin son nodos.
		fin = null;
		cont = 0; // Y como no hay elementos el cont es 0.
	}
	
    /**
	 * Metodo para eliminar un elemento especifico.
	 * @param elemento Dato que se busca.
	 */
	public void eliminar(String elemento) {
		if (!estaVacia()) { // si la lista no esta vacia
			if (inicio== fin && elemento.equalsIgnoreCase(inicio.dni)) { // si nodo inicio es igual a nodo fin y el elemento es igual al dato de nodo incio ya lo encontre y se borra
				inicio= null;
				fin= null;
				cont = 0;
			}
			else if (elemento == inicio.dni) {  // si el elemento esta en el dato del primer nodo ya lo encontramos
				inicio= inicio.nodoSig; // inicio toda el valor del nodo siguiente
				cont--;
			}
			else {
				Nodo anterior,temporal;
				anterior= inicio; // el anterior apunta al inicio
				temporal= inicio.nodoSig; // el temporal apunta al nodo siguiente

				while(temporal!= null && !temporal.dni.equalsIgnoreCase(elemento)) { // mientras el temporal no sea nulo y temporal de dato no sea el elemento que buscamos
					anterior = anterior.nodoSig; // anterior va a ser el nodo siguiente
					temporal= temporal.nodoSig; // y temporal tambien va a ser el nodo siguiente
     			}
				if (temporal != null) {  //si el temporal no es nulo es porque se encontro el elemento
					anterior.nodoSig= temporal.nodoSig;  // el anterior de siguiente es igual al temporal de siguiente
					if(temporal== fin) {  // si el temporal es igual al nodo fin
						fin= anterior; // el anterior es el elemento a eliminar
					}
					cont--; // Disminuye el contador.
				}
			}
		}
	}

	/**
	 * Metodo para buscar un elemento especifico.
	 * @param elemento2 Elemento que se busca
	 * @return Devuelve el nodo.
	 */
	public Nodo find(String elemento2) {
		Nodo temporal = inicio; // el nodo temporal es el inicio de la lista para recorrer la lista
		while(temporal != null && !temporal.dni.equalsIgnoreCase(elemento2)) { // si el temporal es diferente de null y el dato del nodo temporal es diferente del elemeento que se busca
			temporal = temporal.nodoSig;// entonces temporal pasa a ser el siguiente nodo
		}
		return temporal; // retorna temporal.
	}
	
}
	



