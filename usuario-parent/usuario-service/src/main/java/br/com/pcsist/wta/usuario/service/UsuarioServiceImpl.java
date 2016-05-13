package br.com.pcsist.wta.usuario.service;

import javax.inject.Inject;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.pcsist.wta.usuario.api.CadastroUsuario;
import br.com.pcsist.wta.usuario.api.Usuario;
import br.com.pcsist.wta.usuario.api.UsuarioRepository;
import br.com.pcsist.wta.usuario.api.UsuarioService;

/**
 * @author guilherme.pacheco
 */
@OsgiServiceProvider(classes = UsuarioService.class)
public class UsuarioServiceImpl implements UsuarioService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);

  @Inject
  private UsuarioRepository usuarioRepository;

  @Override
  public Usuario cadastrar(CadastroUsuario cadastro) {
    LOGGER.debug("Cadastrando novo usário: {}", cadastro);
    Usuario novoUsuario = novoUsuario(cadastro);
    usuarioRepository.salvar(novoUsuario);
    LOGGER.info("Novo usário cadastrado: {}", cadastro);
    return novoUsuario;
  }

  @Override
  public void atualizar(long id, CadastroUsuario cadastro) {
    System.out.println("Atualizando usuário " + cadastro);
  }

  private Usuario novoUsuario(CadastroUsuario cadastro) {
    LOGGER.debug("Criando novo usário: {}", cadastro);
    Usuario usuario = new Usuario();
    usuario.setEmail(cadastro.getEmail());
    usuario.setNome(cadastro.getNome());
    usuario.setUsername(cadastro.getUsername());
    LOGGER.debug("Novo usário criado: {}", usuario);
    return usuario;
  }

  @Override
  public void deletar(long id) {
    System.out.println("Deletando usuário " + id);
  }

}
