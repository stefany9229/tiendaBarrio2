package org.example.services;

import org.example.model.LineaVenta;
import org.example.model.Producto;
import org.example.model.Tienda;
import org.example.model.Venta;
import org.w3c.dom.Node;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.function.Consumer;

public class MenuVentas {

    private Tienda tienda;
    private MenuPrincipal menuPrincipal;

    public MenuVentas(Tienda tienda, MenuPrincipal menuPrincipal) {
        this.tienda = tienda;
        this.menuPrincipal = menuPrincipal;
    }

    public void efectuarVenta() {

        Scanner scanner = new Scanner(System.in);
        String continuar = "y";
        Producto prodcutoCarrito;

        Venta carrito = new Venta();
        this.llenarCarrito(carrito);
        this.menuPrincipal.menu();


    }

    public void llenarCarrito(Venta carrito) {

        Scanner scanner = new Scanner(System.in);
        String continuar;
        Producto productoCarrito;

        do {

            System.out.println(" Ingrese el código o el nombre del producto que desea agregar al carrito");
            String entradaProducto = scanner.nextLine();
            try {
                int codigo = Integer.parseInt(entradaProducto);
                productoCarrito= this.tienda.getInventario().consultarProducto(codigo);

            } catch (NumberFormatException e) {
                productoCarrito= this.tienda.getInventario().consultarProducto(entradaProducto);
            }



            if(productoCarrito!=null){
                System.out.println("el producto que está ingresando al carrito es " + productoCarrito.getNombre());
                System.out.println("ingrese la cantidad de producto que desea adquirir");

                int cantidadProductoCarrito= scanner.nextInt();
                scanner.nextLine();

                carrito.agregarProducto(productoCarrito,cantidadProductoCarrito);

            }else{
                System.out.println("el producto que intenta agregar no existe ");
            }
            System.out.println("desea agregar un nuevo producto: y/n");
            continuar = scanner.nextLine();


        } while(continuar.equals("y"));

        System.out.println("Su carrito de ventas contiene");

        Consumer<LineaVenta> soutPrint = lineaVenta ->{
            System.out.println(lineaVenta.getProducto().getNombre() + " "
                    + lineaVenta.getCantidad()+ " "+ lineaVenta.getSubtotal());
        };

        carrito.getLineasVenta().forEach(soutPrint);
        System.out.println("el total de su compra es " + carrito.calcularTotal());
        this.efectuarVentaAux(carrito);
    }

    public void efectuarVentaAux(Venta carrito) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("¿Desea efectuar la venta? (y/n)");
        String decisionVenta = scanner.nextLine().toLowerCase();

        if (decisionVenta.equals("y")) {
            tienda.realizarVenta(carrito);
            System.out.println("la compra ha sido efectuada con éxito ");
        } else {
            System.out.println("¿Desea seguir agregando productos al carrito? (y/n)");
            String decisionAgregar = scanner.nextLine().toLowerCase();
            if (decisionAgregar.equals("y")) {
                llenarCarrito(carrito);
            }else{
                this.menuPrincipal.menu();
            }
        }
    }


    public void mostrarInventarioVentas(){
        Scanner scanner = new Scanner(System.in);

        //System.out.println(tienda.getInvetarioVentas());
        Consumer<Venta> soutPrint = venta ->{
            System.out.println("fecha: " + venta.getFecha() );
            System.out.println("total: " + venta.getTotal());
            System.out.println("productos:  ");
            venta.getLineasVenta().forEach(lineaVenta -> System.out.println("  "  + lineaVenta) );
            System.out.println();
        };

        tienda.getInvetarioVentas().getVentaList().forEach(soutPrint);
        System.out.println("el total de ventas ha sido: " + tienda.getInvetarioVentas().calcularVentasTotal());
        System.out.println();
        System.out.println("presione enter para continuar");
        scanner.nextLine();
        this.menuPrincipal.menu();
    }







}
