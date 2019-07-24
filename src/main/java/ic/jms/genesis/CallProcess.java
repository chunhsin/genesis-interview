package ic.jms.genesis;

import ic.jms.genesis.employees.Fresher;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class CallProcess implements Runnable {

    private Fresher fresher;
    private Employee pmOrtl;

    CallProcess(Fresher fresher,
                Employee pmOrtl) {
        this.fresher = fresher;
        this.pmOrtl = pmOrtl;
    }

    @Override
    public void run() {
        System.out.println("receive a call");
        if(fresher.canHandleCall()){
            fresher.finishCall();
        }
        else{
            pmOrtl.canHandleCall();
        }

    }
}
