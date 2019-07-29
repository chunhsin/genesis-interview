package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class Fresher extends BasicEmployee {

    int freshCanHandleDifficulty = 50;

    public Fresher(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall(int difficulty) {
        System.out.println("Hi, i'm refresher " + employeeNumber);
        boolean canResolveQuestion = freshCanHandleDifficulty >= difficulty;
        if (!canResolveQuestion) {
            System.out.println("sorry, i need escalate the call to technical lead");
        }
        else {
            System.out.println("Problem solved, thank you");
        }
        return canResolveQuestion;
    }

}
