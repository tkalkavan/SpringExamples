package clientStateful;

import bean.StatefulEJB;

import javax.ejb.EJB;

public class ClientNumberTwo {
    @EJB
    public StatefulEJB statefulEJB;
}
