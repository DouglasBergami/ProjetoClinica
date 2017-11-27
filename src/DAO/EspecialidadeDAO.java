package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloDTO.EspecialidadeDTO;

public class EspecialidadeDAO {

    ConexaoBD conex = new ConexaoBD();
    EspecialidadeDTO especialidade = new EspecialidadeDTO();

    public void Salvar(EspecialidadeDTO especialidade) {
        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into especialidade (nome) values (?)");
            pst.setString(1, especialidade.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi posssivel cadastrar" + ex);
        }

        conex.desconeca();
    }

    public EspecialidadeDTO selecionarEspecialidade(EspecialidadeDTO especialidade) {

        conex.conexao();
        conex.executaSQL("select * from especialidade where id =" + especialidade.getId());

        try {

            conex.rs.first();

            especialidade.setNome(conex.rs.getString("nome"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar" + ex);
        }

        conex.desconeca();
        return especialidade;
    }

    public void editar(EspecialidadeDTO especialidade) {

        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement("update especialidade set nome=? where id =?");
            pst.setString(1, especialidade.getNome());
            pst.setInt(2, especialidade.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar os dados" + ex);
        }

    }

    public void excluir(EspecialidadeDTO especialdiade) {
        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from especialidade where id = ?");
            pst.setInt(1, especialdiade.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Especialidade excluida com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "não foi possivel excluir a especialidade");
        }

        conex.desconeca();

    }

}
