package br.com.pcsist.wta.rest;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import br.com.pcsist.wta.usuario.api.CadastroUsuario;
import br.com.pcsist.wta.usuario.api.Usuario;
import br.com.pcsist.wta.usuario.api.UsuarioRepository;
import br.com.pcsist.wta.usuario.api.UsuarioService;

/**
 * @author guilherme.pacheco
 */
@Component(service = UsuarioRest.class, property = { "service.exported.interfaces=*",
    "service.exported.configs=org.apache.cxf.rs", "org.apache.cxf.rs.address=/usuarios" })
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioRest extends AbstractRest {

  @Reference
  private UsuarioRepository usuarioRepository;
  @Reference
  private UsuarioService usuarioService;

  @Context
  private UriInfo uri;

  @GET
  @Path("{id}")
  public Response obter(@PathParam("id") long id) {
    Usuario usuario = usuarioRepository.comId(id);
    return response(usuario);
  }

  @POST
  public Response cadastrar(CadastroUsuario cadastro) {
    Usuario usuario = usuarioService.cadastrar(cadastro);
    URI taskURI = uri.getRequestUriBuilder().path(Usuario.class, "usuario").build(usuario.getId());
    return Response.created(taskURI).build();
  }

  @GET
  public Collection<Usuario> todos() {
    Usuario usuario = new Usuario();
    usuario.setNome("Guilherme Pacheco");
    usuario.setEmail("guilherme.pacheco@pcinformatica.com.br");
    usuario.setUsername("guilherme.pacheco");
    return Collections.singletonList(usuario);
    // return usuarioRepository.todos();
  }

  @PUT
  @Path("{id}")
  public void atualizar(@PathParam("id") long id, CadastroUsuario cadastro) {
    usuarioService.atualizar(id, cadastro);
  }

  @DELETE
  @Path("{id}")
  public void deletar(@PathParam("id") long id) {
    usuarioService.deletar(id);
  }

}
