package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class TechnicalLeader extends BasicEmployee {

    private int canHandleDifficulty = 80;
    private int resolveTime = 100;

    public TechnicalLeader(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall(int difficulty) {
        boolean canResolveQuestion = canHandleDifficulty >= difficulty;
        if (!canResolveQuestion) {
            System.out.println("sorry, i need escalate the call to product manager");
        }
        else {
            try {
                Thread.sleep(resolveTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Happy to solve the your problem, Thank you.");
        }
        return canResolveQuestion;
    }

}
