package org.example.model;

import java.util.ArrayList;
import java.util.List;



    public class VentasArray {
        private List<Venta> ventas;

        // Constructor
        public VentasArray() {
            this.ventas = new ArrayList<>();
        }

        // Métodos


        public double calcularVentasTotal() {
            double totalVentas = 0.0;
            for(Venta venta : ventas) {
                totalVentas += venta.getTotal();
            }
            return totalVentas;
        }

        /**
         * Agrega una nueva venta a la lista de ventas.
         *
         * @param venta La venta que se desea agregar.
         */
        public void agregarVenta(Venta venta) {
            this.ventas.add(venta);
        }

        // Getter para lineaVentas si es necesario

        public List<Venta> getLineaVentas() {
            return ventas;
        }

        @Override
        public String toString() {
            String resultado="VentasArray{";

            for(Venta venta: ventas ){
                resultado += (venta.toString() + "\n");
            }
            resultado += "}";
            return  resultado;
        }
    }
