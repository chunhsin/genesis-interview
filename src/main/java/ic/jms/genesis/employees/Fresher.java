package ic.jms.genesis.employees;

import static ic.jms.genesis.Constants.FRESHER_CAN_HANDLE_DIFFICULTY;
import static ic.jms.genesis.Constants.FRESHER_RESOLVE_TIME;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class Fresher extends BasicEmployee {


    public Fresher(int employeeNumber) {
        super(employeeNumber);
    }

    @Override
    public boolean canHandleCall(int difficulty) {
        System.out.println("Hi, i'm refresher " + employeeNumber);
        trySolveProblem();
        boolean canResolveQuestion = FRESHER_CAN_HANDLE_DIFFICULTY >= difficulty;
        if (!canResolveQuestion) {
            System.out.println("sorry, i need escalate the call to technical lead");
        }
        else {
            System.out.println("Happy to solve the your problem, Thank you.");
        }
        return canResolveQuestion;
    }

    @Override
    public void trySolveProblem() {
        if(FRESHER_RESOLVE_TIME != 0){
            try {
                Thread.sleep(FRESHER_RESOLVE_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
