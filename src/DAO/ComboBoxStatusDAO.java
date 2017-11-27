package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloDTO.AgendamentoDTO;
import modeloDTO.DentistaDTO;
import modeloDTO.PacienteDTO;
import modeloDTO.StatusDTO;

public class ComboBoxStatusDAO {

    ConexaoBD conex = new ConexaoBD();

    public List<StatusDTO> carregaCombo() {

        List<StatusDTO> dados = new ArrayList();

        conex.conexao();
        conex.executaSQL("select * from status");

        try {
            conex.rs.first();

            do {

                dados.add(new StatusDTO(conex.rs.getInt("id"), conex.rs.getString("nome")));
                //dados.add(conex.rs.getInt("id"), conex.rs.getString("nome"));                

            } while (conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "não foi possivel gerar combobox");
        }

        conex.desconeca();

        return dados;
    }

    public int encontraStatusDentista(List<StatusDTO> dados, DentistaDTO dentista) {
        int valor = 0;

        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == dentista.getStatus()) {

                valor = i;
            }

        }

        return valor;
    }

    public StatusDTO encontraStatusPaciente(int id) {
        StatusDTO status = new StatusDTO();

        conex.conexao();

        conex.executaSQL("select * from paciente inner join status on id_status = status.id where id_status =" + id);

        try {
            conex.rs.first();

            do {

                status.setNome(conex.rs.getString("status.nome"));
                status.setId(conex.rs.getInt("id_status"));

            } while (conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "não foi possivel gerar combobox");
        }

        return status;
    }

    public int encontraStatusPaciente(List<StatusDTO> dados, PacienteDTO paciente) {
        int valor = 0;

        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == paciente.getStatus()) {

                valor = i;
            }

        }
        return valor;
    }

    public int encontraStatusAgendamento(List<StatusDTO> dados, AgendamentoDTO agendamentoDTO) {
        int valor = 0;

        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == agendamentoDTO.getId_status()) {

                valor = i;
            }

        }
        return valor;
    }

}
