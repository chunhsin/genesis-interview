package ic.jms.genesis.employees;

import ic.jms.genesis.Employee;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class TechnicalLeader implements Employee {
    @Override
    public void answerCall() {

    }

    @Override
    public boolean isFree() {
        return false;
    }
}