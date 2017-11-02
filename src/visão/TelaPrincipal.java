package visão;

import DAO.ConexaoBD;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    ConexaoBD conexao = new ConexaoBD();
    TelaDentista medicos = new TelaDentista();
    TelaPaciente pacientes = new TelaPaciente();
    EspecialidadeDentista especialidadeDentista = new EspecialidadeDentista();
    TelaAgendamento telaAgendamento = new TelaAgendamento();

    public TelaPrincipal(String login) {
        initComponents();
        conexao.conexao();
        lblBemVindo.setText("Bem vindo: " + login);
    }

    private TelaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneMedicos = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        painelBemVindo = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        btnMedicos = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnAgenda = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemMenuMedicosOpcao = new javax.swing.JMenu();
        menuItemMenuEspecialidade = new javax.swing.JMenuItem();
        menuItemMenuMedicos = new javax.swing.JMenuItem();
        menuItemUsuarios = new javax.swing.JMenuItem();
        menuItemPacientes = new javax.swing.JMenuItem();
        menuItemAgendamento = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinica");
        setMaximumSize(new java.awt.Dimension(1293, 812));
        setResizable(false);
        getContentPane().setLayout(null);

        jDesktopPaneMedicos.setBackground(new java.awt.Color(240, 240, 240));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        painelBemVindo.setBackground(new java.awt.Color(255, 255, 255));
        painelBemVindo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelBemVindo.setLayout(null);
        jPanel1.add(painelBemVindo);
        painelBemVindo.setBounds(0, 0, 1290, 650);

        jDesktopPaneMedicos.add(jPanel1);
        jPanel1.setBounds(0, 0, 1290, 650);

        getContentPane().add(jDesktopPaneMedicos);
        jDesktopPaneMedicos.setBounds(0, 60, 1290, 650);

        lblBemVindo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(lblBemVindo);
        lblBemVindo.setBounds(10, 710, 150, 40);

        btnMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/medico.png"))); // NOI18N
        btnMedicos.setToolTipText("Dentista");
        btnMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicosActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedicos);
        btnMedicos.setBounds(0, 0, 70, 59);

        btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pacientes.png"))); // NOI18N
        btnPacientes.setToolTipText("Pacientes");
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPacientes);
        btnPacientes.setBounds(70, 0, 70, 59);

        btnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/agenda_2.png"))); // NOI18N
        btnAgenda.setToolTipText("Agenda");
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgenda);
        btnAgenda.setBounds(140, 0, 70, 59);

        menuCadastros.setText("Cadastros");
        menuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrosActionPerformed(evt);
            }
        });

        menuItemMenuMedicosOpcao.setText("Medicos");

        menuItemMenuEspecialidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemMenuEspecialidade.setText("Especialidade");
        menuItemMenuEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMenuEspecialidadeActionPerformed(evt);
            }
        });
        menuItemMenuMedicosOpcao.add(menuItemMenuEspecialidade);

        menuItemMenuMedicos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuItemMenuMedicos.setText("Medicos");
        menuItemMenuMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMenuMedicosActionPerformed(evt);
            }
        });
        menuItemMenuMedicosOpcao.add(menuItemMenuMedicos);

        menuCadastros.add(menuItemMenuMedicosOpcao);

        menuItemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuItemUsuarios.setText("Usuarios");
        menuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUsuariosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemUsuarios);

        menuItemPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menuItemPacientes.setText("Pacientes");
        menuItemPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPacientesActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemPacientes);

        menuItemAgendamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuItemAgendamento.setText("Agendamento");
        menuItemAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgendamentoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemAgendamento);

        jMenuBar1.add(menuCadastros);

        menuRelatorios.setText("Relatórios");
        jMenuBar1.add(menuRelatorios);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1293, 812));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed

    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        int i = JOptionPane.showConfirmDialog(null, "Deseja realmente sair? ", "Sair", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            conexao.desconeca();
            System.exit(0);
        }

    }//GEN-LAST:event_menuSairMouseClicked

    private void btnMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicosActionPerformed
        if (!medicos.isVisible()) {
            medicos = new TelaDentista();
            jDesktopPaneMedicos.add(medicos);
            medicos.setVisible(true);
        } else {
            medicos.toFront();
        }

    }//GEN-LAST:event_btnMedicosActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        if (!pacientes.isVisible()) {
            pacientes = new TelaPaciente();
            jDesktopPaneMedicos.add(pacientes);
            pacientes.setVisible(true);
        } else {
            pacientes.toFront();
        }
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        if(!telaAgendamento.isVisible()){
            telaAgendamento = new TelaAgendamento();
            jDesktopPaneMedicos.add(telaAgendamento);
            telaAgendamento.setVisible(true);
        }else{
            telaAgendamento.toFront();
        }
 
    }//GEN-LAST:event_btnAgendaActionPerformed

    private void menuItemPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPacientesActionPerformed
        if (!pacientes.isVisible()) {
            pacientes = new TelaPaciente();
            jDesktopPaneMedicos.add(pacientes);
            pacientes.setVisible(true);
        } else {
            pacientes.toFront();
        }
    }//GEN-LAST:event_menuItemPacientesActionPerformed

    private void menuItemMenuMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMenuMedicosActionPerformed
        if (!medicos.isVisible()) {
            medicos = new TelaDentista();
            jDesktopPaneMedicos.add(medicos);
            medicos.setVisible(true);
        } else {
            medicos.toFront();
        }
    }//GEN-LAST:event_menuItemMenuMedicosActionPerformed

    private void menuItemMenuEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMenuEspecialidadeActionPerformed
        if (!especialidadeDentista.isVisible()){
            especialidadeDentista = new EspecialidadeDentista();
            jDesktopPaneMedicos.add(especialidadeDentista);
            especialidadeDentista.setVisible(true);
        }else{
            especialidadeDentista.toFront();
        }

    }//GEN-LAST:event_menuItemMenuEspecialidadeActionPerformed

    private void menuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUsuariosActionPerformed
        JOptionPane.showMessageDialog(null, "Em construção");
    }//GEN-LAST:event_menuItemUsuariosActionPerformed

    private void menuItemAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgendamentoActionPerformed
         if(!telaAgendamento.isVisible()){
            telaAgendamento = new TelaAgendamento();
            jDesktopPaneMedicos.add(telaAgendamento);
            telaAgendamento.setVisible(true);
        }else{
            telaAgendamento.toFront();
        }
    }//GEN-LAST:event_menuItemAgendamentoActionPerformed

    private void menuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrosActionPerformed
       if(!telaAgendamento.isVisible()){
            telaAgendamento = new TelaAgendamento();
            jDesktopPaneMedicos.add(telaAgendamento);
            telaAgendamento.setVisible(true);
        }else{
            telaAgendamento.toFront();
        }
 
    }//GEN-LAST:event_menuCadastrosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnMedicos;
    private javax.swing.JButton btnPacientes;
    public static javax.swing.JDesktopPane jDesktopPaneMedicos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuItemAgendamento;
    private javax.swing.JMenuItem menuItemMenuEspecialidade;
    private javax.swing.JMenuItem menuItemMenuMedicos;
    private javax.swing.JMenu menuItemMenuMedicosOpcao;
    private javax.swing.JMenuItem menuItemPacientes;
    private javax.swing.JMenuItem menuItemUsuarios;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSair;
    private javax.swing.JPanel painelBemVindo;
    // End of variables declaration//GEN-END:variables
}
