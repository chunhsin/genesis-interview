package ic.jms.genesis.employees;

import ic.jms.genesis.Employee;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class ProductManager extends BasicEmployee {
    @Override
    public boolean canHandleCall() {
        System.out.println("i'm, product manager");
        return true;
    }

    @Override
    public void finishCall() {

    }

}
