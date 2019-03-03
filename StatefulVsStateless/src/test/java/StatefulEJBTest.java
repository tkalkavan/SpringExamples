import bean.StatefulEJB;
import clientStateful.ClientNumberOne;
import clientStateful.ClientNumberTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class StatefulEJBTest {

    @InjectMocks
    private ClientNumberOne clientNumberOne;

    @InjectMocks
    private ClientNumberTwo clientNumberTwo;

    @Mock
    private StatefulEJB statefulEJB;

    @Test
    public void givenOneStatefulBean_whenTwoClientsSetValueOnBean_thenClientStateIsMaintained() {

        clientNumberOne.statefulEJB.name = "Client 1";
        clientNumberTwo.statefulEJB.name = "Client 2";


        assertNotEquals(clientNumberOne.statefulEJB.name, clientNumberTwo.statefulEJB.name);
        assertEquals("Client 1", clientNumberOne.statefulEJB.name);
        assertEquals("Client 2", clientNumberTwo.statefulEJB.name);
    }
}
