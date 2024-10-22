package Equipa2.Incremento1;
import java.util.UUID;
import java.time.LocalDateTime;

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
            System.out.println("erro: " + ex.toString());
            StandardServiceRegistryBuilder.destroy(registry);
        }
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	protected void inserir(Object objeto) {
		setup();
	    Session session = sessionFactory.openSession();
		session.beginTransaction();

	    session.persist(objeto);

		session.getTransaction().commit();
		session.close();
	}

	protected void alterarNomeUtilizador(Utilizador utilizador, String novoNome) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Utilizador utilizadorDB = session.get(Utilizador.class, utilizador.getId());
		utilizadorDB.setNome(novoNome);

		session.getTransaction().commit();
		session.close();
	}

	protected Utilizador lerUtilizador(String email){
		setup();
		Session session = sessionFactory.openSession();

		Utilizador utilizador = session.createQuery("from Utilizador u where u.email = :email", Utilizador.class)
					.setParameter("email", email)
					.getSingleResult();

		session.close();
		return utilizador;

	}
	
	protected void deletar(Object object) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		
		session.delete(object);
		
		session.getTransaction().commit();
		session.close();
	}
	 
	public static void main(String[] args) {
		LocalDateTime data = LocalDateTime.now();
	    GereDados gere = new GereDados();
	    Cliente cliente = new Cliente("DILVADO", "DIVALD@gmail.com", "DIDI", "divaldo's home", MetodoPagamento.MBWAY);
	    Profissional profissional = new Profissional("Devysson", "devysson@gmail.com", "senha123", "Porto", "Programação", 5, MetodoPagamento.MBWAY);
	    Profissional profissional2 = new Profissional("Joao", "joaoMesquista@gmail.com", "senha123", "Porto", "Programação", 5, MetodoPagamento.MBWAY);
	    Pagamento pagamento = new Pagamento(50.5, cliente, profissional, MetodoPagamento.MBWAY);
	    Solicitacao solicitacao = new Solicitacao(cliente, profissional, "Universidade Do Porto", pagamento, data);
	    Avaliacao avaliacao = new Avaliacao(5, "Otimo serviço!", solicitacao);
	       
	
		//Create
	    //gere.inserir(cliente);
		//Read
		Utilizador divaldo = gere.lerUtilizador("DIVALD@gmail.com");
		//Update
		//gere.alterarNomeUtilizador(divaldo, "divaldinho");
		//Delete
		gere.deletar(divaldo);

	}
}