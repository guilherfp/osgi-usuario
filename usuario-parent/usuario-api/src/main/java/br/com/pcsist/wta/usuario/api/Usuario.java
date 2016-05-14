package br.com.pcsist.wta.usuario.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author guilherme.pacheco
 */
@Entity
@XmlRootElement
@Table(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "username", nullable = false)
  private String username;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "senha", nullable = false)
  private String senha;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Usuario other = (Usuario) obj;
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("Usuario [id: %s, nome: %s, username: %s, email: %s]", id, nome, username,
      email);
  }

}
