package ic.jms.genesis.employees;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public abstract class BasicEmployee implements Employee {

    int canHandleDifficulty = 50;
    AtomicBoolean isFree = new AtomicBoolean(true);
    int employeeNumber;

    BasicEmployee(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void answerCall(int difficulty) throws CanNotHandleCallException {
        this.isFree.set(false);
        if(!this.canHandleCall(difficulty)){
            this.isFree.set(true);
            throw new CanNotHandleCallException();
        }
        this.isFree.set(true);
    }

    @Override
    public boolean isFree() {
        return this.isFree.get();
    }

}
