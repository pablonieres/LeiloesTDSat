
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {

    conectaDAO connect = new conectaDAO();
    Connection conn = connect.conectar();
    PreparedStatement st;
    ResultSet rs;

    public boolean cadastrarProduto(ProdutosDTO produto) {
     boolean save = true;

        try {

            st = conn.prepareStatement("INSERT INTO produtos values(?,?,?,?)");
            st.setString(1, null);
            st.setString(2, produto.getNome());
            st.setString(3, produto.getValor().toString());
            st.setString(4, produto.getStatus());

            st.executeUpdate();
            st.close();
            return save;
        } catch (Exception ex) {
            System.out.println("Erro ao conetar" + ex.getMessage());
            return save = false;
        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> produtos = new ArrayList<>();

        try {
            st = conn.prepareStatement("SELECT * from produtos");
            rs = st.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                produtos.add(produto);

            }
            return produtos;
        } catch (Exception ex) {
            return null;

        }
    }

    public boolean venderProduto(int id)
    {
        try {
            st = conn.prepareStatement("UPDATE  produtos SET status=? where id=?");
            st.setString(1, "Vendido");
            st.setInt(2, id);
            st.executeUpdate();
            return  true;
            
        } catch (Exception ex) {
            return false;

        }
    }

 public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        ArrayList<ProdutosDTO> produtosVendidos = new ArrayList<>();

        try {
            st = conn.prepareStatement("SELECT * from produtos where status = 'Vendido'");
            rs = st.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                produtosVendidos.add(produto);

            }
            return produtosVendidos;
        } catch (Exception ex) {
            return null;

        }
    }
   
}
