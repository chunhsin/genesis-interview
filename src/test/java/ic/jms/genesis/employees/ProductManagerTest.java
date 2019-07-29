package ic.jms.genesis.employees;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jamesliao
 * @since 2019-07-29
 */
public class ProductManagerTest {
    @Test
    public void test_productManager_WHEN_canHandleCall_THEN_NoException() throws Exception, CanNotHandleCallException {
        // given
        Employee employee = new ProductManager(1);
        // when
        employee.answerCall(101);
        // then
        Assert.assertTrue(employee.isFree());
    }
}