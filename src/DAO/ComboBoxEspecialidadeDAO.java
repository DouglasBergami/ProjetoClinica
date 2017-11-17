
package DAO;

import Util.Tabela;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modeloDTO.DentistaDTO;
import modeloDTO.EspecialidadeDTO;



public class ComboBoxEspecialidadeDAO {
    
    ConexaoBD conex = new ConexaoBD();
    Tabela tabela = new Tabela();
    
          
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
     
     public Tabela listaEspecialidade(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"id", "nome"};

        conex.conexao();
        conex.executaSQL(sql);

        try {
            conex.rs.first();

            do {

                dados.add((new Object[]{conex.rs.getInt("id"), conex.rs.getString("nome")}));
            } while (conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Especialidade não cadastrada");
        }

        tabela.setLinhas(dados);
        tabela.setColunas(colunas);
        conex.desconeca();

        return tabela;
    }
    
}
