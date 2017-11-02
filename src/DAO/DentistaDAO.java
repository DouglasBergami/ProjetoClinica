
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.DentistaDTO;


public class DentistaDAO {
    
    ConexaoBD conex = new ConexaoBD();
    DentistaDTO medico = new DentistaDTO();
    public void Salvar(DentistaDTO mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos (idade, sexo, cpf, rua, bairro, numero, cep, cidade, telefone, email, id_especialidade, crm, id_status, nome) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt   (1, mod.getIdade());
            pst.setString(2, mod.getSexo());
            pst.setLong  (3, mod.getCpf());
            pst.setString(4, mod.getRua());
            pst.setString(5, mod.getBairro());
            pst.setInt   (6, mod.getNumero());
            pst.setLong  (7, mod.getCep());
            pst.setString(8, mod.getCidade());
            pst.setLong  (9, mod.getTelefone());
            pst.setString(10, mod.getEmail());
            pst.setInt   (11, mod.getEspecialidade());
            pst.setInt   (12, mod.getCrm());
            pst.setInt   (13, mod.getStatus());
            pst.setString(14, mod.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados "+"\n"+ex);
        }
        
        conex.desconeca();
    }
    

    public void editar (DentistaDTO mod){
        
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set idade=?, sexo=?, cpf=?, rua=?, bairro=?, numero=?, cep=?, cidade=?, telefone=?, email=?, Id_especialidade=?, crm=?, id_status=?, nome=? where id = ?");
            
            pst.setInt   (1, mod.getIdade());
            pst.setString(2, mod.getSexo());
            pst.setLong  (3, mod.getCpf());
            pst.setString(4, mod.getRua());
            pst.setString(5, mod.getBairro());
            pst.setInt   (6, mod.getNumero());
            pst.setLong  (7, mod.getCep());
            pst.setString(8, mod.getCidade());
            pst.setLong  (9, mod.getTelefone());
            pst.setString(10, mod.getEmail());
            pst.setInt   (11, mod.getEspecialidade());
            pst.setInt   (12, mod.getCrm());
            pst.setInt   (13, mod.getStatus());
            pst.setString(14, mod.getNome());
            pst.setInt   (15, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro para editar dados\n"+ex);
        }
        
        conex.desconeca();
    
    }
     
    
    public void Excluir(DentistaDTO mod){
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where id =?");
            
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Medico excluido com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir \n"+ex);
        }
            
        conex.desconeca();
        }
    
   
        public DentistaDTO selecionarMedico (DentistaDTO mod){
            
            conex.conexao();
            conex.executaSQL("select * from medicos where id ="+mod.getCodigo());
            
            try{
                
            conex.rs.first();
                           
                mod.setIdade(conex.rs.getInt("idade"));
                mod.setSexo(conex.rs.getString("sexo"));               
                mod.setCpf(conex.rs.getLong("cpf"));
                mod.setRua(conex.rs.getString("rua"));
                mod.setBairro(conex.rs.getString("bairro"));
                mod.setNumero(conex.rs.getInt("numero"));
                mod.setCep(conex.rs.getLong("cep"));
                mod.setCidade(conex.rs.getString("cidade"));
                mod.setTelefone(conex.rs.getLong("telefone"));
                mod.setEmail(conex.rs.getString("email"));
                mod.setEspecialidade(conex.rs.getInt("id_especialidade"));
                mod.setCrm(conex.rs.getInt("crm"));
                mod.setStatus(conex.rs.getInt("id_status"));
                mod.setNome(conex.rs.getString("nome"));

                }
                    catch(SQLException ex){
                          JOptionPane.showMessageDialog(null, "Erro para encontrar o medico selecionado"+ex);
                            }
            conex.desconeca();
            return mod;
        }
    
}
