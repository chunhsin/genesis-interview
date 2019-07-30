package ic.jms.genesis;

import ic.jms.genesis.employees.CanNotHandleCallException;
import ic.jms.genesis.employees.Fresher;
import ic.jms.genesis.employees.ProductManager;
import ic.jms.genesis.employees.TechnicalLeader;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class CallProcess implements Runnable {

    private Fresher fresher;
    private TechnicalLeader technicalLeader;
    private ProductManager productManager;

    CallProcess(Fresher fresher,TechnicalLeader technicalLeader,ProductManager productManager) {
        this.fresher = fresher;
        this.technicalLeader = technicalLeader;
        this.productManager = productManager;
    }

    CallProcess(Fresher fresher) {
        this.fresher = fresher;
        CallCenter callCenter = CallCenter.getInstance();
        this.technicalLeader = callCenter.getTechnicalLeader();
        this.productManager = callCenter.getProductManager();
    }

    @Override
    public void run() {
        System.out.println("receive a call ");
        int difficulty = (int) (Math.random() * 100);
        handleInComingCall(difficulty);
    }

    void handleInComingCall(int difficulty) {
        try {
            fresher.answerCall(difficulty);
        } catch (CanNotHandleCallException e) {
            passToTechLeader(difficulty);
        }
    }

    private void passToTechLeader(int difficulty) {
        try {
            if (technicalLeader.isFree()) {
                System.out.println("TechLeader is Handling the Call");
                technicalLeader.answerCall(difficulty);
            }
            throw new CanNotHandleCallException();
        } catch (CanNotHandleCallException ex) {
            passToProductManager(difficulty);
        }
    }

    private void passToProductManager(int difficulty) {
        try {
            waitingForProductManagerFree();
            productManager.answerCall(difficulty);
        } catch (CanNotHandleCallException ignore) {
        }
    }

    private void waitingForProductManagerFree() {
        while (!productManager.isFree()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
