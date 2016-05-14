package br.com.pcsist.wta.usuario.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.apache.aries.jpa.template.JpaTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import br.com.pcsist.wta.usuario.api.Usuario;
import br.com.pcsist.wta.usuario.api.UsuarioRepository;

/**
 * @author guilherme.pacheco
 */
@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {

  @Reference(target = "(osgi.unit.name=usuarios)")
  JpaTemplate jpa;

  @Override
  public Usuario comId(long id) {
    return jpa.txExpr(em -> em.find(Usuario.class, id));
  }

  @Override
  public List<Usuario> todos() {
    return jpa.txExpr(em -> {
      CriteriaQuery<Usuario> query = em.getCriteriaBuilder().createQuery(Usuario.class);
      return em.createQuery(query.select(query.from(Usuario.class))).getResultList();
    });
  }

  @Override
  public void salvar(Usuario usuairo) {
    jpa.tx(em -> {
      em.persist(usuairo);
      em.flush();
    });
  }

  @Override
  public void remover(Usuario usuairo) {
    jpa.tx(em -> em.remove(usuairo));
  }

  @Override
  public void atualizar(Usuario usuairo) {
    jpa.tx(em -> em.merge(usuairo));
  }

}
