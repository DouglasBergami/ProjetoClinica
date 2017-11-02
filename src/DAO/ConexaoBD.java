
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ConexaoBD {
    
    public Statement stm; // responsável por realizar a pesquisa no banco de dados
    public ResultSet rs; // responsável por armarzenar o resultado da pesquisa pelo statement
    private final  String driver = "com.mysql.jdbc.Driver"; // identifica o serviço do banco de dados
    private final  String caminho = "jdbc:mysql://mysql.desenvolvendoprojetos.kinghost.net/desenvolvendop"; // informa onde está locado o banco de dados, setar o local
    private final  String usuario = "desenvolvendop"; // usuario do banco
    private final  String senha = "Dmb150193"; // senha do banco
    public Connection con; // repsonsável por realizar a conexão com o banco de dados
            
    public void conexao(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            con=DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco"+"\n"+ex);
        }
    }    
    
    public void executaSQL(String sql){
        
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar sql\n"+ex.getMessage());
        }
        
    }

    public void desconeca(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Não foi possivel desconectar"+"\n"+ex);
        }
    }
    
}
