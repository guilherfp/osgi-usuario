package br.com.pcsist.wta.usuario.api;

import java.util.List;

/**
 * @author guilherme.pacheco
 */
public interface UsuarioRepository {

  Usuario comId(long id);

  List<Usuario> todos();

  void salvar(Usuario usuario);

  void remover(Usuario usuario);

}
