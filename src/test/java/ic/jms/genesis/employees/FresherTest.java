package ic.jms.genesis.employees;

import ic.jms.genesis.Constants;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jamesliao
 * @since 2019-07-24
 */
public class FresherTest {

    @Test
    public void test_fresher_WHEN_canHandleCall_THEN_NoException() throws Exception, CanNotHandleCallException {
        // given
        Fresher fresher = new Fresher(1);
        // when
        fresher.answerCall(Constants.FRESHER_CAN_HANDLE_DIFFICULTY - 1);
        // then
        Assert.assertTrue(fresher.isFree());
    }

    @Test(expected = CanNotHandleCallException.class)
    public void test_fresher_WHEN_canNotHandleCall_THEN_NoException() throws Exception, CanNotHandleCallException {
        // given
        Fresher fresher = new Fresher(1);
        // when
        fresher.answerCall(Constants.FRESHER_CAN_HANDLE_DIFFICULTY + 1);
    }

}