package ic.jms.genesis;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public interface Employee {
    boolean canHandleCall();
    void finishCall();
    boolean isFree();
    boolean isFresher();
}
