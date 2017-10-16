import com.sheng.model.Item;
import com.sheng.model.ShoppingCart;
import com.sheng.model.Store;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 测试（mock）
 * <p>
 * Created by zhengzs on 2017/10/13.
 */
public class ShoppingCartTest {
    public ShoppingCart cart = null;
    public Store storeMock = null;

    @Before
    public void initialize()
    {
        cart = new ShoppingCart();
        storeMock = EasyMock.createMock(Store.class);
        cart.setStore(storeMock);
    }


    @Test
    public void testShoppingCart()
    {


        EasyMock.expect(storeMock.getPrice("Mead Spiral Bound Notebook, College Rule")).andReturn(5.99);
        EasyMock.expect(storeMock.getPrice("Kindle Fire HD 8.9")).andReturn(499.99);

        //开始使用mock
        EasyMock.replay(storeMock);

        Item item1 = new Item("Mead Spiral Bound Notebook, College Rule", 3);
        Item item2 = new Item("Kindle Fire HD 8.9",1);

        cart.addItem(item1);
        cart.addItem(item2);

        double total = cart.calculateTotal();

        System.out.println("Total price of items in shopping cart: $"+total);
        assertEquals("Result",600, total,0);
    }

    @After
    public void cleanup()
    {
        cart=null;
        storeMock=null;
    }
}
