package com.Product;

import java.util.List;

public interface ProductManager {
    public List<Producte> productesOrdPreu();
    public void AnotarComanda(Pedido c);
    public void servirComanda();
    public List<Pedido> comandesPerUsuari(String isUser);
    public List<Producte> productesOrdVentes();
}
