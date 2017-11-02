package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Util.Tabela;

public class TabelaMedicosDAO {

    ConexaoBD conex = new ConexaoBD();
    Tabela tabela = new Tabela();

    public Tabela listarMedicos(String codigo, String nome, int especialidade, String crm) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"id", "nome", "especialidade", "crm"};

        String sql = ("select medicos.id, medicos.nome, especialidade.nome, medicos.crm from medicos inner JOIN especialidade on id_especialidade = especialidade.id");

        conex.conexao();

        boolean valida = false;

        if (codigo != null && !codigo.equals("")) {
            valida = true;
            sql += " where medicos.id = " + codigo;
        }

        if (nome != null && !nome.equals("")) {
            if (valida) {
                sql += " and medicos.nome like'%" + nome + "%'";
            } else {
                sql += " where medicos.nome like'%" + nome + "%'";
                valida = true;
            }
        }

        if (especialidade != 0) {
            if (valida) {
                sql += " and id_especialidade = " + especialidade;
            } else {
                sql += " where id_especialidade = " + especialidade;
                valida = true;
            }
        }

        if (crm != null && !crm.equals("")) {
            if (valida) {
                sql += " and medicos.crm like'%" + crm + "%'";
            } else {
                sql += " where medicos.crm like'%" + crm + "%'";
                valida = true;
            }
        }
        
        conex.executaSQL(sql);

        try {
            conex.rs.first();

            do {

                dados.add((new Object[]{conex.rs.getInt("id"), conex.rs.getString("nome"), conex.rs.getString("especialidade.nome"), conex.rs.getInt("crm")}));
            } while (conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum dentista encontrado");
        }

        tabela.setLinhas(dados);
        tabela.setColunas(colunas);
        conex.desconeca();

        return tabela;
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
