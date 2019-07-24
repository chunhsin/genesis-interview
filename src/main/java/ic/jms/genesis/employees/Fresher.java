package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class Fresher extends BasicEmployee {

    public Fresher(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall() {
        System.out.println("Hi, i'm refresher " + employeeNumber);
        isFree = false;
        boolean canResolveQuestion = Math.random() > 0.1;
        if (!canResolveQuestion) {
            System.out.println("sorry, i need escalate the call to technical lead");
        }
        else {
            System.out.println("Problem resovled, thank you");
        }
        return canResolveQuestion;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public boolean isFresher() {
        return true;
    }
}
