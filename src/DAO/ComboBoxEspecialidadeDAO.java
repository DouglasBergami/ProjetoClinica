
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DentistaDTO;
import modelo.EspecialidadeDTO;



public class ComboBoxEspecialidadeDAO {
    
    ConexaoBD conex = new ConexaoBD();
   
    
          
        public List<EspecialidadeDTO> carregaComboEspecialidade(){
            
        List<EspecialidadeDTO> listaEspecialidade = new ArrayList<EspecialidadeDTO>();

        conex.conexao();
        conex.executaSQL("select * from especialidade");

        try {
            
            while(conex.rs.next()){
                
                EspecialidadeDTO especialidadeDTO = new EspecialidadeDTO();
                
                especialidadeDTO.setId(conex.rs.getInt("id"));
                especialidadeDTO.setNome(conex.rs.getString("nome"));
                
                listaEspecialidade.add(especialidadeDTO);                
            }  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar o comboBox");         
        }

        conex.desconeca();
        
      return listaEspecialidade;  
      }
        
     public int encontraEspecialidade(List<EspecialidadeDTO> dados, DentistaDTO dentista){
         int valor = 0;
          
          for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == dentista.getEspecialidade()) {
                
                valor = i;
            }
    
     }   
        
      
     return valor;  
}
    
}
