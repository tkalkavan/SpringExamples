package clientStateless;

import bean.StatelessEJB;

import javax.ejb.EJB;

public class ClientNumberTwo {
    @EJB
    public StatelessEJB statelessEJB;
}
