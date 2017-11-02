
package DAO;

import Util.Tabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TabelaPacientesDAO {
    
    ConexaoBD conex = new ConexaoBD();
    Tabela tabela = new Tabela();
    
    public Tabela listarPacientes(String codigo, String nome, int status) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"id", "nome", "status"};
  
        conex.conexao();
        
        String sql = "select paciente.id, paciente.nome, status.nome from paciente inner JOIN status on paciente.id_status = status.id";
        
        boolean valida = false;
        
        if (codigo != null && !codigo.equals("")) {
            valida = true;
            sql += " where paciente.id = " + codigo;
        }

        if (nome != null && !nome.equals("")) {
            if (valida) {
                sql += " and paciente.nome like'%" + nome + "%'";
            } else {
                sql += " where paciente.nome like'%" + nome + "%'";
                valida = true;
            }
        }

        if (status != 0) {
            if (valida) {
                sql += " and id_status = " + status;
            } else {
                sql += " where id_status = " + status;
                valida = true;
            }
        }
        
        conex.executaSQL(sql);

        try {
            conex.rs.first();
            do{
            
                dados.add((new Object[]{conex.rs.getInt("id"), conex.rs.getString("nome"), conex.rs.getString("status.nome")}));
            }while(conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Paciente não cadastrado");
        }

        tabela.setLinhas(dados);
        tabela.setColunas(colunas);
        conex.desconeca();

        return tabela;
    }
    
}
