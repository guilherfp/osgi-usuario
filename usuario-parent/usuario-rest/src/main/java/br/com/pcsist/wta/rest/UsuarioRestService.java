package br.com.pcsist.wta.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pcsist.wta.usuario.api.CadastroUsuario;
import br.com.pcsist.wta.usuario.api.Usuario;

/**
 * @author guilherme.pacheco
 */
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UsuarioRestService {

  @GET
  @Path("{id}")
  Response obter(@PathParam("id") long id);

  @POST
  Response cadastrar(CadastroUsuario cadastro);

  @GET
  Collection<Usuario> todos();

  @PUT
  @Path("{id}")
  void atualizar(@PathParam("id") long id, CadastroUsuario cadastro);

  @DELETE
  @Path("{id}")
  void deletar(@PathParam("id") long id);

}
