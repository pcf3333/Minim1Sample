import java.util.ArrayList;
import java.util.List;

public class pedidos {
    private String nombre;
    private List<PL> liniaPedido = new ArrayList<>();

    public pedidos(String nombre,PL pedido){
    }

    private class PL{
        private Producte producte;
        private int cantidad;

        public PL(Producte producte, int cantidad) {
            this.producte=producte;
            this.cantidad=cantidad;
        }
    }

}
