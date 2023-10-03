import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteListagem {

  public static void main(String[] args) throws SQLException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection con = connectionFactory.criaConexao();

    PreparedStatement stm = con.prepareStatement(
      "SELECT id, nome, descricao FROM PRODUTO"
    );

    stm.execute();

    ResultSet rst = stm.getResultSet();

    while (rst.next()) {
      Integer id = rst.getInt("id");
      String nome = rst.getString("nome");
      String descricao = rst.getString("descricao");

      System.out.println(
        "ID: " + id + " - " + "Nome: " + nome + " - " + descricao
      );
    }

    con.close();
  }
}
