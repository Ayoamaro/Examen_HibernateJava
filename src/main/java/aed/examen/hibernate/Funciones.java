package aed.examen.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aed.examen.hibernate.tablas.Categorias;
import aed.examen.hibernate.tablas.Componentes;
import aed.examen.hibernate.tablas.DesComponente;

/**
 * @author Ayoze Amaro
 *
 */
public class Funciones {
	
	private static Scanner sc = new Scanner(System.in);
	private static String pattern = "yyyy-MM-dd";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	public static void insertarCategorias() {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		Categorias newCategoria1 = new Categorias("PDN", "Hardware");
		Categorias newCategoria2 = new Categorias("SDN", "Software");
		Categorias newCategoria3 = new Categorias("TDN", "Periféricos");
		
		sesion.beginTransaction();
		sesion.save(newCategoria1);
		sesion.save(newCategoria2);
		sesion.save(newCategoria3);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void insertarComponenteSinDescripcion() throws ParseException {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		Categorias categoria = sesion.get(Categorias.class, "SDN");
		String nombre = "Procesador";
		Integer precio = 250;
		Date fecha = simpleDateFormat.parse("2014-12-15");
		Boolean activo = false;
		
		Componentes newComponente = new Componentes(categoria, nombre, precio, fecha, activo);
		
		sesion.beginTransaction();
		sesion.save(newComponente);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public static void insertarComponenteConDescripcion() throws ParseException {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		Categorias categoria = sesion.get(Categorias.class, "TDN");
		String nombre = "Teclado";
		Integer precio = 70;
		Date fecha = simpleDateFormat.parse("2018-06-22");
		Boolean activo = true;
		String descripcion = "Con Switch Cherry BLUE de calidad suprema";
		
		Componentes newComponente = new Componentes(categoria, nombre, precio, fecha, activo);
		DesComponente newDescomponente = new DesComponente(descripcion);

		newComponente.setDesComponenteXXX(newDescomponente);
		newDescomponente.setComponenteXXX(newComponente);
		sesion.beginTransaction();
		sesion.save(newComponente);
		sesion.save(newDescomponente);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public static void eliminarComponente(String codComponente) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Query q = sesion.createQuery("from Componentes where codComponente = " + codComponente);
		
		try {
			sesion.beginTransaction();
			Componentes consulta = (Componentes) q.getSingleResult();
			sesion.delete(consulta);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e);
		}
		sesion.close();
		
	}
	
	public static void listarCategorias() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		Query q = sesion.createQuery("from Categorias");
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("LISTADO DE LAS CATEGORÍAS");
		System.out.println("");
		
		try {
			List<Categorias> listaCategorias = q.getResultList();
			
			for (Categorias categorias : listaCategorias) {
				System.out.println(categorias.toString());
				System.out.println("");
			}
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		sesion.close();
	}

	public static void listarComponentes() {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		Query q = sesion.createQuery("from Componentes");
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("LISTADO DE LOS COMPONENTES");
		System.out.println("");
		
		try {
			List<Componentes> listaComponentes = q.getResultList();
			
			for (Componentes componentes : listaComponentes) {
				System.out.println(componentes.toString());

				DesComponente ob = componentes.getDesComponenteXXX();
				if (ob != null) {
					System.out.print("\t- Descripción: ");
					System.out.println(ob.toString());
				}
				System.out.println("");
			}
		} catch (Exception e) {
			sesion.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("");
		sesion.close();
	}
}
