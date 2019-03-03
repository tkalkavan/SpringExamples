package clientStateful;

import bean.StatefulEJB;

import javax.ejb.EJB;

public class ClientNumberOne {
    @EJB
    public StatefulEJB statefulEJB;
}
