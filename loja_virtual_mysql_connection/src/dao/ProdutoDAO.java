package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class ProdutoDAO {

  private Connection connection;

  public ProdutoDAO(Connection connection) {
    this.connection = connection;
  }

  public void salvar(Produto produto) throws SQLException {
    String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";

    try (
      PreparedStatement ptsm = connection.prepareStatement(
        sql,
        Statement.RETURN_GENERATED_KEYS
      )
    ) {
      ptsm.setString(1, produto.getNome());
      ptsm.setString(2, produto.getDescricao());

      ptsm.execute();

      try (ResultSet rst = ptsm.getGeneratedKeys()) {
        while (rst.next()) {
          produto.setId(rst.getInt(1));
        }
      }
    }
  }

  public List<Produto> listar() throws SQLException {
    List<Produto> produtos = new ArrayList<Produto>();

    String sql = "SELECT id, nome, descricao FROM PRODUTO";

    try (PreparedStatement ptsm = connection.prepareStatement(sql)) {
      ptsm.execute();

      try (ResultSet rst = ptsm.getResultSet()) {
        while (rst.next()) {
          Produto produto = new Produto(
            rst.getInt(1),
            rst.getString(2),
            rst.getString(3)
          );

          produtos.add(produto);
        }
      }
    }

    return produtos;
  }
}
