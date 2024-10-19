package Equipa2.Incremento1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class GereDados {

	protected SessionFactory sessionFactory;
	public void setup() {
	 // code to load Hibernate Session factory
		
		 final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				 .configure() // configures settings from hibernate.cfg.xml
				 .build();
			 try {
			 sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			 } catch (Exception ex) {
				 System.out.println("removido: " + ex.toString());
			 StandardServiceRegistryBuilder.destroy(registry);
		}
				 Session session = sessionFactory.openSession();
				 session.beginTransaction();
	 }
	 protected void exit() {
	 // code to close Hibernate Session factory
		 sessionFactory.close();
	 }
	 protected void create() {
	 // code to save a book
	 }
	 protected void read() {
	 // code to get a book
	 }
	 protected void update() {
	 // code to modify a book
	 }
	 protected void delete() {
	 // code to remove a book
	 }
	 public static void main(String[] args) {
	 // code to run the program
		 GereDados manager = new GereDados();
		 manager.setup();
		 
		 manager.exit();
		 
	 }
	}
