package ic.jms.genesis.employees;

import static ic.jms.genesis.Constants.PRODUCT_MANAGER_RESOLVE_TIME;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class ProductManager extends BasicEmployee {

    public ProductManager(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall(int difficulty) {
        System.out.println("i'm, product manager " + employeeNumber);
        trySolveProblem();

        System.out.println("Happy to solve the your problem, Thank you.");
        return true;
    }

    @Override
    public void trySolveProblem() {
        if (PRODUCT_MANAGER_RESOLVE_TIME != 0) {
            try {
                Thread.sleep(PRODUCT_MANAGER_RESOLVE_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
