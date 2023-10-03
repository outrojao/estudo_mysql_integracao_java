import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.Produto;

public class TesteInsercaoEListagemProduto {

  public static void main(String[] args) throws SQLException {
    Produto produto = new Produto(0, "Comoda", "uma comoda");

    try (Connection con = new ConnectionFactory().criaConexao()) {
      ProdutoDAO persistenciaProduto = new ProdutoDAO(con);
      persistenciaProduto.salvar(produto);

      List<Produto> listaDeProdutos = persistenciaProduto.listar();
      listaDeProdutos.stream().forEach(p -> System.out.println(p));
    }
  }
}
