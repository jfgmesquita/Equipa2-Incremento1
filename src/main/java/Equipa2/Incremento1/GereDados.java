package Equipa2.Incremento1;
import java.util.UUID;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

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

	protected void inserirServico(Profissional profissional, Servico servico) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Profissional profissionalDB = session.get(Profissional.class, profissional.getId());
		servico.setProfissional(profissionalDB);
		session.persist(servico);

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

	protected void alterarSenhaUtilizador(Utilizador utilizador, String novaSenha) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Utilizador utilizadorDB = session.get(Utilizador.class, utilizador.getId());
		utilizadorDB.setPassword(novaSenha);

		session.getTransaction().commit();
		session.close();
	}

	protected Profissional lerProfissional(String email){
		setup();
		Session session = sessionFactory.openSession();

		Profissional profissional = session.createQuery("from Profissional u where u.email = :email", Profissional.class)
					.setParameter("email", email)
					.getSingleResult();

		session.close();
		return profissional;

	}

	protected Cliente lerCliente(String email){
		setup();
		Session session = sessionFactory.openSession();

		Cliente cliente = session.createQuery("from Cliente u where u.email = :email", Cliente.class)
					.setParameter("email", email)
					.getSingleResult();

		session.close();
		return cliente;

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

	protected List<Servico> lerServicos(UUID id){
		setup();
		Session session = sessionFactory.openSession();

		Profissional profissional = session.get(Profissional.class, id);
		List<Servico> lista = new ArrayList<Servico>();
		lista = session.createQuery("from Servico u where u.profissional = :profissional_id", Servico.class)
				.setParameter("profissional_id", profissional)
				.getResultList();

		session.close();
		return lista;
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
	    new Avaliacao(5, "Otimo serviço!", solicitacao);
	       
	
		Servico servico = new Servico();
		servico.setData(LocalDateTime.now());
		servico.setDescricao("Ensinamento de Matemática básica para alunos do fundamental");
		servico.setProfissional(null);
		servico.setTitulo("Professor Particular");
		servico.setValorHora(15.2);

		//Create
	    //gere.inserir(profissional2);

		//Read
		//Utilizador divaldo = gere.lerUtilizador("devysson@gmail.com");

		//Update
		//gere.alterarNomeUtilizador(divaldo, "divaldinho");
		gere.alterarSenhaUtilizador(gere.lerProfissional("joaoMesquista@gmail.com"), "dilvadinho");
		
		//List<Servico> servicos = gere.lerServicos(prof.getId());
		//System.out.println(servicos);

		//Delete
		//gere.deletar(gere.lerProfissional("joaoMesquista@gmail.com"));
		
		//para inserir Servico, é preciso ler o profissional antes
		//Profissional prof = gere.lerProfissional("joaoMesquista@gmail.com");
		//gere.inserirServico(prof, servico);
	}	
}