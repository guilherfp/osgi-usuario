package br.com.pcsist.wta.usuario.repository;

import java.util.concurrent.Executors;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.pcsist.wta.usuario.api.Usuario;
import br.com.pcsist.wta.usuario.api.UsuarioRepository;

/**
 * @author guilherme.pacheco
 */
@Component
public class InitHelper {

  private static final Logger LOGGER = LoggerFactory.getLogger(InitHelper.class);

  @Reference
  private UsuarioRepository usuarioRepository;

  @Activate
  public void checkUsuario() {
    Executors.newSingleThreadExecutor().execute(() -> {
      try {
        System.out.println("Inserindo usuário padrão");
        LOGGER.info("Inserindo usuário padrão");
        if (usuarioRepository.comId(1) == null) {
          addUsuario();
          LOGGER.info("Usuário ID 1 adicionado");
        }
      } catch (Exception ex) {
        LOGGER.warn("Erro ao tentar adicionar usuário 1", ex);
      }
    });
  }

  private void addUsuario() {
    Usuario usuario = new Usuario();
    usuario.setNome("Guilherme Pacheco");
    usuario.setEmail("guilherme.pacheco@pcinformatica.com.br");
    usuario.setUsername("guilherme.pacheco");
    usuarioRepository.salvar(usuario);
  }

}
