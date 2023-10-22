package org.example;

import com.sun.security.jgss.GSSUtil;
import org.example.model.*;
import org.example.services.MenuPrincipal;
import org.example.utilsProject.DataLoader;

public class Main {
    public static void main(String[] args) throws InterruptedException {



/*
        Tienda miTienda1= new Tienda();
        ProductoArray invetarioProdcutos1= DataLoader.invetarioNuevo();
        VentasArray invetarioVentas1=new VentasArray();



        miTienda1.setInventario(invetarioProdcutos1);
        miTienda1.setInvetarioVentas(invetarioVentas1);

        System.out.println("inventario antes de ingresar las ventas \n \n");
        System.out.println(miTienda1.getInventario());



        Venta venta1= new Venta();

        venta1.agregarProducto(invetarioProdcutos1.consultarProducto("Laptop"),1);
        //System.out.println(invetarioProdcutos1.consultarProducto(101));
        venta1.agregarProducto(invetarioProdcutos1.consultarProducto("Celular"),5);

        Venta venta2= new Venta();

        venta2.agregarProducto(miTienda1.getInventario().consultarProducto(103),2);
        Venta venta3= new Venta();
        venta3.agregarProducto(miTienda1.getInventario().consultarProducto("Bicicleta"),3);
        venta3.agregarProducto(miTienda1.getInventario().consultarProducto("Zapatos"),5);
        venta3.agregarProducto(miTienda1.getInventario().consultarProducto(102),1);



       // miTienda1.realizarVenta(venta2);
        miTienda1.realizarVenta(venta1);
        //miTienda1.realizarVenta(venta3);


        System.out.println("Inventario después de agregar las ventas ");

        System.out.println(miTienda1.getInventario());
        System.out.println(miTienda1.getInvetarioVentas());
       // System.out.println(miTienda1.getInvetarioVentas().getLineaVentas().get(2).getLineasVenta());

       // miTienda1.getInventario().eliminarProducto((ProductoInventario) miTienda1.getInventario().consultarProducto(101));
       // System.out.println(miTienda1.getInventario());
        System.out.println("programa ejecutado con exito");

    */

        Tienda miTienda1= new Tienda();
        ProductoArray invetarioProdcutos1= DataLoader.invetarioNuevo();
        VentasArray invetarioVentas1=new VentasArray();
        miTienda1.setInventario(invetarioProdcutos1);
        miTienda1.setInvetarioVentas(invetarioVentas1);

        MenuPrincipal menuPrincipal= new MenuPrincipal(miTienda1);

        menuPrincipal.menu();




    }
}