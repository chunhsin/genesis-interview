package ic.jms.genesis.employees;

import ic.jms.genesis.Employee;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class BasicEmployee implements Employee {

    boolean isFree = true;
    int employeeNumber;

    BasicEmployee(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public boolean canHandleCall() {
        return false;
    }

    @Override
    public void finishCall() {
        isFree = true;
    }

    @Override
    public synchronized boolean isFree() {
        return isFree;
    }

    @Override
    public boolean isFresher() {
        return false;
    }
}
