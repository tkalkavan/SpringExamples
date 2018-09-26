package service;

/*
KitapService.java class is the service which makes use of the DAO object to interact with the database
The DAO object is a static field in the service, initialized in the service constructor. So, when a new service instance is created, a new DAO instance will also be created.

 * 
 * In each one of the service methods, the kitapDao object is used to open/close a session or a session with transaction, and to perform each one of the CRUD actions described above. 
 * In this layer all the transactions are handled. 
 * For example, persist, update and delete methods must follow the openSessionWithTransaction() method, whereas, findById and findAll methods only need the openSession() method.
 * 
 * 
 * */

import java.util.List;

import dao.KitapDAO;
import model.Kitap;

public class KitapServis{

	private static KitapDAO kitapDao;

	public KitapServis() {
		kitapDao = new KitapDAO();
	}

	public void persist(Kitap entity) {
		kitapDao.openCurrentSessionwithTransaction();
		kitapDao.persist(entity);
		kitapDao.closeCurrentSessionwithTransaction();
	}

	public void update(Kitap entity) {
		kitapDao.openCurrentSessionwithTransaction();
		kitapDao.update(entity);
		kitapDao.closeCurrentSessionwithTransaction();
	}

	public Kitap findById(Integer id) {
		kitapDao.openCurrentSession();
		Kitap book = kitapDao.findById(id);
		kitapDao.closeCurrentSession();
		return book;
	}

	public void delete(Integer id) {
		kitapDao.openCurrentSessionwithTransaction();
		Kitap book = kitapDao.findById(id);
		kitapDao.delete(book);
		kitapDao.closeCurrentSessionwithTransaction();
	}

	public List<Kitap> findAll() {
		kitapDao.openCurrentSession();
		List<Kitap> books = kitapDao.findAll();
		kitapDao.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		kitapDao.openCurrentSessionwithTransaction();
		kitapDao.deleteAll();
		kitapDao.closeCurrentSessionwithTransaction();
	}

	public KitapDAO kitapDao() {
		return kitapDao;
	}
}
