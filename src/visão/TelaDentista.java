/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visão;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloDTO.DentistaDTO;
import modeloDTO.EspecialidadeDTO;
import Util.Tabela;
import DAO.ComboBoxEspecialidadeDAO;
import DAO.ConexaoBD;
import DAO.DentistaDAO;
import java.util.List;


public class TelaDentista extends javax.swing.JInternalFrame {

 
    DentistaDTO classeBean = new DentistaDTO();
    DentistaDAO medicDAO = new DentistaDAO();
    ConexaoBD conex = new ConexaoBD();
    Tabela modelo = new Tabela();
    ComboBoxEspecialidadeDAO comboboxEspecialidade = new ComboBoxEspecialidadeDAO();
    private List<EspecialidadeDTO> listaEspecialidade;
    int tratamento = 0; 
    int pesquisar = 0;
    
    public TelaDentista() {
        initComponents();
        btnCarregar.setVisible(false);
        
        listaEspecialidade = comboboxEspecialidade.carregaComboEspecialidade();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaEspecialidade.toArray());
        comboBoxEspecialidade.setModel(defaultComboBox);
        comboBoxEspecialidade.addItem("TODOS");
        comboBoxEspecialidade.setSelectedItem("TODOS");
       
        
    }
    
    public TelaDentista(int pesquisar) {
        initComponents();
        this.pesquisar = pesquisar;
        btnCarregar.setVisible(true);
        
        listaEspecialidade = comboboxEspecialidade.carregaComboEspecialidade();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listaEspecialidade.toArray());
        comboBoxEspecialidade.setModel(defaultComboBox);
        comboBoxEspecialidade.addItem("TODOS");
        comboBoxEspecialidade.setSelectedItem("TODOS");
       
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCrm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxEspecialidade = new javax.swing.JComboBox<>();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        tableMedicos = new javax.swing.JTable();
        btnCarregar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Consulta Medicos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/medico.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(900, 600));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setToolTipText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setToolTipText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.setFocusPainted(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Pesquisar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Codigo");

        jLabel2.setText("Nome: ");

        jLabel3.setText("CRM: ");

        jLabel4.setText("Especialidade: ");

        comboBoxEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Cirurgião", "Anestesista", "teste" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 208, Short.MAX_VALUE))
                    .addComponent(txtId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCrm, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        tableMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMedicosMouseClicked(evt);
            }
        });
        jScrollPaneTabela.setViewportView(tableMedicos);

        btnCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carregar.png"))); // NOI18N
        btnCarregar.setToolTipText("Carregar");
        btnCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneTabela))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCarregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(784, 514));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
     
        
        String codigo = txtId.getText().equals("") ? null : txtId.getText();
        String nome = txtNome.getText().equals("") ? null : txtNome.getText();
        String crm = txtCrm.getText().equals("") ? null : txtCrm.getText();
        int especialidade = comboBoxEspecialidade.getSelectedItem().toString().equals("TODOS") ? 0 : listaEspecialidade.get(comboBoxEspecialidade.getSelectedIndex()).getId(); 

        Tabela tabela =  medicDAO.listarMedicos(codigo, nome, especialidade, crm);
         
        tableMedicos.setModel(tabela);
        tableMedicos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableMedicos.getColumnModel().getColumn(1).setPreferredWidth(180);
        tableMedicos.getColumnModel().getColumn(2).setPreferredWidth(180);
        tableMedicos.getColumnModel().getColumn(3).setPreferredWidth(180);
        tableMedicos.setAutoResizeMode(tableMedicos.AUTO_RESIZE_OFF);
        tableMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        tratamento = 1;

        InformacaoDentista InformacaoMedicos = new InformacaoDentista(tratamento);
        TelaPrincipal.jDesktopPaneMedicos.add(InformacaoMedicos);
        
        InformacaoMedicos.setVisible(true);
        
        
        

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
                  
 
        int i = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?  ", "Excluir", JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){

            classeBean.setCodigo(Integer.parseInt(tableMedicos.getValueAt(tableMedicos.getSelectedRow(), 0).toString()));
            medicDAO.Excluir(classeBean);

        }
             

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tableMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMedicosMouseClicked

        if (evt.getClickCount()==2){
            
            if(pesquisar==0){
                
            
            tratamento = 2;

            String id = tableMedicos.getValueAt(tableMedicos.getSelectedRow(), 0).toString();

            InformacaoDentista InformacaoMedicos = new InformacaoDentista (tratamento, id);
            TelaPrincipal.jDesktopPaneMedicos.add(InformacaoMedicos);
            InformacaoMedicos.setVisible(true);
            }
            else{
                
                 InformacaoAgendamento.txtIdDentista.setText(tableMedicos.getValueAt(tableMedicos.getSelectedRow(), 0).toString());
                InformacaoAgendamento.txtDentista.setText(tableMedicos.getValueAt(tableMedicos.getSelectedRow(), 1).toString());
                 dispose();
            }
        }
    }//GEN-LAST:event_tableMedicosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            tratamento = 2;

            String id = tableMedicos.getValueAt(tableMedicos.getSelectedRow(), 0).toString();

            InformacaoDentista InformacaoMedicos = new InformacaoDentista (tratamento, id);
            TelaPrincipal.jDesktopPaneMedicos.add(InformacaoMedicos);
            InformacaoMedicos.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed
                try{
                InformacaoAgendamento.txtIdDentista.setText(tableMedicos.getValueAt(tableMedicos.getSelectedRow(), 0).toString());
                InformacaoAgendamento.txtIdDentista.setText(tableMedicos.getValueAt(tableMedicos.getSelectedRow(), 1).toString());
                dispose();
                 }catch(Exception ex){
                     JOptionPane.showMessageDialog(null, "Você deve selecionar um paciente");
                 }
    }//GEN-LAST:event_btnCarregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> comboBoxEspecialidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable tableMedicos;
    private javax.swing.JTextField txtCrm;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
