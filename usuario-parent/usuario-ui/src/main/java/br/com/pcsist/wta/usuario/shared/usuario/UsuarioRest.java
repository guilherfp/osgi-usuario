package br.com.pcsist.wta.usuario.shared.usuario;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtplatform.dispatch.rest.shared.RestAction;

/**
 * @author Guilherme Pacheco
 */
@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public interface UsuarioRest {

  @GET
  RestAction<Usuarios> todos();

}
