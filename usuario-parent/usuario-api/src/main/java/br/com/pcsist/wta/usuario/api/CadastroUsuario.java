package br.com.pcsist.wta.usuario.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author guilherme.pacheco
 */
@XmlRootElement
public class CadastroUsuario {

  private String nome;
  private String email;
  private String username;
  private String senha;

  public CadastroUsuario() {
    super();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public String toString() {
    return String.format("CadastroUsuario [nome: %s, email: %s, username: %s]", nome, email,
      username);
  }

}
