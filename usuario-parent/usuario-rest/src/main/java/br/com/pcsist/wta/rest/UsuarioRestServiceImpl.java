package br.com.pcsist.wta.rest;

import java.util.Collection;

import javax.ws.rs.core.Context;
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
@Component(service = UsuarioRestService.class, property = { "service.exported.interfaces=*",
    "service.exported.configs=org.apache.cxf.rs", "org.apache.cxf.rs.address=/usuarios" })
public class UsuarioRestServiceImpl extends AbstractRest implements UsuarioRestService {

  @Reference
  UsuarioRepository usuarioRepository;
  @Reference
  UsuarioService usuarioService;

  @Context
  UriInfo uri;

  @Override
  public Response obter(long id) {
    Usuario usuario = usuarioRepository.comId(id);
    return response(usuario);
  }

  @Override
  public Response cadastrar(CadastroUsuario cadastro) {
    Usuario usuario = usuarioService.cadastrar(cadastro);
    return response(usuario);
  }

  @Override
  public Collection<Usuario> todos() {
    return usuarioRepository.todos();
  }

  @Override
  public void atualizar(long id, CadastroUsuario cadastro) {
    usuarioService.atualizar(id, cadastro);
  }

  @Override
  public void deletar(long id) {
    usuarioService.deletar(id);
  }

}
