package clientStateless;

import bean.StatelessEJB;

import javax.ejb.EJB;

public class ClientNumberOne {

    @EJB
    public StatelessEJB statelessEJB;
}
