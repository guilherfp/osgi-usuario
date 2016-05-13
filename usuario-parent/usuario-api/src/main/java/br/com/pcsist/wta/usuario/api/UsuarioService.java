package br.com.pcsist.wta.usuario.api;

/**
 * @author guilherme.pacheco
 */
public interface UsuarioService {

  Usuario cadastrar(CadastroUsuario cadastro);

  void atualizar(long id, CadastroUsuario cadastro);

  void deletar(long id);

}
