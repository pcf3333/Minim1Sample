import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String nombre;
    private List<PL> liniaPedido = new ArrayList<>();

    public Pedido(String nombre, List<PL> liniaPedido){
        this.nombre=nombre;
        this.liniaPedido=liniaPedido;
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

}
