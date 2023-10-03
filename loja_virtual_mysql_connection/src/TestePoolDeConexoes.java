import java.sql.SQLException;

public class TestePoolDeConexoes {

  public static void main(String[] args) throws SQLException {
    ConnectionFactory connectionFactory = new ConnectionFactory();

    for (int i = 0; i < 20; i++) {
      connectionFactory.criaConexao();
      System.out.println("Conexão: " + i);
    }
  }
}
