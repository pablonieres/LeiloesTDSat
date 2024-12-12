
   import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
   
   
public class conectaDAO {
    
    public Connection conn;
    public String url = "jdbc:mysql://localhost:3306/uc11"; //Nome da base de dados
    public String user = "pablo"; //nome do usuário do MySQL
    public String password = "081275"; //senha do MySQL
    
    
    public Connection conectar(){
        
        try {
                        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
          //  System.out.println("Conexão realizada com sucesso");
            return conn;
           
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco" +" "+ ex.getMessage());
            return conn;
        }
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            //posso deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}

    

