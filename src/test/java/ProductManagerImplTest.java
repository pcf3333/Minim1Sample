import com.Product.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class ProductManagerImplTest {

    ProductManagerImpl productManager = null;
    Map<String,Producte> listProductes = null;
    List<Producte> priceSortedList=null;
    List<Producte> ventasSortedList=null;
    Queue<Pedido> queue = new LinkedList<>();

    //Usuarios
    Pedido Ppere = new Pedido("Pere");
    Pedido Pjuanjo = new Pedido("Juanjo");

    @Before
    public void setUp(){
        productManager=new ProductManagerImpl();
        Producte CocaCola=new Producte("CocaCola",2,0);
        Producte Bocata=new Producte("Bocata",4,0);
        Producte Aquarius=new Producte("Aquarius",3,0);
        Producte Croissant=new Producte("Croissant",1,0);
        listProductes=Map.of("CocaCola",CocaCola ,"Bocata",Bocata,"Aquarius",Aquarius,"Croissant",Croissant);
        priceSortedList=new ArrayList<>(){{add(Croissant);add(CocaCola);add(Aquarius);add(Bocata);}};
        ventasSortedList=new ArrayList<>(){{add(Croissant);add(CocaCola);add(Bocata);add(Aquarius);}};
        productManager.setListProductes(listProductes);

        //Pedidos
        Ppere.CreatePL(listProductes.get("CocaCola"), 2, listProductes);
        Ppere.CreatePL(listProductes.get("Bocata"), 1, listProductes);
        Pjuanjo.CreatePL(listProductes.get("Croissant"), 5, listProductes);
        queue.add(Ppere);
        queue.add(Pjuanjo);
    }

    @Test
    public void testAnotarComanda() {
        //Funcion de anotar una comanda
        productManager.AnotarComanda(Ppere);
        productManager.AnotarComanda(Pjuanjo);
        assertEquals(queue, productManager.getComandas());
    }

    @Test
    public void testServirComanda() {
        productManager.AnotarComanda(Ppere);
        productManager.AnotarComanda(Pjuanjo);

        //Funcion de servir una comanda
        queue.remove();
        productManager.servirComanda();
        assertEquals(queue, productManager.getComandas());
    }

    @Test
    public void testOrdenarPrecio(){
        productManager.AnotarComanda(Ppere);
        productManager.AnotarComanda(Pjuanjo);
        productManager.servirComanda();

        //Ordenar comandas por precio
        assertEquals(productManager.productesOrdPreu(),priceSortedList);
    }

    @Test
    public void testOrdenarVentas(){
        productManager.AnotarComanda(Ppere);
        productManager.AnotarComanda(Pjuanjo);
        productManager.servirComanda();

        //Ordenar comandas por ventas
        assertEquals(productManager.productesOrdVentes(),ventasSortedList);
    }

    @Test
    public void testComandesPerUsuari(){
        productManager.AnotarComanda(Ppere);
        productManager.AnotarComanda(Pjuanjo);
        productManager.servirComanda();

        //Comandas por usuario
        assertEquals(new ArrayList<Pedido>(){{add(Ppere);}},productManager.comandesPerUsuari("Pere"));
        assertEquals(new ArrayList<Pedido>(){},productManager.comandesPerUsuari("Juanjo"));
    }
}