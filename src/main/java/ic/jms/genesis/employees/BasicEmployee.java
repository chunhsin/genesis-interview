package ic.jms.genesis.employees;

import ic.jms.genesis.Employee;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class BasicEmployee implements Employee {

    protected boolean isFree = true;

    @Override
    public boolean canHandleCall() {
        return false;
    }

    @Override
    public void finishCall() {
        isFree = true;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public boolean isFresher() {
        return false;
    }
}
