package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class Fresher extends BasicEmployee {

    @Override
    public boolean canHandleCall() {
        isFree = false;
        boolean canResolveQuestion = Math.random() > 0.5;
        return canResolveQuestion;
    }


    @Override
    public boolean isFresher() {
        return true;
    }
}
