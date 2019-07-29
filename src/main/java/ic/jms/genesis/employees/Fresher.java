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
        boolean canResolveQuestion = Math.random() > 0.9999;
        if (!canResolveQuestion) {
            System.out.println("sorry, i need escalate the call to technical lead");
        }
        else {
            System.out.println("Problem solved, thank you");
        }
        return canResolveQuestion;
    }



}
