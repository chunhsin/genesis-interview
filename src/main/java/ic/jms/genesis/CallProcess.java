package ic.jms.genesis;

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
        if (fresher.canHandleCall()) {
            fresher.finishCall();
        }
        else {
            fresher.finishCall();
            System.out.println("tech leader is free : "+technicalLeader.isFree());
            while (!technicalLeader.isFree()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (technicalLeader.canHandleCall()) {
                technicalLeader.finishCall();
            }
            else {
                technicalLeader.finishCall();
                while (!productManager.isFree()){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                productManager.canHandleCall();
                productManager.finishCall();
            }

        }

    }
}
