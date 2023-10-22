package org.example.services;

import org.example.model.Tienda;

import java.util.Scanner;

import static java.lang.System.exit;

public class MenuInventario {

    private Tienda tienda;
    private MenuPrincipal menuPrincipal;

    public MenuInventario(Tienda tienda, MenuPrincipal menuPrincipal) {
        this.tienda = tienda;
        this.menuPrincipal = menuPrincipal;
    }

    public void mostrarOpciones() {
        System.out.println("*----------------------------------------------*");
        System.out.println("|          INVENTARIO                         |");
        System.out.println("| Selecciona una de las siguientes opciones:  |");
        System.out.println("| 1. Crear prodcuto                           |");
        System.out.println("| 2. Consultar producto                       |");
        System.out.println("| 3. Actulizar producto                       |");
        System.out.println("| 4. Eliminar prodcuto                        |");
        System.out.println("| 5. Ver todo el inventario                   |");
        System.out.println("| 6. Volver al menú principal                 |");
        System.out.println("| 7. Salir                                    |");
        System.out.println("*----------------------------------------------*");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine(); // para consumir el espacio vacio que deja y no tener problemas con las otras entradas


        switch (option) {
            case 1:
                System.out.println("esta opcion no está implementada en el menú");
                break;
            case 2:

                System.out.println("Introduce él codigo o el nombre del producto que deseas consultar:");

                String entrada = scanner.nextLine();


                try {
                    int codigo = Integer.parseInt(entrada);
                    // Si llegamos a este punto, la conversión fue exitosa.
                    // Aquí puedes manejar la entrada como un entero.
                    //System.out.println("la tiendo que tengo es " + tienda);
                    System.out.println(this.tienda.getInventario().consultarProducto(codigo));
                } catch (NumberFormatException e) {
                    // Si ocurre una excepción, entonces la entrada es un String que no puede ser convertido a entero.
                    // Aquí puedes manejar la entrada como un String.

                    System.out.println(this.tienda.getInventario().consultarProducto(entrada));
                }

                System.out.println("presione enter para continuar");
                scanner.nextLine();
                this.mostrarOpciones();

                break;
            case 3:
                System.out.println("Opcion no disponible, estamos trabajando en ella");

                break;
            case 4:
                System.out.println("Introduce él codigo o el nombre del producto que deseas consultar:");

                String entradaEliminar = scanner.nextLine();


                try {
                    int codigo = Integer.parseInt(entradaEliminar);
                    // Si llegamos a este punto, la conversión fue exitosa.
                    // Aquí puedes manejar la entrada como un entero.
                    //System.out.println("la tiendo que tengo es " + tienda);
                    System.out.println(this.tienda.getInventario().consultarProducto(codigo));
                    this.tienda.getInventario().eliminarProducto(codigo);

                } catch (NumberFormatException e) {
                    // Si ocurre una excepción, entonces la entrada es un String que no puede ser convertido a entero.
                    // Aquí puedes manejar la entrada como un String.

                    System.out.println(this.tienda.getInventario().consultarProducto(entradaEliminar));
                    this.tienda.getInventario().eliminarProducto(entradaEliminar);
                }
                System.out.println("producto eliminado con exito");
                System.out.println("presione enter para continuar");
                scanner.nextLine();
                this.mostrarOpciones();


                break;

            case 5:

                System.out.println(this.tienda.getInventario());
                System.out.println("presione enter para continuar");
                scanner.nextLine();
                this.mostrarOpciones();
                break;

            case 6:

                menuPrincipal.menu();
                break;


            case 7:

                System.exit(0);
                break;



            default:
                // Contenido del método MoostrarOpcionesInventario...
        }
    }
}
