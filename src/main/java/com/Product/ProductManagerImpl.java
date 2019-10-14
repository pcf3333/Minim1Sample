package com.Product;

import java.util.*;

public class ProductManagerImpl implements ProductManager {

    private Queue<Pedido> Comandas= new LinkedList<>();
    private List<Producte> productos;
    private Map<String, Usuario> Usuarios = new HashMap();

    public List<Producte> productesOrdPreu() {
        Collections.sort(productos, CMP_PRIZE);
        return productos;
    }


    public void AnotarComanda(Pedido p) {
        this.Comandas.add(p);
    }

    public void servirComanda() {
        Pedido p = this.Comandas.remove();
        this.Usuarios.get(p.getNombre()).addPedido(p);
    }

    public Queue<Pedido> getComandas() {
        return Comandas;
    }

    public List<Pedido> comandesPerUsuari(String isUser) {
        return null;
    }

    public List<Producte> productesOrdVentes() {
        Collections.sort(productos, new CompararVentas());
        return productos;
    }

    public static class CompararPrecio implements Comparator<Producte> {
        public int compare(Producte pr1, Producte pr2) {
            return Double.compare(pr1.getPrecio(), pr2.getPrecio());
        }
    }

    public static class CompararVentas implements Comparator<Producte> {
        public int compare(Producte pr1, Producte pr2) {
            return Double.compare(pr1.getVentas(), pr2.getVentas());
        }
    }

    private Comparator<Producte> CMP_PRIZE = new Comparator<Producte>() {
        public int compare(Producte p1, Producte p2) {
            return (int) (p1.getPrecio() - p2.getPrecio());
        }
    };
}