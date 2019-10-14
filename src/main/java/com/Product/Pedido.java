package com.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pedido {
    private String nombre;
    private List<PL> liniaPedido = new ArrayList<>();

    public Pedido(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    private class PL{
        private Producte producte;
        private int cantidad;

        public PL(Producte producte, int cantidad) {
            this.producte=producte;
            this.cantidad=cantidad;
        }
    }

    public void CreatePL(Producte producte, int cantidad, Map<String,Producte> m) {
        liniaPedido.add(new PL(producte,cantidad));
        m.get(producte.getNombre()).incrCantidad(cantidad);

    }

}
