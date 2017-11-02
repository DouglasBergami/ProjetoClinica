
package visão;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Util.FormataNumeros;
import modelo.PacienteDTO;
import modelo.StatusDTO;
import Util.ValidarCpf;
import DAO.ComboBoxStatusDAO;
import DAO.PacienteDAO;
import java.util.List;


public class InformacaoPaciente extends javax.swing.JInternalFrame {

    int tratamento = 0;
    PacienteDTO paciente = new PacienteDTO();
    PacienteDAO pacienteDAO = new PacienteDAO();
    ComboBoxStatusDAO comboStatus = new ComboBoxStatusDAO();
    private List<StatusDTO> lista;
    ValidarCpf validarcpf = new ValidarCpf();
    
  
    public InformacaoPaciente(int tratamento) {
        initComponents();     
        lista = comboStatus.carregaCombo();
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(lista.toArray());
        comboBoxStatus.setModel(defaultComboBox);
        txtIdade.setDocument(new FormataNumeros());
        txtNumero.setDocument(new FormataNumeros()); 
        this.tratamento = tratamento;
        txtId.setEnabled(false);
        comboBoxStatus.setEnabled(false);
    }
    
    public InformacaoPaciente(int tratamento, String id){
        initComponents();
        lista = comboStatus.carregaCombo();        
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(lista.toArray());
        comboBoxStatus.setModel(defaultComboBox);       
        txtIdade.setDocument(new FormataNumeros());
        txtNumero.setDocument(new FormataNumeros());  
        this.tratamento = tratamento;
 
         paciente.setCodigo((Integer.parseInt(id)));
         pacienteDAO.selecionarPaciente(paciente);
         txtId.setEditable(false);
         txtId.setText(id);
         txtIdade.setText(Integer.toString(paciente.getIdade()));
         txtCPF.setText(Long.toString(paciente.getCpf()));
         txtRua.setText(paciente.getRua());
         txtBairro.setText(paciente.getBairro());
         txtNumero.setText(Integer.toString(paciente.getNumero()));
         txtCEP.setText(Long.toString(paciente.getCep()));
         txtCidade.setText(id);
         txtTelefone.setText(Long.toString(paciente.getTelefone()));
         txtEmail.setText(paciente.getEmail());
         comboBoxStatus.setSelectedIndex(comboStatus.encontraStatusPaciente(lista, paciente));         
         txtNome.setText(paciente.getNome());
         jDataNasci.setDate(paciente.getDatanasci());
         comboBoxSexo.setSelectedItem(paciente.getSexo());
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        comboBoxSexo = new javax.swing.JComboBox<>();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        jDataNasci = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        txtCEP = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Cadastro Paciente");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setLayout(null);

        jLabel5.setText("Codigo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 11, 33, 14);
        jPanel1.add(txtId);
        txtId.setBounds(0, 31, 80, 20);

        jLabel2.setText("Nome");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 10, 27, 14);
        jPanel1.add(txtNome);
        txtNome.setBounds(97, 31, 230, 20);

        jLabel3.setText("Data Nascimento");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 70, 100, 14);

        jLabel1.setText("Idade");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 10, 28, 14);

        jLabel6.setText("Sexo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(350, 10, 24, 14);

        jLabel8.setText("CPF");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 70, 19, 14);
        jPanel1.add(txtIdade);
        txtIdade.setBounds(480, 30, 48, 20);

        comboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Homem", "Mulher" }));
        jPanel1.add(comboBoxSexo);
        comboBoxSexo.setBounds(350, 30, 103, 20);

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPFFocusLost(evt);
            }
        });
        jPanel1.add(txtCPF);
        txtCPF.setBounds(0, 90, 129, 20);

        jLabel17.setText("Status");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(0, 120, 31, 14);

        comboBoxStatus.setToolTipText("");
        jPanel1.add(comboBoxStatus);
        comboBoxStatus.setBounds(0, 140, 129, 20);
        jPanel1.add(jDataNasci);
        jDataNasci.setBounds(150, 90, 170, 20);

        jTabbedPane1.addTab("Dados", jPanel1);

        jLabel9.setText("Endereço");

        jLabel10.setText("Bairro");

        jLabel11.setText("Nº");

        jLabel12.setText("CEP");

        jLabel13.setText("Cidade");

        jLabel16.setText("Email");

        jLabel14.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        jButton1.setToolTipText("Pesquisa CEP");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCEPFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(80, 80, 80))
                            .addComponent(txtCEP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(26, 26, 26))
                            .addComponent(txtCEP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(26, 26, 26)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Contato", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.jpg"))); // NOI18N
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 731, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(870, 307));
    }// </editor-fold>//GEN-END:initComponents

    public boolean validaCampos(){
        
        boolean retorno = false;
        
        if(txtNome.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                txtNome.requestFocus();
                //txtNome.setBackground(new java.awt.Color(102, 255, 102));
           
            }else if(comboBoxSexo.getSelectedIndex()==0) {
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    comboBoxSexo.requestFocus();                      
                        } 

                else if(txtCPF.getText().replace(".","").replace("/","").replace("-","").replace(" ","").isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtCPF.requestFocus();
                    
                }else if(txtIdade.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtIdade.requestFocus();
                    
                }else if(txtCEP.getText().replace("-","").replace(" ","").isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtCEP.requestFocus();
                
                }else if(txtRua.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtRua.requestFocus();
                
                }else if(txtBairro.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtBairro.requestFocus();
                
                }else if(txtNumero.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtNumero.requestFocus();
                
                }else if(txtCidade.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtCidade.requestFocus();
                
                }else if(txtCidade.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtCidade.requestFocus();
                
                }else if(jDataNasci.getDate()==null){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    jDataNasci.requestFocusInWindow();
             
                }else if(txtTelefone.getText().replace("(","").replace(")","").replace(" ","").replace("","").isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo obrigatorio para preencher");
                    txtTelefone.requestFocus();
                
                }else{
                    retorno = true;
                }
        
        return retorno; 
    }
    
    public void salvarDadosPacientes(){
                paciente.setIdade((Integer.parseInt(txtIdade.getText())));
                paciente.setSexo(comboBoxSexo.getSelectedItem().toString());
                paciente.setCpf(Long.parseLong(txtCPF.getText().replace(".","").replace("/","").replace("-","")));
                paciente.setRua(txtRua.getText());
                paciente.setBairro(txtBairro.getText());
                paciente.setNumero(Integer.parseInt(txtNumero.getText()));
                paciente.setCep(Long.parseLong(txtCEP.getText().replace(".","").replace("/","").replace("-","")));
                paciente.setCidade(txtCidade.getText());
                paciente.setTelefone(Long.parseLong(txtTelefone.getText().replace("(","").replace(")","").replace(" ","")));
                paciente.setEmail(txtEmail.getText());
                paciente.setStatus(lista.get(comboBoxStatus.getSelectedIndex()).getId());
                paciente.setNome(txtNome.getText());
                Date data = jDataNasci.getDate();
                SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
                String dataFormatada = formato.format(data);    
                paciente.setDataNasci(data);               
        
    }
    
    private void txtCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusLost
        String cpf = ((txtCPF.getText().replace(".","").replace("/","").replace("-","").replace(" ","")));

        if(cpf.length()>0){
            if (cpf.length()<11){
                JOptionPane.showMessageDialog(null, "CPF incompleto");
                txtCPF.setText("");
                txtCPF.requestFocus();

            }else{

                boolean aprovacao = ValidarCpf.isValidCPF(cpf);

                if(aprovacao == false){
                    JOptionPane.showMessageDialog(null, "CPF inválido");
                    txtCPF.setText("");
                    txtCPF.requestFocus();

                }

            }

        }

    }//GEN-LAST:event_txtCPFFocusLost

    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusLost
        String telefone = (txtTelefone.getText().replace("(","").replace(")","").replace(" ",""));

        if(telefone.length()>0){
            if (telefone.length()<10){
                JOptionPane.showMessageDialog(null, "Informe o número completo de celular ou telefone");
                txtTelefone.setText("");
                txtTelefone.requestFocus();
            }
        }
    }//GEN-LAST:event_txtTelefoneFocusLost

    private void txtCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCEPFocusLost
        String cep = ((txtCEP.getText().replace(".","").replace("/","").replace("-","").replace(" ","")));

        if(cep.length()>0){
            if (cep.length()<8){
                JOptionPane.showMessageDialog(null, "CEP incompleto");
                txtCEP.setText("");
                txtCEP.requestFocus();

            }
        }
    }//GEN-LAST:event_txtCEPFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(tratamento == 1){
            if(validaCampos()==true){
                salvarDadosPacientes();
                pacienteDAO.salvar(paciente);
            }
        }else{
            if(validaCampos()==true){
                salvarDadosPacientes();
                pacienteDAO.editar(paciente);

            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxSexo;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDataNasci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
