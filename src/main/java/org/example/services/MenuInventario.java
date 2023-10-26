package org.example.services;

import org.example.model.ProductoInventario;
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

                ProductoInventario productoInventario = new ProductoInventario();

                String nombre;
                int precio;
                int codigo1;
                String descripcion;
                String categoria;
                String urlFoto;
                int cantidad;

                System.out.println(" Ingrese el nuevo nombre del producto");
                nombre= scanner.nextLine();
                productoInventario.setNombre(nombre);

                System.out.println(" Ingrese la descripcion");
                descripcion= scanner.nextLine();
                productoInventario.setDescripcion(descripcion);

                System.out.println(" Ingrese la url de direccion de la foto ");
                urlFoto= scanner.nextLine();
                productoInventario.setUrlFoto(urlFoto);

                System.out.println(" Ingrese la cantidad de producto");
                cantidad= scanner.nextInt();
                scanner.nextLine();
                productoInventario.setCantidad(cantidad);

                int auxcodigo;
                auxcodigo= tienda.getInventario().obtenerListadoProducto().size()+1;
                codigo1=tienda.getInventario().consultarProducto(auxcodigo-1).getCodigo();
                productoInventario.setCodigo(codigo1+1);
                tienda.getInventario().agregarProducto(productoInventario);
                System.out.println("porducto agregado con éxito");

                System.out.println("Presione enter para continuar");
                scanner.nextLine();
                this.mostrarOpciones();
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
                System.out.println("Introduce él codigo o el nombre del producto que deseas actualizar:");
                String entradaActualizar = scanner.nextLine();
                //scanner.nextLine();
                ProductoInventario productoActualizar;

                try {
                int codigo = Integer.parseInt(entradaActualizar);
                // Si llegamos a este punto, la conversión fue exitosa.
                // Aquí puedes manejar la entrada como un entero.
                //System.out.println("la tiendo que tengo es " + tienda);
                    productoActualizar= (ProductoInventario) this.tienda.getInventario().consultarProducto(codigo);
            } catch (NumberFormatException e) {
                // Si ocurre una excepción, entonces la entrada es un String que no puede ser convertido a entero.
                // Aquí puedes manejar la entrada como un String.

                    productoActualizar= (ProductoInventario) this.tienda.getInventario().consultarProducto(entradaActualizar);
            }




                System.out.println("*----------------------------------------------*");
                System.out.println("|    ACTILIZACION DEL PRODCUTO: " + productoActualizar.getNombre() + "           |");
                System.out.println("| Selecciona una de las siguientes opciones:  |");
                System.out.println("| 1.actualizar nombre                        |");
                System.out.println("| 2.actulizar descripcion                     |");
                System.out.println("| 3.actualizar url                           |");
                System.out.println("| 4. actualizar categoría                      |");
                System.out.println("| 5. actualizar cantidad                       |");
                System.out.println("| 6. actualizar precio                        |");
                System.out.println("| 7. volver                                    |");
                System.out.println("*----------------------------------------------*");

                int opcionActulizarCampo;
                opcionActulizarCampo= scanner.nextInt();
                scanner.nextLine();



                String entradaNuevoValor;

                switch (opcionActulizarCampo) {
                    case 1:
                        System.out.println("Introduce el nuevo nombre");
                        entradaNuevoValor=scanner.nextLine();
                        productoActualizar.setNombre(entradaNuevoValor);
                        break;
                    case 2:
                        System.out.println("Introduce la nueva descripcion");
                        entradaNuevoValor=scanner.nextLine();
                        productoActualizar.setDescripcion(entradaNuevoValor);
                        break;
                    case 3:
                        System.out.println("introduce la nueva url");
                        entradaNuevoValor=scanner.nextLine();
                        productoActualizar.setUrlFoto(entradaNuevoValor);
                        break;
                    case 4:
                        System.out.println("introduce la nueva categoria");
                        entradaNuevoValor=scanner.nextLine();
                        productoActualizar.setCategoria(entradaNuevoValor);
                        break;
                    case 5:
                        System.out.println("introduce la nueva cantidad.");
                        entradaNuevoValor=scanner.nextLine();
                        productoActualizar.setCantidad(Integer.parseInt(entradaNuevoValor));
                        break;
                    case 6:
                        System.out.println("introduce el nueva precio.");
                        entradaNuevoValor=scanner.nextLine();
                        productoActualizar.setPrecio(Double.parseDouble(entradaNuevoValor));
                        break;

                    default:
                        System.out.println("Elegiste un número fuera del rango 1-7.");
                }

                this.mostrarOpciones();


                break;






            case 4:
                System.out.println("Introduce él codigo o el nombre del producto que deseas eliminar:");

                String entradaEliminar = scanner.nextLine();


                try {
                    int codigo = Integer.parseInt(entradaEliminar);
                    System.out.println(this.tienda.getInventario().consultarProducto(codigo));
                    this.tienda.getInventario().eliminarProducto(codigo);

                } catch (NumberFormatException e) {
                    System.out.println(this.tienda.getInventario().consultarProducto(entradaEliminar));
                    this.tienda.getInventario().eliminarProducto(entradaEliminar);
                }
                System.out.println("producto eliminado con exito");
                System.out.println("presione enter para continuar");
                scanner.nextLine();
                this.mostrarOpciones();


                break;

            case 5:

               this.tienda.getInventario().getProductosInventario().forEach(productoInvent ->
               {
                   System.out.println("codigo: " + productoInvent.getCodigo());
                   System.out.println("nombre: " + productoInvent.getNombre());
                   System.out.println("precio: " + productoInvent.getPrecio());
                   System.out.println("descripcion: " + productoInvent.getDescripcion());
                   System.out.println("categoria: " + productoInvent.getCategoria());
                   System.out.println("urlfoto: " + productoInvent.getUrlFoto());
                   System.out.println("Cantidad en inventario: " + productoInvent.getCantidad());
                   System.out.println();
               })
            ;
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
