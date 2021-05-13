package conexao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Alunos extends javax.swing.JFrame {

    int global;  //salva se vai salvar ou editar

    DefaultTableModel model; //modelo da tabela
    int x = 0;

    Conexao con; //eh a conexao
    Statement st; //trabalha na conexao

    public Alunos() {
        initComponents();
    }

    public void mudabotoes(boolean btcadastrar, boolean bteditar, boolean btsalvar, boolean btexcluir, boolean btconsultar, boolean editis) {
        btCadastrar.setEnabled(btcadastrar);
        btEditar.setEnabled(bteditar);
        btSalvar.setEnabled(btsalvar);
        btExcluir.setEnabled(btexcluir);
        btConsultar.setEnabled(btconsultar);
        campoNome.setEnabled(editis);
        campoMatricula.setEnabled(editis);
        campoCidade.setEnabled(editis);
        campoEnderco.setEnabled(editis);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btConsultar = new javax.swing.JButton();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoEnderco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Matricula", "Endereço", "Cidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, 531, 250));

        btConsultar.setText("Consultar");
        btConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConsultarMouseClicked(evt);
            }
        });
        getContentPane().add(btConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 90, -1));

        button1.setLabel("button1");
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        button2.setLabel("button2");
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));
        getContentPane().add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 450, 30));

        jLabel2.setText("Matricula:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, -1));
        getContentPane().add(campoMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 450, 30));

        jLabel3.setText("Endereco");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));
        getContentPane().add(campoEnderco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 450, 30));

        jLabel4.setText("Cidade");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(campoCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 450, 30));

        btCadastrar.setText("Cadastrar");
        btCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(btCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        btExcluir.setText("Excluir");
        getContentPane().add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 90, -1));

        btEditar.setText("Editar");
        btEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditarMouseClicked(evt);
            }
        });
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 80, -1));

        btSalvar.setText("Salvar");
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSalvarMouseClicked(evt);
            }
        });
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 80, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultarMouseClicked
        int x = 0;
        model.setNumRows(0);
        String consulta = "select * from alunos";
        int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
        //otimizando
        if (!campoNome.getText().equals("")) {
            v1 = 1;
        }
//        consulta = consulta + " nome like '%"+campoNome.getText()+"%'";
        if (!campoMatricula.getText().equals("")) {
            v2 = 1;
        }
        //      consulta = consulta + "and MAT like '%"+campoNome.getText()+"%'";    
        if (!campoEnderco.getText().equals("")) {
            v3 = 1;
        }

        if (!campoCidade.getText().equals("")) {
            v4 = 1;
        }

        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1) {
            consulta = consulta + " where ";
        }
        //consulta top do Luís
        if (v1 == 1) {
            x++;
            consulta = consulta + "nome like '%" + campoNome.getText() + "%'";
        }
        if (v2 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "mat like '%" + campoMatricula.getText() + "%'";
            x++;
        }
        if (v3 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "endereco like '%" + campoEnderco.getText() + "%'";
            x++;
        }
        if (v4 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "cidade like '%" + campoCidade.getText() + "%'";
            x++;
        }

        /* consulta do sor
        if (v1 == 1) {
            consulta = consulta + "nome like '%" + campoNome.getText() + "%'";
            if (v2 == 1) {
                consulta = consulta + "and mat like '%" + campoMatricula.getText() + "%'";
            }
            if (v3 == 1) {
                consulta = consulta + "and endereco like '%" + campoEnderco.getText() + "%'";
            }
            if (v4 == 1) {
                consulta = consulta + "and cidade like '%" + campoCidade.getText() + "%'";
            }
        } else if (v2 == 1) {
            consulta = consulta + "mat like '%" + campoMatricula.getText() + "%'";
            if (v3 == 1) {
                consulta = consulta + "and endereco like '%" + campoEnderco.getText() + "%'";
            }
            if (v4 == 1) {
                consulta = consulta + "and cidade like '%" + campoCidade.getText() + "%'";
            }
        } else if (v3 == 1) {
            consulta = consulta + "endereco like '%" + campoEnderco.getText() + "%'";
            if (v4 == 1) {
                consulta = consulta + "and cidade like '%" + campoCidade.getText() + "%'";
            }
        } else if (v4 == 1) {
            consulta = consulta + "cidade like '%" + campoCidade.getText() + "%'";
        }
         */
 /*
        //funciona ok 
        if (!campoNome.getText().equals("") && (campoMatricula.getText().equals(""))) {
            consulta = "select * from alunos where nome like '%" + campoNome.getText() + "%'";
        } else if (campoNome.getText().equals("") && (!campoMatricula.getText().equals(""))) {
            consulta = "select * from alunos where mat like '%" + campoMatricula.getText() + "%'";
        } else if (!campoNome.getText().equals("") && (!campoMatricula.getText().equals(""))) {
            consulta = "select * from alunos where nome like '%" + campoNome.getText() + "%' and mat like '%" + campoMatricula.getText() + "%'";
        }
         */
        try {
            st.executeQuery(consulta);

            //serve para mostrar os resultados da consulta
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String mat = rs.getString("mat");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                model.addRow(new Object[]{nome, mat, endereco, cidade});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btConsultarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        Conexao con;
        try {
            con = new Conexao();
            st = con.conexao.createStatement();
        } catch (SQLException ex) {
            System.out.println("Deu erro no mysql.");
        }

        //pega o modelo da tabela  
        model = (DefaultTableModel) jTable1.getModel();
        //coloca a tabela com 0 linhas
        model.setNumRows(0);

        mudabotoes(true, true, false, true, true, false);

    }//GEN-LAST:event_formWindowOpened

    private void btCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCadastrarMouseClicked
        mudabotoes(false, false, true, false, false, true);
        global = 1;

    }//GEN-LAST:event_btCadastrarMouseClicked

    private void btSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMouseClicked


    }//GEN-LAST:event_btSalvarMouseClicked

    private void btEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditarMouseClicked
        mudabotoes(false, false, true, false, false, true);
        global = 2;
    }//GEN-LAST:event_btEditarMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (global == 1) {
            //entra se o botao salvar foi habilitado pelo cadastrar
            if (campoNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um nome, nao pode ser nulo, a nao ser que tenha o nome nulo, ai o nome pode ser nulo");
            } else if (campoCidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma cidade, nao pode ser nula");
            } else if (campoEnderco.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um endereco.");
            } else if (campoMatricula.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma matricula");
            } else {
                try {
                    st.executeUpdate("insert into alunos (mat,nome,endereco,cidade) values (" + Integer.parseInt(campoMatricula.getText()) + ",'" + campoNome.getText() + "','" + campoEnderco.getText() + "','" + campoCidade.getText() + "')");
                    mudabotoes(true, true, false, true, true, false);
                } catch (SQLException ex) {
                    System.out.println("deu erro no inserte ");
                }
            }

        } //caso seja editar
        else {
            //entra se o botao salvar foi habilitado pelo editar
            if (campoNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um nome, nao pode ser nulo, a nao ser que tenha o nome nulo, ai o nome pode ser nulo");
            } else if (campoCidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma cidade, nao pode ser nula");
            } else if (campoEnderco.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um endereco.");
            } else if (campoMatricula.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma matricula");
            } else {
                try {
                    st.executeUpdate("update alunos set nome = '" + campoNome.getText() + "' , cidade = '" + campoCidade.getText() + "'  where mat like " + campoMatricula.getText() + " ");
                    mudabotoes(true, true, false, true, true, false);
                } catch (SQLException ex) {
                    System.out.println("deu erro no inserte " + ex);
                }
            }
            
        }


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

    }//GEN-LAST:event_btEditarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoEnderco;
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
