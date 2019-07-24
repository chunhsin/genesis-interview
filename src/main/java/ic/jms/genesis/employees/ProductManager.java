package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class ProductManager extends BasicEmployee {
    public ProductManager(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public synchronized boolean canHandleCall() {
        super.isFree = false;
        System.out.println("i'm, product manager " + employeeNumber);
        return true;
    }

}
