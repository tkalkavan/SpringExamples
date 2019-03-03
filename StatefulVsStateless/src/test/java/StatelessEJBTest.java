import bean.StatelessEJB;
import clientStateless.ClientNumberOne;
import clientStateless.ClientNumberTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StatelessEJBTest {

    @InjectMocks
    private ClientNumberOne clientNumberOne;

    @InjectMocks
    private ClientNumberTwo clientNumberTwo;

    @Mock
    private StatelessEJB statelessEJB;

    @Test
    public void givenOneStatelessBean_whenStateIsSetInOneBean_secondBeanShouldHaveSameState() {

        clientNumberOne.statelessEJB.name = "Client 1";

        assertEquals("Client 1", clientNumberOne.statelessEJB.name);
        assertEquals("Client 1", clientNumberTwo.statelessEJB.name);
    }

    @Test
    public void givenOneStatelessBean_whenStateIsSetInBothBeans_secondBeanShouldHaveSecondBeanState() {

        clientNumberOne.statelessEJB.name = "Client 1";
        clientNumberTwo.statelessEJB.name = "Client 2";

        //Client one changed also
        assertEquals("Client 2", clientNumberTwo.statelessEJB.name);
        assertEquals("Client 2", clientNumberOne.statelessEJB.name);
    }
}
