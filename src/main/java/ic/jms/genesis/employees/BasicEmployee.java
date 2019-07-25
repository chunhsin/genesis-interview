package ic.jms.genesis.employees;

import ic.jms.genesis.Employee;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public abstract class BasicEmployee implements Employee {

    boolean isFree = true;
    int employeeNumber;

    BasicEmployee(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public synchronized void finishCall() {
        this.isFree = true;
    }

    @Override
    public synchronized boolean isFree() {
        return this.isFree;
    }

}
