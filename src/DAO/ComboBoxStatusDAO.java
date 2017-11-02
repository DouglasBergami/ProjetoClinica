
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DentistaDTO;
import modelo.PacienteDTO;
import modelo.StatusDTO;



public class ComboBoxStatusDAO {
    
    ConexaoBD conex = new ConexaoBD();
   
    
          
        public List<StatusDTO> carregaCombo(){
            
        List<StatusDTO> dados = new ArrayList();

        conex.conexao();
        conex.executaSQL("select * from status");

        try {
            conex.rs.first();
            
            do{
                
                dados.add(new StatusDTO(conex.rs.getInt("id"), conex.rs.getString("nome")));
                //dados.add(conex.rs.getInt("id"), conex.rs.getString("nome"));                
                
            }while(conex.rs.next());            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "não foi possivel gerar combobox");
        }
        

        
        conex.desconeca();
        
      return dados;  
      }
        
     public int encontraStatusDentista(List<StatusDTO> dados, DentistaDTO dentista){
         int valor = 0;
          
          for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == dentista.getStatus()) {
                
                valor = i;
            }
    
     }   
        
      
     return valor;  
}
     
     public int encontraStatusPaciente(List<StatusDTO> dados, PacienteDTO paciente){
         int valor = 0;
          
          for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == paciente.getStatus()) {
                
                valor = i;
            }
    
     } 
     return valor; 
}
}

    
    

