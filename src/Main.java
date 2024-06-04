import java.util.Scanner;
/*
 * Desarrollar un Producto de Software que cumpla con
las siguientes características.

• Construir una Tabla (Array) de tamaño 10 en Java
que contenga las siguientes columnas: (DNI,
Apellidos, Nombres, Email, Celular, Dirección).
• Cargue dicha tabla con datos validos y verdaderos.
Se pueden utilizar los datos asociados con los
compañeros del equipo de clases (Prog. III),
familiares y/o conocidos.
• Los 10 registros deben ser introducidos en la tabla
desde el teclado con el uso de una interfaz gráfica
(IHM).
• Después de cargados los 10 registros, proceder a
cargar una segunda Tabla, similar a la primera, pero
con 4 columnas adicionales que se intercalaran
entre la columna “DNI” y la columna “Apellidos”.
• Las cuatro columnas adicionadas serán el resultado
de haber calculado las 4 funciones Hash estudiadas
en esta clase.
• La columna clave a ser tomada en cuenta debe ser
la del DNI.
• Al final imprima en forma tabular las 2 Tablas,
primero la tabla sin Hash y después la tabla con
Hash.
 */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        Tabla_Hash tabla_Hash = new Tabla_Hash();
        tabla_Hash.hardcodear("96180472", "Diego", "Escorche", "Av. Santa Fe 9875", "escorchediego@gmail.com", "1173639654");
        tabla_Hash.hardcodear("12378093", "Audrey", "Barrientos", "Av. Cabildo 4214", "audreybarrientos@gmail.com", "1138509132");
        tabla_Hash.hardcodear("46359867", "Celeste", "Gramisci", "Juan B Justo 3458", "celestegramisci@gmail.com", "1165231970");
        tabla_Hash.hardcodear("56498968", "Gonzalo", "Colato", "Mercedes 7412", "gonzalocolato@gmail.com", "1103492734");
        tabla_Hash.hardcodear("69045726", "Ivan", "Gonzalez", "Fernandez de Enciso 3647", "ivangonzalez@gmail.com", "1114273980");
        tabla_Hash.hardcodear("23049653", "Samuel", "Gamboa", "Beiro 1425", "samuelgamboa@gmail.com", "1113456897");
        tabla_Hash.hardcodear("23476908", "Pablo", "Esquiubar", "Coronel Paz 1234", "pablito@gmail.com", "1143789056");
        tabla_Hash.hardcodear("46798055", "Izabella", "Enciso", "Villanueva 7689", "iza.enciso@gmail.com", "1110795634");
        tabla_Hash.hardcodear("34672184", "Maria", "Perez", "Segurola 4756", "perez15@gmail.com", "1136790845");
        tabla_Hash.hardcodear("12387645", "Elen", "Suarez", "Asuncion 5243", "elensuarez@gmail.com", "1163795843");
        while (!salir) {
            // Inicio del menu en el que se crea el arbol.       
            System.out.println("BIENVENIDOS AL MENU");
            System.out.println("\n======================");
            System.out.println("\nIngrese la opcion que desea:"
                    + "\n1. Insertar usuario."
                    + "\n2. Eliminar usuario."
                    + "\n3. Imprimir las tablas."
                    + "\n4. Eliminar todos los usuarios."
                    + "\n5. Salir."
                    + "\nSelecciona una opción: ");

            String opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    tabla_Hash.insertar();
                    break;

                case "2":
                    System.out.println("Inserte el dni del usuario que desea eliminar?");
                    String ans = scan.nextLine();
                    tabla_Hash.eliminar(ans);
                    break;

                case "3":
                    System.out.println("\nPresione 'ENTER' para ver la tabla Hash.");
                    scan.nextLine();
                    System.out.println("\nTABLA HASH");
                    tabla_Hash.printHash();
                    System.out.println("\nPresione 'ENTER' para ver la tabla original.");
                    scan.nextLine();
                    System.out.println("\nTABLA ORIGINAL");
                    tabla_Hash.printOriginal();
                    break;

                case "4":
                    tabla_Hash.destruir();
                    break;
                case "5":
                    salir = true;
                    break;

                default:
                    System.out.println("No reconocido.");
                    break;

            }
            if (!salir) {
                System.out.println("Presione ENTER para continuar.");
                scan.nextLine();
            }

        }
        scan.close();

    }
}

