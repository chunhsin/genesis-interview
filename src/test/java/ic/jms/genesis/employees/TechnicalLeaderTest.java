package ic.jms.genesis.employees;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Spy;

import static ic.jms.genesis.Constants.TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY;

/**
 * @author jamesliao
 * @since 2019-07-29
 */
public class TechnicalLeaderTest {

    private final TechnicalLeader technicalLeader = new TechnicalLeader(1);




    @Test
    public void test_technicalLeader_WHEN_canHandleCall_THEN_NoException() throws Exception, CanNotHandleCallException {
        // given
        // when
        technicalLeader.answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
        // then
        Assert.assertTrue(technicalLeader.isFree());
    }

    @Test(expected = CanNotHandleCallException.class)
    public void test_technicalLeader_WHEN_canNotHandleCall_THEN_NoException() throws
                                                                              Exception,
                                                                              CanNotHandleCallException {
        // given
        // when
        technicalLeader.answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY + 1);
    }
}