
package modeloDTO;

import java.util.Date;


public class AgendamentoDTO {
    
    private int codigo;
    private int id_status;
    private Date data;
    private String hora;
    private String servico;
    private DentistaDTO dentistaDTO;
    private PacienteDTO pacienteDTO;
    
    public AgendamentoDTO(){
        
        
    }

    public PacienteDTO getPacienteDTO() {
        return pacienteDTO;
    }

    public void setPacienteDTO(PacienteDTO pacienteDTO) {
        this.pacienteDTO = pacienteDTO;
    }
    
    

    public DentistaDTO getDentistaDTO() {
        return dentistaDTO;
    }

    public void setDentistaDTO(DentistaDTO dentistaDTO) {
        this.dentistaDTO = dentistaDTO;
    }
    
    

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    
}
