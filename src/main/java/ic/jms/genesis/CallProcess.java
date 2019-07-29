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

    CallProcess(Fresher fresher,
                TechnicalLeader technicalLeader,
                ProductManager productManager) {
        this.fresher = fresher;
        this.technicalLeader = technicalLeader;
        this.productManager = productManager;
    }

    @Override
    public void run() {
        System.out.println("receive a call ");
        try {
            fresher.receiveCall();
        } catch (CanNotHandleCallException e) {
            passToTechLeader();
        }

    }

    private void passToTechLeader() {
        try {
            waitingFroTechLeaderFree();
            System.out.println("TechLeader is Handling the Call");
            technicalLeader.receiveCall();
        } catch (CanNotHandleCallException ex) {
            passToProductManager();
        }
    }

    private void waitingFroTechLeaderFree() {
        while (!technicalLeader.isFree()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void passToProductManager() {
        try {
            waitingForProductManagerFree();
            productManager.receiveCall();
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
