package br.com.pcsist.wta.usuario.repository;

import static java.lang.System.getProperties;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.pcsist.wta.usuario.api.Usuario;

/**
 * @author guilherme.pacheco
 */
public class UsuarioRepositoryImplTest {

  private UsuarioRepositoryImpl usuarioRepository;
  private EntityManager em;

  /**
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("usuarios", getProperties());
    usuarioRepository = new UsuarioRepositoryImpl();
    em = emf.createEntityManager();
    usuarioRepository.jpa = new SimpleJpaTemplate(em);
  }

  @Test
  public void testLeiturEEscrita() throws Exception {
    em.getTransaction().begin();

    Usuario usuario = new Usuario();
    usuario.setNome("Guilherme Pacheco");
    usuario.setEmail("guilherme.pacheco@pcinformatica.com.br");
    usuario.setUsername("guilherme.pacheco");
    usuario.setSenha("senha");
    usuarioRepository.salvar(usuario);

    em.getTransaction().commit();

    List<Usuario> todos = usuarioRepository.todos();
    assertEquals(1, todos.size());
    Usuario usuario1 = todos.get(0);
    assertEquals(1L, usuario1.getId());
    assertEquals("guilherme.pacheco", usuario1.getUsername());
  }

}
