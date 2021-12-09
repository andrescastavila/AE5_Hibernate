package es.florida.AE5_Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import es.florida.AE5_Hibernate.Libro;



public class Principal {
	
	public static void llamarLibros() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libro.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List listaLibros = new ArrayList();
		listaLibros = session.createQuery("From Libro").list();
		for(Object obj : listaLibros) {
			Libro libro = (Libro) obj;
			System.out.println(libro.toString());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	public static void buscarLibro() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libro.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int idlibro;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digame la id del libro que quiere: ");
		idlibro=teclado.nextInt();
		Libro libro2 = (Libro) session.get(Libro.class, idlibro);
		if(libro2 == null) {
			System.out.println("No hay libros con id " + idlibro);
		}else {
			System.out.println("Informacion del libro: Titulo " + libro2.getTitol() + " Autor: " + libro2.getAutor() + " Any de naixement: " + libro2.getAny_naix()
			+ " Any de publicacio: " + libro2.getAny_publicacion() + " Editorial: " + libro2.getEditorial() + " Numero de pagines: " + libro2.getPagines());
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	public static void crearLibro() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libro.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime el titulo del libro");
		String titulo = teclado.next();
		System.out.print("Dime el autor del libro");
		String autor=teclado.next();
		System.out.print("Dime el any de naixement del autor:");
		int any_naix = teclado.nextInt();
		System.out.print("Dime el any de publicacio del llibre:");
		int any_publicacio = teclado.nextInt();
		System.out.print("Dime la editorial del llibre:");
		String editorial = teclado.next();
		System.out.print("Dime el numero de pagines del llibre:");
		int pagines = teclado.nextInt();

		Libro libro1 = new Libro(titulo,autor,any_naix,any_publicacio,editorial,pagines);
		session.persist(libro1);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	public static void actualizarLibro() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libro.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime la ID del llibre que vols actualizar");
		int id = teclado.nextInt();
		System.out.println("Actualizar datos (introducir 'igual' (si es un numero introducir 0) para preservar valor): ");
		try {
		Libro libro= (Libro) session.load(Libro.class, id);
		
		System.out.print("Actualizar título: "); 
		String nuevoTitulo = teclado.next();
		if (!nuevoTitulo.equals("igual")) {
			libro.setTitol(nuevoTitulo);
		}
		
		System.out.print("Actualizar autor: ");
		String nuevoAutor = teclado.next();
		if (!nuevoAutor.equals("igual")) {
			libro.setAutor(nuevoAutor);
		}
		
		System.out.print("Actualizar any naixement: ");
		int nuevoAnynaix = teclado.nextInt();
		if (nuevoAnynaix!=0) {
			libro.setAny_naix(nuevoAnynaix);
		}
		
		System.out.print("Actualizar any publicacio: ");
		int nuevoAnypubli = teclado.nextInt();
		if (nuevoAnypubli!=0) {
			libro.setAny_publicacion(nuevoAnypubli);
		}
		
		System.out.print("Actualizar editorial: ");
		String nuevoEditorial = teclado.next();
		if (!nuevoEditorial.equals("igual")) {
			libro.setEditorial(nuevoEditorial);
		}
		
		System.out.print("Actualizar pagines: ");
		int nuevoPagines = teclado.nextInt();
		if (nuevoPagines!=0) {
			libro.setPagines(nuevoPagines);
		}
		
		session.update(libro);
		System.out.println("Actualicados datos del libro: " + libro.getTitol());
	}catch ( Exception e) {
		System.out.println("No se ha podido actualizar el libro");
		e.printStackTrace();
	}
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void borrarLibro() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libro.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			Libro libro = new Libro();
			Scanner teclado = new Scanner(System.in);
			System.out.print("Introduzca la ID del libro que deseas borrar: ");
			int id = teclado.nextInt();
			libro.setId(id);
			session.delete(libro);
			System.out.println("Borrado libro " + id);
		}catch(Exception e) {
			System.out.println("Excepcion: No se ha podido borrar el libro.");
			e.printStackTrace();
		}
		
		
		
		session.getTransaction().commit();
		session.close();
	}
	

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		

		while (opcion != 6) {
			System.out.println("\n\n=============================================");
			System.out.println("              MENÚ BIBLIOTECA");
			System.out.println("=============================================");
			System.out.println("1. Mostrar todos los títulos de la biblioteca");
			System.out.println("2. Mostrar información detallada de un libro");
			System.out.println("3. Crear nuevo libro");
			System.out.println("4. Actualizar libro");
			System.out.println("5. Borrar libro");
			System.out.println("6. Cerrar la biblioteca");
			System.out.print("\n >>> Elegir una opción: ");
			opcion = Integer.parseInt(teclado.next());
			switch(opcion) {
			case 1:
				llamarLibros();
				break;
			case 2:
				buscarLibro();
				break;
			case 3:
				crearLibro();
				break;
			case 4:
				actualizarLibro();
				break;
			case 5:
				borrarLibro();
				break;
			case 6:
				System.out.println("Bye!");
				teclado.close();
				break;
			default:
				break;	
			}
		}
	}
	
	
	

}
