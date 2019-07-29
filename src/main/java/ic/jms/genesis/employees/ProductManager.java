package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class ProductManager extends BasicEmployee {
    private int resolveTime = 200;
    public ProductManager(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall(int difficulty) {
        System.out.println("i'm, product manager " + employeeNumber);
        try {
            Thread.sleep(resolveTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Happy to solve the your problem, Thank you.");
        return true;
    }

}
