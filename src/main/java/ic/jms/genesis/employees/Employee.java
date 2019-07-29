package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public interface Employee {
    void receiveCall() throws CanNotHandleCallException;
    boolean canHandleCall();
    boolean isFree();
}
