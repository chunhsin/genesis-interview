package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class ProductManager extends BasicEmployee {

    int canHandleDifficulty = 100;

    public ProductManager(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall(int difficulty) {
        System.out.println("i'm, product manager " + employeeNumber);
        return true;
    }

}
