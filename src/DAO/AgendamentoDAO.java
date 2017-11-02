
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.AgendamentoDTO;
import modelo.DentistaDTO;
import modelo.PacienteDTO;


public class AgendamentoDAO {
    
    ConexaoBD conex = new ConexaoBD();
    PacienteDTO paciente = new PacienteDTO();
    DentistaDTO dentista = new DentistaDTO();
    AgendamentoDTO agendamento = new AgendamentoDTO();
    
    public void salvar(AgendamentoDTO agendamento){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into agendamento (id_medico, id_paciente, data, hora, servico) values (?, ?, ?, ?, ?)");
            pst.setInt   (1, agendamento.getCodigoDentista());
            pst.setInt   (2, agendamento.getCodigoPaciente());
            pst.setDate  (3, new java.sql.Date(agendamento.getData().getTime()));
            pst.setString(4, agendamento.getHora());
            pst.setString(5, agendamento.getServico());         
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");           
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao inserir dados "+"\n"+ex);
        }
        
        conex.desconeca();
    }
    
    public void excluir(AgendamentoDTO agendamento){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from agendamento where id =?");
            
            pst.setInt(1, agendamento.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "agendamento excluido com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir \n"+ex);
        }
            
        conex.desconeca();
        }
    
    
    public void editar(AgendamentoDTO agendamento){
         conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update agendamento set id_medico = ?, id_paciente = ?, data=?, hora = ?, servico = ?, where id = ?");
            pst.setInt   (1, agendamento.getCodigoDentista());
            pst.setInt   (2, agendamento.getCodigoPaciente());
            pst.setDate  (3, new java.sql.Date(agendamento.getData().getTime()));
            pst.setString(5, agendamento.getServico());
            pst.setInt   (6, agendamento.getCodigo());      
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro para editar dados\n"+ex);
        }
        
        conex.desconeca();
    }
    
    
   public PacienteDTO selecionarAgendamento (AgendamentoDTO agendamento){
            
            conex.conexao();
            conex.executaSQL("select * from agendamento where id ="+agendamento.getCodigo());
            
            try{
                
            conex.rs.first();
                           
                paciente.setIdade(conex.rs.getInt("idade"));
                paciente.setSexo(conex.rs.getString("sexo"));               
                paciente.setCpf(conex.rs.getLong("cpf"));
                paciente.setRua(conex.rs.getString("rua"));
                paciente.setBairro(conex.rs.getString("bairro"));
                paciente.setNumero(conex.rs.getInt("numero"));
                paciente.setCep(conex.rs.getLong("cep"));
                paciente.setCidade(conex.rs.getString("cidade"));
                paciente.setTelefone(conex.rs.getLong("telefone"));
                paciente.setEmail(conex.rs.getString("email"));
                paciente.setDataNasci(conex.rs.getDate("datanasci"));
                paciente.setStatus(conex.rs.getInt("id_status"));
                paciente.setNome(conex.rs.getString("nome"));

                }
                    catch(SQLException ex){
                          JOptionPane.showMessageDialog(null, "Erro para encontrar o paciente selecionado"+ex);
                            }
            conex.desconeca();
            return paciente;
        }
    
}
