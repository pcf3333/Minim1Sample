import com.Product.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class ProductManagerImplTest {

    ProductManagerImpl productManager = null;
    Map<String,Producte> listProductes = null;

    @Before
    public void setUp(){
        productManager=new ProductManagerImpl();
        Producte CocaCola=new Producte("CocaCola",2,0);
        Producte Bocata=new Producte("Bocata",4,0);
        Producte Aquarius=new Producte("Aquarius",2,0);
        Producte Croissant=new Producte("Croissant",1,0);
        listProductes=Map.of("CocaCola",CocaCola ,"Bocata",Bocata,"Aquarius",Aquarius,"Croissant",Croissant);
    }

    @Test
    public void testProductManagerImpl() {
        Pedido Ppere=new Pedido("Pere");
        Pedido Pjuanjo=new Pedido("Juanjo");
        Ppere.CreatePL(listProductes.get("CocaCola"),2,listProductes);
        Ppere.CreatePL(listProductes.get("Bocata"),1,listProductes);
        Pjuanjo.CreatePL(listProductes.get("Croissant"),5,listProductes);
        Queue<Pedido> queue= new LinkedList<>();
        queue.add(Ppere);
        productManager.AnotarComanda(Ppere);
        assertEquals(queue, productManager.getComandas());
    }
}