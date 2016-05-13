package br.com.pcsist.wta.usuario.shared.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author guilherme.pacheco
 */
public class Usuarios {

  @JsonProperty("usuario")
  private List<Usuario> usuario = new ArrayList<Usuario>();
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("usuario")
  public List<Usuario> getUsuario() {
    return usuario;
  }

  @JsonProperty("usuario")
  public void setUsuario(List<Usuario> usuario) {
    this.usuario = usuario;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
  }

}
