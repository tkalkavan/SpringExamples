import service.IComputer;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public List<IComputer> computerList = new ArrayList<IComputer>();

    public Client addComputers(IComputer computer) {
        computerList.add(computer);
        return Client.this;
    }

    public void computeAllComputerPowers(long value) {

        for (IComputer c : computerList) {
            String name = c.getClass().getSimpleName();
            System.out.println("Computer: " + name + ", value: " + value + " computed value: " + c.compute(value));

        }
    }
}
