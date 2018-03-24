package br.com.sysmap.agendaSysmap;

import br.com.sysmap.agendaSysmap.model.Perfil;
import br.com.sysmap.agendaSysmap.model.Usuario;
import br.com.sysmap.agendaSysmap.repository.UsuarioRepository;
import br.com.sysmap.agendaSysmap.service.UsuarioService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaSysmapApplicationTests {

    /*@Test
	public void deveCriarUmUsuario() {
		Usuario usuario = Usuario.builder()
				.nome("Bruno Rolim")
				.perfil(Perfil.LIDER)
				.build();

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(usuario);

		em.getTransaction().commit();
		em.close();

	}

	@Test
	public void deveAssociarUmLiderAUmaEquipe() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 1);

		Equipe equipe = Equipe.builder()
				.lider(usuario)
				.descricao("Equipe 1")
				.build();

		em.persist(equipe);

		em.getTransaction().commit();
		em.close();

	}


	@Test
	public void deveAdicionarUmMembroAUmaEquipe() {
		Usuario usuario = Usuario.builder()
				.nome("Douglas")
				.perfil(Perfil.LIDER)
				.build();

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Equipe equipe = em.find(Equipe.class, 1);

		usuario.setEquipe(equipe);

		em.persist(usuario);

		em.getTransaction().commit();
		em.close();

	}

	@Test
	public void deveCriarNovoCompromissoParaUmUsuario() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 2);

		Date dataInicio = new Date();
		Date dataTermino = new Date();
		Date horaInicio = new Date();
		Date horaTermino = new Date();

		Compromisso compromisso = Compromisso.builder()
				.usuario(usuario)
				.dataInicio(dataInicio)
				.dataTermino(dataTermino)
				.horaInicio(horaInicio)
				.horaTermino(horaTermino)
				.descricao("Compromisso 1")
				.local("Sysmap")
				.build();

		em.persist(compromisso);

		em.getTransaction().commit();
		em.close();
	}
/*/
}
