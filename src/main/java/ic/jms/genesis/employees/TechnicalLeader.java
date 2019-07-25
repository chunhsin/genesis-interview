package ic.jms.genesis.employees;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class TechnicalLeader extends BasicEmployee {

    public TechnicalLeader(int employeeNumber) {
        super(employeeNumber);
        System.out.println("init technical leader is free : "+this.isFree);
    }

    @Override
    public boolean canHandleCall() {
        this.isFree = false;
        boolean canResolveQuestion = Math.random() > 0.5;
        if (!canResolveQuestion) {
            System.out.println("sorry, i need escalate the call to product manager");
        }
        else {
            System.out.println("Technical Problem solved, thank you");
        }
        return canResolveQuestion;
    }

}
