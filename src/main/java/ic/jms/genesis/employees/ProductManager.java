package ic.jms.genesis.employees;

import ic.jms.genesis.Employee;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class ProductManager implements Employee {
    @Override
    public void answerCall() {

    }

    @Override
    public void finishCall() {

    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public boolean isFresher() {
        return false;
    }
}
