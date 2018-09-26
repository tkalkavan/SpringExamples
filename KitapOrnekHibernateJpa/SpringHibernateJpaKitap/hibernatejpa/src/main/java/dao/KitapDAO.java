package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/*
 * 
 * NOTE: EntityManagerFactory is similar to SessionFactory.
 *  As you obtain Session object from SessionFactory, you can obtain EntityManager from EntityManagerFactory.
 * 
 * */



import model.Kitap;
//Dao class, which contains all the basic CRUD methods to interact with the database.
public class KitapDAO implements KitapDAOInterface<Kitap, Integer> {
	//SessionFactory, the basic interfaces between a Java application and Hibernate.
	private Session currentSession;
	private Transaction currentTransaction;

	public KitapDAO() {
	}

	//Both methods use the openSession() API method of SessionFactory. 
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	//But the second one also opens a new transaction, 
	//making use of the beginTransaction() API method of Session.
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
/*				CRUD
 * Create is done in persist(Book entity) method, with save(Object object) API method of Session
 * Read is performed both in findById(String id) and in findAll() methods. findById method uses get(Class theClass, Serializable id) API method of Session to retrieve an object by its id
 * Update is easily done in update(Book entity) method that uses update(Object object) API method of Session
 * Delete is performed in delete(Book entity) and deleteAll() methods, using the findById(String id) and findAll() methods respectively to retrieve the objects from the database and then using delete(Object object) API method of Session
 * 
 * */
	public void persist(Kitap entity) {
		getCurrentSession().save(entity);
	}

	public void update(Kitap entity) {
		getCurrentSession().update(entity);
	}

	public Kitap findById(Integer id) {
		Kitap book = (Kitap) getCurrentSession().get(Kitap.class, id);
		return book; 
	}

	public void delete(Kitap entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Kitap> findAll() {
		List<Kitap> books = (List<Kitap>) getCurrentSession().createQuery("from Kitap").list();
		return books;
	}

	public void deleteAll() {
		List<Kitap> entityList = findAll();
		for (Kitap entity : entityList) {
			delete(entity);
		}
	}

	

	
}