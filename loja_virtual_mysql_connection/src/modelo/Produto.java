package modelo;

public class Produto {

  private Integer id;
  private String nome;
  private String descricao;

  public Produto(Integer id, String nome, String descricao) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
  }

  public String getNome() {
    return this.nome;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return (
      "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]"
    );
  }
}
