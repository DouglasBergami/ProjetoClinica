
package DAO;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloDTO.UsuarioDTO;


public class UsuarioDAO {
    
    ConexaoBD con = new ConexaoBD();
    
    public UsuarioDTO consultaUsuario(UsuarioDTO usuario){
        
        boolean status = false;
                
         con.conexao();
         
         
        try {
            con.executaSQL("select * from usuario where login ='"+usuario.getLogin()+"'");         
            con.rs.first();
            if(con.rs.getString("senha").equals(usuario.getSenha())){
                usuario.setId(con.rs.getInt("id"));
                usuario.setLogin(con.rs.getString("login"));
                usuario.setSenha(con.rs.getString("senha"));
                usuario.setId_nivel(con.rs.getInt("id_nivel"));
                
            }else{
             JOptionPane.showMessageDialog(null, "Usuario / senha incorretos");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario / senha incorretos");           
        }
         
        
         
         con.desconeca();
        return usuario;
    }
    
   
        
        
    
    
}
