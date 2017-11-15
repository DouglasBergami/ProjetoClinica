
package DAO;

import Util.Tabela;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.AgendamentoDTO;
import modelo.DentistaDTO;
import modelo.PacienteDTO;


public class AgendamentoDAO {
    
    ConexaoBD conex = new ConexaoBD();
    PacienteDTO paciente = new PacienteDTO();
    DentistaDTO dentista = new DentistaDTO();
    AgendamentoDTO agendamento = new AgendamentoDTO();
    Tabela tabela = new Tabela();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
    
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
    
    public void excluir(String id){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from agendamento where id = "+id);
            
            
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
            PreparedStatement pst = conex.con.prepareStatement("update agendamento set id_medico = ?, id_paciente = ?, data=?, id_status = ?, hora = ?, servico = ? where id = ?");
            pst.setInt   (1, agendamento.getCodigoDentista());
            pst.setInt   (2, agendamento.getCodigoPaciente());
            pst.setDate  (3, new java.sql.Date(agendamento.getData().getTime()));
            pst.setInt   (4, agendamento.getId_status());
            pst.setString(5, agendamento.getHora());
            pst.setString(6, agendamento.getServico());
            pst.setInt   (7, agendamento.getCodigo());      
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro para editar dados\n"+ex);
        }
        
        conex.desconeca();
    }
    
    
   public AgendamentoDTO selecionarAgendamento (AgendamentoDTO agendamento){
            
            conex.conexao();
            conex.executaSQL("select * from agendamento where id ="+agendamento.getCodigo());
            
            try{
                
            conex.rs.first();
                           

                agendamento.setCodigo(conex.rs.getInt("id"));
                agendamento.setCodigoDentista(conex.rs.getInt("id_medico"));
                agendamento.setCodigoPaciente(conex.rs.getInt("id_paciente"));
                agendamento.setData(conex.rs.getDate("data"));
                agendamento.setId_status(conex.rs.getInt("id_status"));
                agendamento.setHora(conex.rs.getString("hora"));
                agendamento.setServico(conex.rs.getString("servico"));
    
                }
                    catch(SQLException ex){
                          JOptionPane.showMessageDialog(null, "Erro para encontrar o agendamento selecionado"+ex);
                            }
            conex.desconeca();
            return agendamento;
        }
   
   public Tabela listarAgendamentos(String codigo, String nome, int status, boolean pessoa, String data) {
       
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Agendamento Nº", "Codigo", "nome", "data", "hora", "servico"};

        conex.conexao();

        String sql;

        boolean valida = false;
        boolean medico = true;
        
        if (pessoa == true) {
            sql = "select * from agendamento inner join medicos on id_medico = medicos.id"; 
            }
                else {
                sql = "select * from agendamento inner join paciente on id_paciente = paciente.id ";
                valida = true;
                medico = false;
            }
 
        if (codigo != null && !codigo.equals("")) {
            if(valida){
                if(medico){
                   sql += " and medicos.id = " + codigo; 
                }else{
                    sql += " and paciente.id = " + codigo;
                }
                
            }else{
                if(medico){
                    sql += " where medicos.id = " + codigo;
                    valida = true;                
                }else{
                    sql += " where paciente.id = " + codigo;
                    valida = true;  
                } 
            }
        }
        
        if (nome != null && !nome.equals("")) {
            if(valida){
                if(medico){
                   sql += " and medicos.nome like'%" + nome + "%'"; 
                }else{
                    sql += " and paciente.nome like'%" + nome + "%'"; 
                }
                
            }else{
                if(medico){
                    sql += " where medicos.nome like'%" + nome + "%'"; 
                    valida = true;                
                }else{
                    sql += " where paciente.nome like'%" + nome + "%'"; 
                    valida = true;  
                } 
            } 
        }
        
        sql += " order by data";
        
        conex.executaSQL(sql);

        try {
            conex.rs.first();

            do {
                if (medico){
                        dados.add((new Object[]{conex.rs.getInt("id"), conex.rs.getInt("medicos.id"), conex.rs.getString("medicos.nome"), dateFormat.format(conex.rs.getDate("data")), conex.rs.getString("hora"), conex.rs.getString("servico")}));
                }else{
                    dados.add((new Object[]{conex.rs.getInt("id"), conex.rs.getInt("paciente.id"), conex.rs.getString("paciente.nome"), dateFormat.format(conex.rs.getDate("data")), conex.rs.getString("hora"), conex.rs.getString("servico")}));
                }
                
            } while (conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum cadastro encontrado");
        }

        tabela.setLinhas(dados);
        tabela.setColunas(colunas);
        conex.desconeca();

        return tabela;
    }
    
}
