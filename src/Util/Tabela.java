
package Util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Tabela extends AbstractTableModel{
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    private String pesquisar;

        
    public Tabela(){
        
    }


    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
        
    }
    
   public String getColumnName(int numCol){
       return colunas[numCol];
   }

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }
    
}
