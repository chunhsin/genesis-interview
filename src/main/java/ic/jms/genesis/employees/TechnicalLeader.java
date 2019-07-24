package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class TechnicalLeader extends BasicEmployee {
    public TechnicalLeader(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall() {
        System.out.println("Hi, i'm tech leader " + employeeNumber);
        return true;
    }

}
