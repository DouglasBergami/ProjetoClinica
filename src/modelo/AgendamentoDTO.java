
package modelo;

import java.util.Date;


public class AgendamentoDTO {
    
    private int codigo;
    private int codigoDentista;
    private int CodigoPaciente;
    private Date data;
    private String hora;
    private String servico;
    
    public AgendamentoDTO(){
        
        
    }

    public int getCodigoDentista() {
        return codigoDentista;
    }

    public void setCodigoDentista(int codigoDentista) {
        this.codigoDentista = codigoDentista;
    }

    public int getCodigoPaciente() {
        return CodigoPaciente;
    }

    public void setCodigoPaciente(int CodigoPaciente) {
        this.CodigoPaciente = CodigoPaciente;
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
