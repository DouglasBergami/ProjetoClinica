package visão;

import modeloDTO.AgendamentoDTO;
import modeloDTO.DentistaDTO;
import Util.FormataNumeros;
import modeloDTO.PacienteDTO;
import DAO.AgendamentoDAO;
import DAO.ComboBoxStatusDAO;
import DAO.DentistaDAO;
import DAO.PacienteDAO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modeloDTO.StatusDTO;

public class InformacaoAgendamento extends javax.swing.JInternalFrame {

    PacienteDTO paciente = new PacienteDTO();
    PacienteDAO pacienteDAO = new PacienteDAO();
    DentistaDTO dentista = new DentistaDTO();
    DentistaDAO dentistaDAO = new DentistaDAO();
    AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    AgendamentoDTO agendamento = new AgendamentoDTO();
    ComboBoxStatusDAO comboBoxStatusDAO = new ComboBoxStatusDAO();
    int tratamento = 0;
    int pesquisar = 0;
    private List<StatusDTO> listaStatus;

    Calendar tempo = Calendar.getInstance();
    int day = tempo.get(Calendar.DATE);
    int month = tempo.get(Calendar.MONTH);
    int year = tempo.get(Calendar.YEAR);
    
    String dataAtual = day+"/"+(month+1)+"/"+year;
    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public InformacaoAgendamento(int tratamento) {
        initComponents();
        this.tratamento = tratamento;
        txtIdDentista.setDocument(new FormataNumeros());
        txtIdPaciente.setDocument(new FormataNumeros());
        txtIdAgendamento.setEnabled(false);
        jComboBoxStatus.setEnabled(false);
        txtDentista.setEditable(false);
        txtPaciente.setEditable(false);

        tempo.set(Calendar.YEAR, year);
        tempo.set(Calendar.MONTH, month);
        tempo.set(Calendar.DATE, day);

        jDataAgendamento.setMinSelectableDate(tempo.getTime());

        listaStatus = comboBoxStatusDAO.carregaCombo();
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(listaStatus.toArray());
        jComboBoxStatus.setModel(defaultComboBoxModel);
        jComboBoxStatus.setSelectedIndex(0);

    }

    public InformacaoAgendamento(int tratamento, String id) {
        initComponents();
        this.tratamento = tratamento;
        txtIdDentista.setDocument(new FormataNumeros());
        txtIdPaciente.setDocument(new FormataNumeros());
        txtIdAgendamento.setEnabled(false);
        jComboBoxStatus.setEnabled(true);
        txtDentista.setEditable(false);
        txtPaciente.setEditable(false);
        
        tempo.set(Calendar.YEAR, year);
        tempo.set(Calendar.MONTH, month);
        tempo.set(Calendar.DATE, day);

        jDataAgendamento.setMinSelectableDate(tempo.getTime());

        listaStatus = comboBoxStatusDAO.carregaCombo();
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(listaStatus.toArray());
        jComboBoxStatus.setModel(defaultComboBoxModel);

        agendamento.setCodigo((Integer.parseInt(id)));
        agendamentoDAO.selecionarAgendamento(agendamento);

        txtIdAgendamento.setText((id));
        txtIdDentista.setText((Integer.toString(agendamento.getDentistaDTO().getCodigo())));
        txtDentista.setText(agendamento.getDentistaDTO().getNome());
        txtIdPaciente.setText(Integer.toString(agendamento.getPacienteDTO().getCodigo()));
        txtPaciente.setText(agendamento.getPacienteDTO().getNome());
        txtHora.setText(agendamento.getHora());
        txtServico.setText(agendamento.getServico());
        jDataAgendamento.setDate(agendamento.getData());
        jComboBoxStatus.setSelectedIndex(comboBoxStatusDAO.encontraStatusAgendamento(listaStatus, agendamento));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtPaciente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDentista = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDataAgendamento = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        txtHora = new javax.swing.JFormattedTextField();
        txtServico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdPaciente = new javax.swing.JTextField();
        txtIdDentista = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdAgendamento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();

        jLabel8.setText("jLabel8");

        setClosable(true);
        setTitle("Cadastro Agendamento");
        setToolTipText("");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/newsalvar.png"))); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 124, -1));

        jLabel1.setText("Paciente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 30, 30));

        jLabel2.setText("Dentista");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));
        jPanel1.add(txtDentista, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 125, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 30, 30));

        jLabel3.setText("Data");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jLabel4.setText("Hora");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));
        jPanel1.add(jDataAgendamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 184, -1));

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraFocusLost(evt);
            }
        });
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 97, -1));
        jPanel1.add(txtServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 253, 561, 183));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Procedimento");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 206, 242, -1));

        jLabel6.setText("Codigo Dent");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel7.setText("Codigo Pac");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtIdPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdPacienteFocusLost(evt);
            }
        });
        jPanel1.add(txtIdPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 50, -1));

        txtIdDentista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdDentistaFocusLost(evt);
            }
        });
        jPanel1.add(txtIdDentista, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 50, -1));

        jLabel9.setText("Agendamento");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));
        jPanel1.add(txtIdAgendamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 13, 50, -1));

        jLabel10.setText("Status");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jPanel1.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 124, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void salvarDadosAgendamento() {

        dentista.setCodigo((Integer.parseInt(txtIdDentista.getText())));
        paciente.setCodigo((Integer.parseInt(txtIdPaciente.getText())));
        agendamento.setData(jDataAgendamento.getDate());
        agendamento.setId_status(listaStatus.get(jComboBoxStatus.getSelectedIndex()).getId());
        agendamento.setHora(txtHora.getText());
        agendamento.setServico(txtServico.getText());
        agendamento.setDentistaDTO(dentista);
        agendamento.setPacienteDTO(paciente);

    }

    private boolean validacao() {
        boolean validar = true;
        
        Date dataAualConvertida = null;
        
        /*try {
            dataAualConvertida = (Date)dateFormat.parse("2017/11/29");
            JOptionPane.showMessageDialog(null, dataAualConvertida);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel converter a data atual");
        }*/

        if (txtIdDentista.getText().equals("") || txtIdDentista.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor informar o dentista");
            validar = false;
            txtIdDentista.requestFocus();
            
        } else if (txtIdPaciente.getText().equals("") || txtIdPaciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor informar o paciente");
            validar = false;        
            txtIdPaciente.requestFocus();
            
        } else if (jDataAgendamento.getDate() == null /*|| jDataAgendamento.getDate().before(dataAualConvertida)==true*/) {
            JOptionPane.showMessageDialog(null, "Favor informar a data do agendamento");
            validar = false;
            jDataAgendamento.requestFocusInWindow();
            
        }else if(txtHora.equals("") || txtHora.getText().replace(" ", "").replace(":", "").isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor informar o horario do agendamento");
            validar = false;
            txtHora.requestFocus();
            
        }else if(txtServico.equals("") || txtServico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor informar o procedimento / serviço");
            validar = false; 
            txtServico.requestFocus();
            
        }else{
            validar = true;
        }

        return validar;
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (tratamento == 1) {
            if(validacao()){
                salvarDadosAgendamento();
                agendamentoDAO.salvar(agendamento); 
            }

        } else {
            
            if(validacao()){
                salvarDadosAgendamento();
                agendamentoDAO.editar(agendamento);
            }
            

        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pesquisar = 1;
        TelaPaciente telaPaciente = new TelaPaciente(pesquisar);
        TelaPrincipal.jDesktopPaneMedicos.add(telaPaciente);
        telaPaciente.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pesquisar = 1;
        TelaDentista telaDentista = new TelaDentista(pesquisar);
        TelaPrincipal.jDesktopPaneMedicos.add(telaDentista);
        telaDentista.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void consultaNomePaciente() {

        paciente = new PacienteDTO();

        if (!txtIdPaciente.getText().isEmpty()) {

            paciente.setCodigo((Integer.parseInt(txtIdPaciente.getText())));
            pacienteDAO.selecionarPaciente(paciente);
            txtPaciente.setText("");

            if (!paciente.getNome().isEmpty()) {

                txtPaciente.setText(paciente.getNome());

            }

        }

    }

    private void txtIdPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdPacienteFocusLost
        consultaNomePaciente();
    }//GEN-LAST:event_txtIdPacienteFocusLost

    public void consultaNomeDentista() {

        dentista = new DentistaDTO();

        if (!txtIdDentista.getText().isEmpty()) {

            dentista.setCodigo((Integer.parseInt(txtIdDentista.getText())));
            dentistaDAO.selecionarMedico(dentista);
            txtDentista.setText("");

            if (!dentista.getNome().isEmpty()) {

                txtDentista.setText(dentista.getNome());

            }

        }

    }

    private void txtIdDentistaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdDentistaFocusLost
        consultaNomeDentista();
    }//GEN-LAST:event_txtIdDentistaFocusLost

    private void txtHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFocusLost
        String hora = "";
        int hora1 = 0;
        int hora2 = 0;

        hora = txtHora.getText().replace(":", "").replace(" ", "");

        if (!hora.equals("")) {

            try {
                hora1 = (Integer.parseInt(hora.substring(0, 2)));
                hora2 = (Integer.parseInt(hora.substring(2, 4)));

                if (hora1 >= 0 && hora1 <= 23) {
                    if (hora2 >= 0 && hora2 <= 59) {

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "hora inválida");
                    txtHora.requestFocus();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hora incompleta");
                txtHora.setText(hora);
                txtHora.requestFocus();

            }
        } else {

        }

    }//GEN-LAST:event_txtHoraFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDataAgendamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JTextField txtDentista;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtIdAgendamento;
    public static javax.swing.JTextField txtIdDentista;
    public static javax.swing.JTextField txtIdPaciente;
    public static javax.swing.JTextField txtPaciente;
    private javax.swing.JTextField txtServico;
    // End of variables declaration//GEN-END:variables
}
