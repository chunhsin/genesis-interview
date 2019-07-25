package ic.jms.genesis;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CallCenterTest {

    private CallCenter callCenter = new CallCenter();

    @Test
    public void testCallCenter_ReceiveACall() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 1000; i++) {
            callCenter.receiveACall();
        }
        System.out.println("Receive Call : " + callCenter.getReceiveCallCount());
        latch.await(10, TimeUnit.SECONDS);

    }
}
