import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

  public static void main(String[] args) throws SQLException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection con = connectionFactory.criaConexao();

    System.out.println("Conectado com sucesso!");

    con.close();

    System.out.println("Desconectado com sucesso!");
  }
}
