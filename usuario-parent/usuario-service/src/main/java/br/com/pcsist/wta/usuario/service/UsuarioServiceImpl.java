package br.com.pcsist.wta.usuario.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.pcsist.wta.usuario.api.CadastroUsuario;
import br.com.pcsist.wta.usuario.api.Usuario;
import br.com.pcsist.wta.usuario.api.UsuarioRepository;
import br.com.pcsist.wta.usuario.api.UsuarioService;

/**
 * @author guilherme.pacheco
 */
@Component
public class UsuarioServiceImpl implements UsuarioService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);

  @Reference
  UsuarioRepository usuarioRepository;

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
    usuario.setSenha(cadastro.getSenha());
    LOGGER.debug("Novo usário criado: {}", usuario);
    return usuario;
  }

  @Override
  public void deletar(long id) {
    LOGGER.debug("Deletando usuário ID: {}", id);
    Usuario usuario = usuarioRepository.comId(id);
    usuarioRepository.remover(usuario);
    LOGGER.debug("Deletado ususário ID: {}", id);
  }

}
