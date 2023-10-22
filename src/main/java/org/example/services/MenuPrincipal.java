package org.example.services;

import org.example.model.Tienda;

import java.util.Scanner;

public class MenuPrincipal {

    Tienda tienda;
    MenuInventario menuInventario;

    public MenuPrincipal(Tienda tienda) {
        this.tienda = tienda;
        this.menuInventario = new MenuInventario(tienda, this);  // Pasamos 'this' al constructor
    }

    public  void  menu(){

        System.out.println("*----------------------------------------------*");
        System.out.println("|          TIENDA VILLA CECILIA               |");
        System.out.println("| Selecciona una de las siguientes opciones:  |");
        System.out.println("| 1. Inventario                               |");
        System.out.println("| 2. Empezar una venta                        |");
        System.out.println("| 3. Consultar Ventas                         |");
        System.out.println("| 4. Salir                                    |");
        System.out.println("*----------------------------------------------*");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                this.menuInventario.mostrarOpciones();
                break;
            case 2:
                System.out.println("trabajando en ");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;

            default:
                System.out.println("Número inválido para un día de la semana");
        }



    }



}
