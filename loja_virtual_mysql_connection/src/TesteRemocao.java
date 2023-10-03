import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {

  public static void main(String[] args) throws SQLException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection con = connectionFactory.criaConexao();

    Statement stm = con.createStatement();

    stm.execute("DELETE FROM PRODUTO WHERE id > 1");
    Integer linhasAfetadas = stm.getUpdateCount();
    System.out.println(linhasAfetadas);

    con.close();
  }
}
