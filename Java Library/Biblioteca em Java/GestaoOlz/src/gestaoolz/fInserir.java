/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestaoolz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Guest
 */
public class fInserir extends javax.swing.JFrame {

    /**
     * Creates new form fInserir
     */
    public fInserir() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        isbn0 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        autor0 = new javax.swing.JLabel();
        paginas0 = new javax.swing.JLabel();
        editora1 = new javax.swing.JLabel();
        tamanho0 = new javax.swing.JLabel();
        txt_isbn = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JTextField();
        txt_autor = new javax.swing.JTextField();
        txt_paginas = new javax.swing.JTextField();
        txt_editora = new javax.swing.JTextField();
        txt_tamanho = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Inserir Livros");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 16, -1, -1));

        isbn0.setText("isbn");
        getContentPane().add(isbn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 53, -1, -1));

        titulo1.setText("titulo");
        getContentPane().add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 93, -1, -1));

        autor0.setText("autor");
        getContentPane().add(autor0, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 139, -1, -1));

        paginas0.setText("N de paginas");
        getContentPane().add(paginas0, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 194, -1, -1));

        editora1.setText("Editora");
        getContentPane().add(editora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 241, -1, -1));

        tamanho0.setText("Tamanho");
        getContentPane().add(tamanho0, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 286, -1, -1));
        getContentPane().add(txt_isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 50, 170, -1));
        getContentPane().add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 90, 160, -1));
        getContentPane().add(txt_autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 136, 160, -1));

        txt_paginas.setToolTipText("");
        getContentPane().add(txt_paginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 191, 140, -1));
        getContentPane().add(txt_editora, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 238, 140, -1));
        getContentPane().add(txt_tamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 283, 120, -1));

        jButton1.setText("inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jButton2.setText("voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id22264273_bd_biblioteca", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(fInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con != null) {
            JOptionPane.showMessageDialog(null, "Ligação realizada com sucesso!");
            String isbn = this.txt_isbn.getText();
            String titulo = this.txt_titulo.getText();
            String autor = this.txt_autor.getText();
            int n_paginas = Integer.parseInt(this.txt_paginas.getText());
            String editora = this.txt_editora.getText();
            String tamanho = this.txt_tamanho.getText();

            String sql = "INSERT INTO livro(isbn, titulo, autor, n_paginas, editora, tamanho) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, isbn);
                pstmt.setString(2, titulo);
                pstmt.setString(3, autor);
                pstmt.setInt(4, n_paginas);
                pstmt.setString(5, editora);
                pstmt.setString(6, tamanho);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Registo inserido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao inserir o registo!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(fInserir.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ligação realizada sem sucesso!");
        }
        isbn0.setText("");
        titulo1.setText("");
        autor0.setText("");
        paginas0.setText("");
        editora1.setText("");
        tamanho0.setText("");                                      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fInserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fInserir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autor0;
    private javax.swing.JLabel editora1;
    private javax.swing.JLabel isbn0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel paginas0;
    private javax.swing.JLabel tamanho0;
    private javax.swing.JLabel titulo1;
    private javax.swing.JTextField txt_autor;
    private javax.swing.JTextField txt_editora;
    private javax.swing.JTextField txt_isbn;
    private javax.swing.JTextField txt_paginas;
    private javax.swing.JTextField txt_tamanho;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
