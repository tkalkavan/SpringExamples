import service.DoublerComputerImpl;
import service.SquarerComputerImpl;

public class ClientAppMain {


    public static void main(String args[]){

        //Call interface that implements
        new Client().addComputers(new DoublerComputerImpl()).addComputers(new SquarerComputerImpl()).computeAllComputerPowers(8);


    }



}
