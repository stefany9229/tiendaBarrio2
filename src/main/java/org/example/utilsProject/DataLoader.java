package org.example.utilsProject;

import org.example.model.ProductoArray;
import org.example.model.ProductoInventario;

import java.util.ArrayList;

public class DataLoader {


    public static ProductoArray invetarioNuevo(){

        ProductoInventario prod1 = new ProductoInventario("Laptop", 1000.00, 1, "Laptop de alto rendimiento", "Electrónicos", "urlFoto1.jpg", 5);
        ProductoInventario prod2 = new ProductoInventario("Celular", 500.00, 2, "Smartphone con cámara de 12MP", "Electrónicos", "urlFoto2.jpg", 10);
        ProductoInventario prod3 = new ProductoInventario("Zapatos", 50.00, 3, "Zapatos deportivos", "Vestimenta", "urlFoto3.jpg", 20);
        ProductoInventario prod4 = new ProductoInventario("Bicicleta", 200.00, 4, "Bicicleta montañera", "Deportes", "urlFoto4.jpg", 3);

        // Creando ArrayList y agregando productos
        ArrayList<ProductoInventario> inventario = new ArrayList<>();
        inventario.add(prod1);
        inventario.add(prod2);
        inventario.add(prod3);
        inventario.add(prod4);

        ProductoArray nuevoInventario= new ProductoArray();
        nuevoInventario.setProductosInventario(inventario);

        return nuevoInventario;

    }
}
