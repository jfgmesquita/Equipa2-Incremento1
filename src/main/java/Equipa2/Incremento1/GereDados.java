package Equipa2.Incremento1;

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
			 } 
			 catch (Exception ex) {
			 System.out.println("erro: " + ex.toString());
			 StandardServiceRegistryBuilder.destroy(registry);
			 }
				 //session.persist(new Solicitacao(new Cliente("Thiago", "thiago@gmail", "teste", "rio tinto", "dinheiro"), new Profissional("luh", "luh@gmail", "teste2", "Gondomar", "arte", 2, 30), "em casa", new Pagamento(), "15:30 28-10-2024"));
				
	 }
	
	 protected void inserir(Object objeto) {
		 setup();
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 session.persist(objeto);
		 session.getTransaction().commit();
		 session.close();
	 }
	 protected void alterarNomeUtilizador(int id, String novoNome) {
		 setup();
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 Utilizador utilizador = session.get(Utilizador.class, id);
		 utilizador.setNome(novoNome);
		 session.getTransaction().commit();
		 session.close();
	 }
	 protected void deletar() {
		 
		 
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
	       
	       System.out.println(cliente.getClass());
   	       //gere.alterarNomeUtilizador(2, "divaldinho junior");
//	       gere.setup();
//	       Session session = gere.sessionFactory.openSession();
//	       session.beginTransaction();
//	       Cliente alterar = session.get(Cliente.class, 2);
//	       alterar.setNome("teste");
	       gere.inserir(profissional2);
//	       session.getTransaction().commit();
//	       session.close();
   	       
	    }
}
