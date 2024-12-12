
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
   conectaDAO connect = new conectaDAO();
   Connection conn = connect.conectar();
    PreparedStatement st;
    ResultSet rs;

 
  
    public Integer saveItem(ProdutosDTO produto) {
        int status = 0;
   
        try {

            st = conn.prepareStatement("INSERT INTO produtos values(?,?,?,?)");
            st.setString(1, null);
            st.setString(2, produto.getNome());
            st.setString(3, produto.getValor().toString());
            st.setString(4, produto.getStatus());
            
            status = st.executeUpdate();
            st.close();
            return status;
        } catch (Exception ex) {
            System.out.println("Erro ao conetar" + ex.getMessage());
           return status;
        }
        
        

    }
    
    
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
      public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            //posso deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
        
}

