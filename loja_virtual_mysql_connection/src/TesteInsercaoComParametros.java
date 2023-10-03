import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametros {

  public static void main(String[] args) throws SQLException {
    ConnectionFactory connectionFactory = new ConnectionFactory();

    try (Connection con = connectionFactory.criaConexao()) {
      con.setAutoCommit(false);

      try (
        PreparedStatement stm = con.prepareStatement(
          "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
          Statement.RETURN_GENERATED_KEYS
        )
      ) {
        adicionarVariavel(stm, "Cadeira", "Cadeira da cor azul");
        adicionarVariavel(
          stm,
          "Sabonete BomXero",
          "Sabonete rosa com cheiro de lavanda da marca BomXero"
        );
        // adicionarVariavel(stm, "", "Algo");

        con.commit();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Rollback realizado com sucesso!");
        con.rollback();
      }
    }
  }

  private static void adicionarVariavel(
    PreparedStatement stm,
    String nome,
    String descricao
  ) throws SQLException {
    stm.setString(1, nome);
    stm.setString(2, descricao);

    if (nome.equals("") || descricao.equals("")) {
      throw new RuntimeException("Não foi possível realizar a inserção");
    }

    stm.execute();

    try (ResultSet rst = stm.getGeneratedKeys()) {
      while (rst.next()) {
        Integer ID = rst.getInt(1);

        System.out.println("ID criado: " + ID);
      }
    }
  }
}
