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
		
		profissionalDB.getServicos().add(servico);

		servico.setProfissional(profissionalDB);

		session.persist(servico);

		session.getTransaction().commit();
		session.close();
	}

	protected void inserirSolicitacao(Cliente cliente, Profissional profissional, Solicitacao solicitacao) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Cliente clienteDB = session.get(Cliente.class, cliente.getId());
		Profissional profissionalDB = session.get(Profissional.class, profissional.getId());

		clienteDB.getSolicitacoes().add(solicitacao);
		profissionalDB.getSolicitacoes().add(solicitacao);

		solicitacao.setCliente(clienteDB);
		solicitacao.setProfissional(profissionalDB);

		session.persist(solicitacao);

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

	protected List<Profissional> lerTodosProfissionais() {
		setup();
		Session session = sessionFactory.openSession();

		List<Profissional> listaPro = session.createQuery("from Profissional", Profissional.class).getResultList();

		session.close();
		return listaPro;
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

	protected List<Cliente> lerTodosClientes() {
		setup();
		Session session = sessionFactory.openSession();

		List<Cliente> listaClientes = session.createQuery("from Cliente", Cliente.class).getResultList();

		session.close();
		return listaClientes;
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

	protected List<Solicitacao> lerTodasSolicitacoes() {
		setup();
		Session session = sessionFactory.openSession();

		List<Solicitacao> listaSolicitacoes = session.createQuery("from Solicitacao", Solicitacao.class).getResultList();

		session.close();
		return listaSolicitacoes;
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
    GereDados gereDados = new GereDados();
    Cliente cliente = new Cliente("DILVADO", "DIVALD@gmail.com", "DIDI", "divaldo's home", UserType.CLIENTE, MetodoPagamento.MBWAY);
    Profissional profissional = new Profissional("Devysson", "devyssonsc@gmail.com", "senha123", "Porto", UserType.PROFISSIONAL, "Programação", 5, MetodoPagamento.MBWAY);
    Profissional profissional2 = new Profissional("Joao", "joaoMesquista@gmail.com", "senha123", "Porto", UserType.PROFISSIONAL, "Programação", 5, MetodoPagamento.MBWAY);
    Solicitacao solicitacao = new Solicitacao(cliente, profissional, data);
	       
	
		Servico servico = new Servico();
		servico.setData(data);
		servico.setDescricao("Ensinamento de Matemática básica para alunos do fundamental");
		servico.setProfissional(null);
		servico.setTitulo("Professor Particular");
		servico.setValorHora(15.2);

		//Create
	    gereDados.inserir(profissional);
	    gereDados.inserir(profissional2);
	    gereDados.inserir(cliente);

		//Read
		//Utilizador divaldo = gere.lerUtilizador("devysson@gmail.com");

		//Update
		//gere.alterarNomeUtilizador(divaldo, "divaldinho");
		// gere.alterarSenhaUtilizador(gere.lerProfissional("joaoMesquista@gmail.com"), "dilvadinho");
		
		//List<Servico> servicos = gere.lerServicos(prof.getId());
		//System.out.println(servicos);

		//Delete
		//gere.deletar(gere.lerProfissional("joaoMesquista@gmail.com"));
		
		//para inserir Servico, é preciso ler o profissional antes
		Profissional prof = gereDados.lerProfissional("devyssonsc@gmail.com");
		gereDados.inserirServico(prof, servico);
	}	
}