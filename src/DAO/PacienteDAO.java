
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.PacienteDTO;


public class PacienteDAO {
    
    ConexaoBD conex = new ConexaoBD();
    PacienteDTO paciente = new PacienteDTO();
    
    public void salvar(PacienteDTO paciente){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into paciente (nome, sexo, idade, cpf, datanasci, id_status, cep, rua, bairro, numero, cidade, telefone, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, paciente.getNome());
            pst.setString(2, paciente.getSexo());
            pst.setInt   (3, paciente.getIdade());
            pst.setLong  (4, paciente.getCpf());
            pst.setDate  (5, new java.sql.Date(paciente.getDatanasci().getTime()));
            pst.setInt   (6, paciente.getStatus());
            pst.setLong  (7, paciente.getCep());
            pst.setString(8, paciente.getRua());
            pst.setString(9, paciente.getBairro());
            pst.setInt   (10, paciente.getNumero());
            pst.setString(11, paciente.getCidade());
            pst.setLong  (12, paciente.getTelefone());
            pst.setString(13, paciente.getEmail());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados "+"\n"+ex);
        }
        
        conex.desconeca();
    }
    
    public void excluir(PacienteDTO paciente){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from paciente where id =?");
            
            pst.setInt(1, paciente.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "paciente excluido com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir \n"+ex);
        }
            
        conex.desconeca();
        }
    
    
    public void editar(PacienteDTO paciente){
         conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update paciente set nome = ?, sexo = ?, idade=?, cpf = ?, datanasci = ?, id_status=?, cep = ?, rua = ?, bairro = ?, numero = ?, cidade = ?, telefone = ?, email = ?  where id = ?");
            pst.setString(1, paciente.getNome());
            pst.setString(2, paciente.getSexo());
            pst.setInt   (3, paciente.getIdade());
            pst.setLong  (4, paciente.getCpf());
            pst.setDate  (5, new java.sql.Date(paciente.getDatanasci().getTime()));
            pst.setInt   (6, paciente.getStatus());
            pst.setLong  (7, paciente.getCep());
            pst.setString(8, paciente.getRua());
            pst.setString(9, paciente.getBairro());
            pst.setInt   (10, paciente.getNumero());           
            pst.setString(11, paciente.getCidade());
            pst.setLong  (12, paciente.getTelefone());
            pst.setString(13, paciente.getEmail());  
            pst.setInt   (14, paciente.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro para editar dados\n"+ex);
        }
        
        conex.desconeca();
    }
    
    
   public PacienteDTO selecionarPaciente (PacienteDTO paciente){
            
            conex.conexao();
            conex.executaSQL("select * from paciente where id ="+paciente.getCodigo());
            
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
                          JOptionPane.showMessageDialog(null, "Erro para encontrar o paciente selecionado");
                            }
            conex.desconeca();
            return paciente;
        }
    
}
