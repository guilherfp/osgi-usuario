
package br.com.pcsist.wta.usuario.command;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.pcsist.wta.usuario.api.Usuario;
import br.com.pcsist.wta.usuario.api.UsuarioRepository;

@Service
@Command(scope = "usuario", name = "list", description = "Listar Usuários")
public class ListUsuarios implements Action {

  private static final Logger LOGGER = LoggerFactory.getLogger(ListUsuarios.class);

  @Option(name = "-o", aliases = { "--option" }, description = "An option to the command",
      required = false, multiValued = false)
  private String option;

  @Argument(name = "argument", description = "Argument to the command", required = false,
      multiValued = false)
  private String argument;

  @Reference
  UsuarioRepository usuarioRepository;

  @Override
  public Object execute() throws Exception {
    System.out.println("Listando usuarios");
    try {
      for (Usuario usuario : usuarioRepository.todos()) {
        System.out.println(usuario.toString());
      }
    } catch (Exception ex) {
      LOGGER.error("Erro ao listar usuários", ex);
    }
    return null;
  }

}
