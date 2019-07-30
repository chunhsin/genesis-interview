package ic.jms.genesis.employees;

import static ic.jms.genesis.Constants.TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY;
import static ic.jms.genesis.Constants.TECHNICAL_LEADER_RESOLVE_TIME;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class TechnicalLeader extends BasicEmployee {

    public TechnicalLeader(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall(int difficulty) {
        trySolveProblem();
        boolean canResolveQuestion = TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY >= difficulty;
        if (!canResolveQuestion) {
            System.out.println("sorry, i need escalate the call to product manager");
        }
        else {
            System.out.println("Happy to solve the your problem, Thank you.");
        }
        return canResolveQuestion;
    }

    @Override
    public void trySolveProblem() {
        if (TECHNICAL_LEADER_RESOLVE_TIME != 0) {
            try {
                Thread.sleep(TECHNICAL_LEADER_RESOLVE_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
