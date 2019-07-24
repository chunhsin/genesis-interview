package ic.jms.genesis;

import ic.jms.genesis.employees.Fresher;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class CallProcess implements Runnable {

    private Fresher fresher;
    private Employee pmOrTl;

    CallProcess(Fresher fresher,
                Employee pmOrTl) {
        this.fresher = fresher;
        this.pmOrTl = pmOrTl;
    }

    @Override
    public void run() {
        System.out.println("receive a call");
        if(fresher.canHandleCall()){
            fresher.finishCall();
        }
        else{
            System.out.println( "pm or tl is free : "+pmOrTl.isFree() );
            while (!pmOrTl.isFree()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pmOrTl.canHandleCall();
            pmOrTl.finishCall();
        }

    }
}
