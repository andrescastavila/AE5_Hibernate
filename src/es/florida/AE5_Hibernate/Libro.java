package es.florida.AE5_Hibernate;

public class Libro {
	private int id;
	private String titol;
	private String autor;
	private int any_naix;
	private int any_publicacion;
	private String editorial;
	private int pagines;
	
	public Libro() {
		
	}
	
	public Libro(int id, String titol, String autor, int any_naix, int any_publicacion, String editorial, int pagines) {
		this.id=id;
		this.titol=titol;
		this.autor=autor;
		this.any_naix=any_naix;
		this.any_publicacion=any_publicacion;
		this.editorial=editorial;
		this.pagines=pagines;
	}
	
	public Libro(String titol, String autor, int any_naix, int any_publicacion, String editorial, int pagines) {
		this.titol=titol;
		this.autor=autor;
		this.any_naix=any_naix;
		this.any_publicacion=any_publicacion;
		this.editorial=editorial;
		this.pagines=pagines;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public String getTitol() {
		return titol;
	}
	
	public void setTitol(String titol) {
		this.titol=titol;
	}
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor=autor;
	}
	public int getAny_naix() {
		return any_naix;
	}
	
	public void setAny_naix(int any_naix) {
		this.any_naix=any_naix;
	}
	public int getAny_publicacion() {
		return any_publicacion;
	}
	
	public void setAny_publicacion(int any_publicacion) {
		this.any_publicacion=any_publicacion;
	}
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial=editorial;
	}
	public int getPagines() {
		return pagines;
	}
	
	public void setPagines(int pagines) {
		this.pagines=pagines;
	}
	
	public String toString() {
		return("Objeto libro -> id: " + getId() + ", titulo: " + getTitol() + ", autor: " + getAutor() + ", any naixement: " + getAny_naix() + ", any publicacio: " + getAny_publicacion() + ", editorial: " + getEditorial() + " y  numero de pagines " + getPagines());
	}
	
	
}
