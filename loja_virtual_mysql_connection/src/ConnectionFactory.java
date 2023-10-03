import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionFactory {

  public DataSource dataSource;

  public ConnectionFactory() {
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    comboPooledDataSource.setJdbcUrl(
      "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC"
    );
    comboPooledDataSource.setUser("root");
    comboPooledDataSource.setPassword("Rocha003@rocha");
    comboPooledDataSource.setMaxPoolSize(15);

    this.dataSource = comboPooledDataSource;
  }

  public Connection criaConexao() throws SQLException {
    return this.dataSource.getConnection();
  }
}
