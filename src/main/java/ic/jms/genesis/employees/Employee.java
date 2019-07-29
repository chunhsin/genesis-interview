package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public interface Employee {
    void answerCall(int difficulty) throws CanNotHandleCallException;
    boolean canHandleCall(int difficulty);
    boolean isFree();
}
