package ic.jms.genesis.employees;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jamesliao
 * @since 2019-07-29
 */
public class TechnicalLeaderTest {
    @Test
    public void test_technicalLeader_WHEN_canHandleCall_THEN_NoException() throws Exception, CanNotHandleCallException {
        // given
        TechnicalLeader technicalLeader = new TechnicalLeader(1);
        // when
        technicalLeader.answerCall(79);
        // then
        Assert.assertTrue(technicalLeader.isFree());
    }

    @Test(expected = CanNotHandleCallException.class)
    public void test_technicalLeader_WHEN_canNotHandleCall_THEN_NoException() throws Exception, CanNotHandleCallException {
        // given
        TechnicalLeader technicalLeader = new TechnicalLeader(1);
        // when
        technicalLeader.answerCall(81);
    }
}