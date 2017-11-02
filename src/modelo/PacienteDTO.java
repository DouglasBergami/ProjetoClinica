
package modelo;

import java.util.Date;


public class PacienteDTO extends Pessoa{
    
    private int codigo;
    private int status;
    private Date dataNasci;

    public PacienteDTO() {
        
    }
    
    

    public Date getDatanasci() {
        return dataNasci;
    }

    public void setDataNasci(Date dataNasci) {
        this.dataNasci = dataNasci;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
    
}
