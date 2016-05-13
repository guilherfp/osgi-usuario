package br.com.pcsist.wta.usuario.shared.usuario;

/**
 * @author guilherme.pacheco
 */
public class Usuario {

  public long id;
  public String nome;
  public String username;
  public String email;

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", nome=" + nome + ", username=" + username + ", email=" + email
        + "]";
  }

}
