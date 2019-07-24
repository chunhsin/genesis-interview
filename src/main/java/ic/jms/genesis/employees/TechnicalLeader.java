package ic.jms.genesis.employees;

import ic.jms.genesis.Employee;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class TechnicalLeader extends BasicEmployee {
    @Override
    public boolean canHandleCall() {
        System.out.println("Hi, i'm tech leader");
        return true;
    }

}
