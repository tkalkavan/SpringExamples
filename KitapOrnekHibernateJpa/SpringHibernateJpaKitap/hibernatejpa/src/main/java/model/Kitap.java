package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kitap")
public class Kitap {

	@GeneratedValue
	@Id
	@Column(name = "id")
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}


	@Column(name = "baslik")
	private String baslik;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name= "yazar")
	String yazar;
	
	public Kitap() {
	}

	public Kitap(int id, String baslik, String yazar,String isbn) {
		this.id = id;
		this.baslik = baslik;
		this.yazar = yazar;
		this.isbn=isbn;
		
	}
	
	public Kitap(int id, String baslik, String yazar) {
		this.id = id;
		this.baslik = baslik;
		this.yazar = yazar;

		
	}
	
	public Kitap(String baslik, String yazar) {
		this.baslik = baslik;
		this.yazar = yazar;
	}
	

	@Override
	public String toString() {
		return "Kitap: " + this.id + ", " + this.baslik + ", " + this.yazar + ", " + this.isbn;
	}
	
}