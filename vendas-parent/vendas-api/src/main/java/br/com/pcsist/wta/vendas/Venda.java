package br.com.pcsist.wta.vendas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author guilherme.pacheco
 */
@Entity
@XmlRootElement
@Table(name = "venda")
public class Venda {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "nome", nullable = false)
  private String nome;
  @ManyToOne(optional = false)
  @JoinColumn(name = "usuario_id", nullable = false, updatable = false,
      foreignKey = @ForeignKey(name = "fk_venda_usuario"))
  private long idUsuario;

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

  public long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(long idUsuario) {
    this.idUsuario = idUsuario;
  }

  @Override
  public String toString() {
    return "Venda [id=" + id + ", nome=" + nome + ", idUsuario=" + idUsuario + "]";
  }

}
