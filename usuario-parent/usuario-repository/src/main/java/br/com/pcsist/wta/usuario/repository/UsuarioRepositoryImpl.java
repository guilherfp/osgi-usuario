package br.com.pcsist.wta.usuario.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.osgi.service.component.annotations.Component;

import br.com.pcsist.wta.usuario.api.Usuario;
import br.com.pcsist.wta.usuario.api.UsuarioRepository;

/**
 * @author guilherme.pacheco
 */
@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {

  @PersistenceContext(unitName = "usuarios")
  EntityManager em;

  @Override
  public Usuario comId(long id) {
    return em.find(Usuario.class, id);
  }

  @Override
  public List<Usuario> todos() {
    CriteriaQuery<Usuario> query = em.getCriteriaBuilder().createQuery(Usuario.class);
    return em.createQuery(query.select(query.from(Usuario.class))).getResultList();
  }

  @Override
  public void salvar(Usuario usuairo) {
    em.merge(usuairo);
  }

  @Override
  public void remover(Usuario usuairo) {
    em.remove(usuairo);
  }

}
