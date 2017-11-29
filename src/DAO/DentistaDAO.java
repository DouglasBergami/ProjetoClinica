package DAO;

import Util.Tabela;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modeloDTO.DentistaDTO;

public class DentistaDAO {

    ConexaoBD conex = new ConexaoBD();
    DentistaDTO medico = new DentistaDTO();
    Tabela tabela = new Tabela();

    public void Salvar(DentistaDTO mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos (idade, sexo, cpf, rua, bairro, numero, cep, cidade, telefone, email, id_especialidade, crm, id_status, nome) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, mod.getIdade());
            pst.setString(2, mod.getSexo());
            pst.setLong(3, mod.getCpf());
            pst.setString(4, mod.getRua());
            pst.setString(5, mod.getBairro());
            pst.setInt(6, mod.getNumero());
            pst.setLong(7, mod.getCep());
            pst.setString(8, mod.getCidade());
            pst.setLong(9, mod.getTelefone());
            pst.setString(10, mod.getEmail());
            pst.setInt(11, mod.getEspecialidade());
            pst.setInt(12, mod.getCrm());
            pst.setInt(13, mod.getStatus());
            pst.setString(14, mod.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados " + "\n" + ex);
        }

        conex.desconeca();
    }

    public void editar(DentistaDTO mod) {

        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set idade=?, sexo=?, cpf=?, rua=?, bairro=?, numero=?, cep=?, cidade=?, telefone=?, email=?, Id_especialidade=?, crm=?, id_status=?, nome=? where id = ?");

            pst.setInt(1, mod.getIdade());
            pst.setString(2, mod.getSexo());
            pst.setLong(3, mod.getCpf());
            pst.setString(4, mod.getRua());
            pst.setString(5, mod.getBairro());
            pst.setInt(6, mod.getNumero());
            pst.setLong(7, mod.getCep());
            pst.setString(8, mod.getCidade());
            pst.setLong(9, mod.getTelefone());
            pst.setString(10, mod.getEmail());
            pst.setInt(11, mod.getEspecialidade());
            pst.setInt(12, mod.getCrm());
            pst.setInt(13, mod.getStatus());
            pst.setString(14, mod.getNome());
            pst.setInt(15, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro para editar dados\n");
        }

        conex.desconeca();

    }

    public void Excluir(String id) {

        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where id =" + id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Medico excluido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir \n");
        }

        conex.desconeca();
    }

    public DentistaDTO selecionarMedico(DentistaDTO mod) {

        conex.conexao();
        conex.executaSQL("select * from medicos where id =" + mod.getCodigo());

        try {

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

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro para encontrar o medico selecionado");
        }
        conex.desconeca();
        return mod;
    }

    public Tabela listarMedicos(String codigo, String nome, int especialidade, String crm) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"id", "nome", "especialidade", "crm"};

        conex.conexao();

        String sql = "select medicos.id, medicos.nome, especialidade.nome, medicos.crm from medicos inner JOIN especialidade on id_especialidade = especialidade.id";

        boolean valida = false;

        if (codigo != null && !codigo.equals("")) {
            if (valida) {
                sql += " and medicos.id = " + codigo;
            } else {
                sql += " where medicos.id = " + codigo;
                valida = true;
            }

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

}
