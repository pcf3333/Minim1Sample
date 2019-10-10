import java.util.Comparator;

public abstract class Producte  {
    public double precio;
    public double ventas;

    protected Comparator<Producte> CMP_PRIZE = new Comparator<Producte>() {
        public int compare(Producte p1, Producte p2) {
            return (int) (p1.precio - p2.precio);
        }
    };

    // Collections.sort(productos, CMP_PRIZE)

    public double getVentas() {
        return ventas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
