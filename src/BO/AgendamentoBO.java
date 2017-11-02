
package BO;

import Util.ValidacaoException;
import visão.InformacaoAgendamento;


public class AgendamentoBO {
    
    public boolean validaDados(String nomeDentista) throws ValidacaoException{
        boolean resultado = true;
        
        if(nomeDentista==null || nomeDentista.equals("")){
            resultado = false;
            InformacaoAgendamento.txtIdDentista.grabFocus();
           throw new ValidacaoException ("codigo obrigatorio");     
        }

        return resultado;
    }
    
    public boolean validaDados2(String nomePaciente) throws ValidacaoException{
        boolean resultado = true;
        
        if(nomePaciente==null || nomePaciente.equals("")){
            resultado = false;
            InformacaoAgendamento.txtIdPaciente.grabFocus();
           throw new ValidacaoException ("codigo obrigatorio");     
        }

        return resultado;
    }
    
}
