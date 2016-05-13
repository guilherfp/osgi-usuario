
package br.com.pcsist.wta.usuario.command;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Service
@Command(scope = "usuario", name = "list", description = "Listar Usuários")
public class ListUsuarios implements Action {

  @Option(name = "-o", aliases = { "--option" }, description = "An option to the command",
      required = false, multiValued = false)
  private String option;

  @Argument(name = "argument", description = "Argument to the command", required = false,
      multiValued = false)
  private String argument;

  @Override
  public Object execute() throws Exception {
    System.out.println("Executing command list");
    System.out.println("Option: " + option);
    System.out.println("Argument: " + argument);
    return null;
  }

}
