import java.util.List;

public interface ProductManager {
    public List<Producte> productesOrdPreu();
    public void AnotarComanda(Comanda c);
    public void servirComanda();
    public List<Comanda> comandesPerUsuari(String isUser);
    public List<Producte> productesOrdVentes();
}
