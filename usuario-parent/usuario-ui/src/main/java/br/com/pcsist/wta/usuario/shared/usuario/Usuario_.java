package br.com.pcsist.wta.usuario.shared.usuario;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author guilherme.pacheco
 */
public class Usuario_ {

  @JsonProperty("email")
  public String email;
  @JsonProperty("id")
  public Integer id;
  @JsonProperty("nome")
  public String nome;
  @JsonProperty("username")
  public String username;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", nome=" + nome + ", username=" + username + ", email=" + email
        + "]";
  }

}
