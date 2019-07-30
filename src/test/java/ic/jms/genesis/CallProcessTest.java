package ic.jms.genesis;

import ic.jms.genesis.employees.CanNotHandleCallException;
import ic.jms.genesis.employees.Fresher;
import ic.jms.genesis.employees.ProductManager;
import ic.jms.genesis.employees.TechnicalLeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static ic.jms.genesis.Constants.FRESHER_CAN_HANDLE_DIFFICULTY;
import static ic.jms.genesis.Constants.TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;

/**
 * @author jamesliao
 * @since 2019-07-30
 */
@RunWith(MockitoJUnitRunner.class)
public class CallProcessTest {

    @Mock
    private Fresher fresher;
    @Mock
    private TechnicalLeader technicalLeader;
    @Mock
    private ProductManager productManager;

    @InjectMocks
    CallProcess callProcess = new CallProcess(fresher, technicalLeader, productManager);

    @Test
    public void test_callProcess_WHEN_fresherCanHandle_THEN_fresherFinish() throws
                                                                            Exception,
                                                                            CanNotHandleCallException {
        // given
        Mockito.when(fresher.isFree())
               .thenReturn(true);
        // when
        callProcess.handleInComingCall(FRESHER_CAN_HANDLE_DIFFICULTY);
        // then
        Mockito.verify(fresher, times(1))
               .answerCall(FRESHER_CAN_HANDLE_DIFFICULTY);
        Mockito.verify(technicalLeader, times(0))
               .answerCall(FRESHER_CAN_HANDLE_DIFFICULTY);
        Mockito.verify(productManager, times(0))
               .answerCall(FRESHER_CAN_HANDLE_DIFFICULTY);
    }

    @Test
    public void test_callProcess_WHEN_fresherCannotHandle_THEN_techLeaderFinish() throws
                                                                                  Exception,
                                                                                  CanNotHandleCallException {
        // given
        doThrow(new CanNotHandleCallException()).when(fresher)
                                                .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);

        Mockito.when(technicalLeader.isFree())
               .thenReturn(true);
        // when
        callProcess.handleInComingCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
        // then
        Mockito.verify(fresher, times(1))
               .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
        Mockito.verify(technicalLeader, times(1))
               .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
        Mockito.verify(productManager, times(0))
               .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
    }
    @Test
    public void test_callProcess_WHEN_techLeadIsNotFree_THEN_ProductManagerFinish() throws
                                                                                  Exception,
                                                                                  CanNotHandleCallException {
        // given
        doThrow(new CanNotHandleCallException()).when(fresher)
                                                .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);

        Mockito.when(technicalLeader.isFree())
               .thenReturn(false);
        Mockito.when(productManager.isFree())
               .thenReturn(true);
        // when
        callProcess.handleInComingCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
        // then
        Mockito.verify(fresher, times(1))
               .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
        Mockito.verify(technicalLeader, times(0))
               .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
        Mockito.verify(productManager, times(1))
               .answerCall(TECHNICAL_LEADER_CAN_HANDLE_DIFFICULTY);
    }

}