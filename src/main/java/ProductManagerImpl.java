import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class ProductManagerImpl implements ProductManager {

    private Queue<pedidos> Comandas;

    private List<Producte> productos;

    public List<Producte> productesOrdPreu() {
        return productos.sort(CMP_PRIZE);
    }

    public void AnotarComanda(Comanda c) {

    }

    public void servirComanda() {

    }

    public List<Comanda> comandesPerUsuari(String isUser) {
        return null;
    }

    public List<Producte> productesOrdVentes() {
        return productos.sort(new CompararVentas());
    }

    static class CompararPrecio implements Comparator<Producte> {
        public int compare (Producte pr1, Producte pr2)
        {
            return Double.compare(pr1.getPrecio(),pr2.getPrecio());
        }
    }

    static class CompararVentas implements Comparator<Producte> {
        public int compare (Producte pr1, Producte pr2)
        {
            return Double.compare(pr1.getVentas(),pr2.getVentas());
        }
    }

    private Comparator<Producte> CMP_PRIZE = new Comparator<Producte>() {
        public int compare(Producte p1, Producte p2) {
            return (int) (p1.precio - p2.precio);
        }
    };
}
