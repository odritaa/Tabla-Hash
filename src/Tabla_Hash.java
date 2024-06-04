import java.util.Scanner;

public class Tabla_Hash {
    /*
     * ATRIBUTOS
     */
    
    ListaEnlazada[] listaHash;
    Nodo[] original;
    Scanner scan = new Scanner(System.in);
    
    /*
     * METODOS
     */

    /*
     * Constructor.
     */
    public Tabla_Hash(){
        // Se instancia la lista original.
        original = new Nodo[10];
        // Se rellena de nulos.
        for (int i = 0; i < original.length; i++){
            original[i] = null;
        }
        // Se crea la lista Hash con 10 espacios.
        listaHash = new ListaEnlazada[10];
        // Se rellena con listas vacias.
        for (int i = 0; i < listaHash.length; i++){
            listaHash[i] = new ListaEnlazada();
        }
    }
    
    /**
     * Metodo de hasheo con el que se estima la posicion en base al dato.
     * @param d Dato.
     * @return Devuelve el resto dividido el largo de la lista.
     */
    public int hash1(String d){
        return Integer.parseInt(d) % listaHash.length;
    }
    
    /**
     * Indica si la listaHash estara llena o vacia.
     * @return True = Llena. False = No llena.
     */
    public boolean llena(){
        boolean est = true;
        // Busca encontrar un espacio vacio.
        for(int i = 0; i < listaHash.length; i++){
            if(listaHash[i].estaVacia()){
                est = false;
            }
        }
        return est;
    }
    public void destruir(){
        // Se instancia la lista original.
        original = new Nodo[10];
        // Se rellena de nulos.
        for (int i = 0; i < original.length; i++){
            original[i] = null;
        }
        // Se crea la lista Hash con 10 espacios.
        listaHash = new ListaEnlazada[10];
        // Se rellena con listas vacias.
        for (int i = 0; i < listaHash.length; i++){
            listaHash[i] = new ListaEnlazada();
        }
        System.out.println("Se eliminaron todos los usuarios exitosamente.");
    }
    /**
     * Inserta un dato.
     */
    public void hardcodear(String dni, String nombre, String apellido, String direccion, String email, String celular){
        // Se usa el metodo hash para asignar un indice/posicion.
        int pos = hash1(dni);
        // Para guardarlo en la tabla Hash.
        if(!llena()){
            // Se intenta guardar el dato en alguna de las listas si estas se encuentran vacias.
            // Si la lista o alguna de las posteriores esta vacia se inserta en ella sin problema.
            guardarHardcodeo(pos, dni, nombre, apellido, direccion, email, celular);
        } else{
            // En el caso contrario se insertara en la lista de su indice.
            listaHash[pos].hardcodear(dni, nombre, apellido, direccion, email, celular);
        }

        // Se revisara que haya espacio en la lista original.
        boolean es = false;
        for (int i = 0; i < original.length; i++){
            if(original[i] == null){
                es = true;
                break;
            }
        }
        // Si la lista no tiene espacio se ampliara creando una temporal y luego copiandola.
        if(!es){
            Nodo[] temp = new Nodo[original.length*2];
            // Se ingresan los datos en la temporal.
            for(int i = 0; i < original.length; i++){
                temp[i] = original[i];
            }
            // Se reemplazan los vectores.
            original = temp;
        }
        // Para guardarlo en la tabla original.
        for(int i = 0; i < original.length; i++){
            if(original[i] == null){
                original[i] = new Nodo(dni, nombre, apellido, direccion, email, celular);
                break;
            }
        }
        
    }

    /**
     * Inserta un dato.
     */
    public void insertar(){
        // Se le pregunta al usuario que dato ingresar.
        System.out.println("Ingrese el DNI del usuario:");
        String x = scan.nextLine();
        // Se usa el metodo hash para asignar un indice/posicion.
        int pos = hash1(x);
        // Para guardarlo en la tabla Hash.
        if(!llena()){
            // Se intenta guardar el dato en alguna de las listas si estas se encuentran vacias.
            // Si la lista o alguna de las posteriores esta vacia se inserta en ella sin problema.
            guardar(pos,x);
        } else{
            // En el caso contrario se insertara en la lista de su indice.
            listaHash[pos].insertar(x);
            System.out.println("Se inserto el usuario en una lista.");
        }

        // Se revisara que haya espacio en la lista original.
        boolean es = false;
        for (int i = 0; i < original.length; i++){
            if(original[i] == null){
                es = true;
                break;
            }
        }
        // Si la lista no tiene espacio se ampliara creando una temporal y luego copiandola.
        if(!es){
            Nodo[] temp = new Nodo[original.length*2];
            // Se ingresan los datos en la temporal.
            for(int i = 0; i < original.length; i++){
                temp[i] = original[i];
            }
            // Se reemplazan los vectores.
            original = temp;
        }
        // Para guardarlo en la tabla original.
        for(int i = 0; i < original.length; i++){
            if(original[i] == null){
                Nodo f = listaHash[pos].find(x);
                original[i] = f;
                break;
            }
        }
        
    }

    /**
     * Metodo que guardara el dato en la lista si se encuentra vacia, en el caso contrario examina la siguiente lista.
     * @param pos Posicion/Index
     * @param x Dato
     * @return Devuelve un booleano que confirma si se guardo o no.
     */
    public void guardar(int pos, String x){
        // Si la lista no es nula y la posicion es menor al tamaño chequea.
        for(int i = pos; i < listaHash.length; i++){
            if(listaHash[i].estaVacia()){
                listaHash[i].insertar(x);
                return;
            }
        }
        // Se recorren las posiciones previas a esta.
        for(int i = 0; i < pos; i++){
            if(listaHash[i].estaVacia()){
                listaHash[i].insertar(x);
                return;
            }
        }
    }
    /**
     * Que facilita el hardcodeo.
     * @param pos Posicion/Index
     * @param x Dato
     * @return Devuelve un booleano que confirma si se guardo o no.
     */
    public void guardarHardcodeo(int pos, String dni, String nombre, String apellido, String direccion, String email, String celular){
        // Si la lista no es nula y la posicion es menor al tamaño chequea.
        for(int i = pos; i < listaHash.length; i++){
            if(listaHash[i].estaVacia()){
                listaHash[i].insertar(dni, nombre, apellido, direccion, email, celular);
                return;
            }
        }
        // Se recorren las posiciones previas a esta.
        for(int i = 0; i < pos; i++){
            if(listaHash[i].estaVacia()){
                listaHash[i].insertar(dni, nombre, apellido, direccion, email, celular);
                return;
            }
        }
    }

    /**
     * Encontrar si un nodo esta repetido.
     * @param d Dato que se buscara.
     * @return Dice si ya se encuentra o no.
     */
    public boolean repit(String d){
        // Va a ir revisando todas las posiciones.
        for(int i = 0; i < listaHash.length; i++){
            // Si encuentra el nodo con ese dato devuelve true.
            if(listaHash[i].find(d) != null){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para eliminar un nodo guardado.
     * @param d Clave del nodo.
     */
    public void eliminar(String d){
        for(int i = 0; i < listaHash.length; i++){
            if(!listaHash[i].estaVacia()){
                // Si encuentra el dato lo eliminara.
                if(listaHash[i].find(d) != null){
                    // Elimina el nodo con el dato.
                    listaHash[i].eliminar(d);
                    int y = 0;
                    // Tambien hay que eliminarlo de la lista original y correrlo.
                    for(int j = 0; j < original.length; j++){
                        // Si el dni es igual al que ingresaron.
                        if(original[j].dni.equalsIgnoreCase(d) && original[j] != null){
                            y = j;
                            break;
                        }
                    }
                    for(int j = y; j < original.length; j++){
                        // Se verifica que posicion esta por reemplazarse.
                            if(j == original.length-1){
                                // Si j esta en la ultima posicion se volvera null.
                                original[j] = null;
                            } else{
                                // De otra forma se reemplaza con el que tiene en frente.
                                original[j] = original[j+1];
                            }
                    }
                    System.out.println("Eliminado!");
                    return;
                }
            }
        }
        System.out.println("No existia ese usuario.");
    }
    /**
     * Imprime la tabla Hash
     */
    public void printHash(){
        // Primero se imprimen las columnas
        System.out.println("\n");
        String s = "    |    " + "DNI" + "   |    " + "NOMBRE" + "   |    " + "APELLIDO" + "   |    " + "DIRECCION" + "   |    " + "MAIL" + "   |    " + "CELULAR" + "   |   " + "LISTA" + "   |   ";
        String lines = "";
        // Se hace un separador.
        for(int i = 0; i < s.length(); i++){
            lines += "─";
        }
        System.out.println(lines + "\n" + s + "\n" + lines);
        // Y se revisa toda la lista.
        for(int i = 0; i < listaHash.length; i++){
            lines = "";
            // Si el nodo inicial no es nulo.
            if(listaHash[i].inicio != null){
                // Y el que le sigue tampoco lo es se imprime de este modo.
                if(listaHash[i].inicio.nodoSig != null){
                    s = (i+1) + "   |   " + listaHash[i].inicio.dni + "   |   " + listaHash[i].inicio.nombre + "   |   " + listaHash[i].inicio.apellido + "   |   " + listaHash[i].inicio.direccion + "   |   "
                    + listaHash[i].inicio.email + "   |   " + listaHash[i].inicio.celular + "   |   " + listaHash[i].inicio.nodoSig.dni;
                } else{ // Si nodoSig es nulo se imprime de esta forma.
                    s = (i+1) + "   |   " + listaHash[i].inicio.dni + "   |   " + listaHash[i].inicio.nombre + "   |   " + listaHash[i].inicio.apellido + "   |   " + listaHash[i].inicio.direccion + "   |   "
                    + listaHash[i].inicio.email + "   |   " + listaHash[i].inicio.celular + "   |   " + "--" + "   |   ";
                }
            } else{ // En caso de que el nodo inicial sea nulo se dejan espacios.
                    s = (i+1) + "   |          |   " +  "   |          |   " + "   |          |   " + "   |          |   "+ "   |          |   " + "   |          |   " + "   |          |   ";
            }
            // Se ajusta la linea para que tenga el mismo tamaño que el del texto.
            for(int j = 0; j < s.length(); j++){
                lines += "─";
            }
            // Se imprimen
            System.out.println(s + "\n");
            System.out.println(lines + "\n");
        }
    }
    /**
     * Imprime la lista en el orden que se ingresaron los datos.
     */
    public void printOriginal(){
        // Se imprimen las columnas
        System.out.println("\n");
        String s = "    |    " + "DNI" + "   |    " + "NOMBRE" + "   |    " + "APELLIDO" + "   |    " + "DIRECCION" + "   |    " + "MAIL" + "   |    " + "CELULAR" + "   |   ";
        String lines = "";
        // Se hace un separador.
        for(int i = 0; i < s.length(); i++){
            lines += "─";
        }
        System.out.println(lines + "\n" + s + "\n" + lines);
        // Se revisa la matriz.
        for(int i = 0; i < original.length; i++){
            lines = "";
            // Si el nodo no es nulo se imprime asi.
            if(original[i] != null){
                s = (i+1) + "   |   " + original[i].dni + "   |   " + original[i].nombre + "   |   " + original[i].apellido + "   |   " + original[i].direccion + "   |   "
                + original[i].email + "   |   " + original[i].celular + "   |   ";
                // Se ajusta el separador.
                for(int j = 0; j < s.length(); j++){
                    lines += "─";
                }
                // Se imprime la linea con los atributos y el separador.
                System.out.println(s + "\n");
                System.out.println(lines + "\n");
            }
        }
    }
}
