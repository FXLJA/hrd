package views;

import java.util.List;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyVetoException;

import models.Jabatan;
import main.OperasiCRUD;
import controllers.JabatanController;

public class JabatanForm extends javax.swing.JInternalFrame implements Observer
{
private final JabatanController jController = new JabatanController();
DefaultTableModel TableModel;

    public JabatanForm() 
    {
        initComponents();

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        setTabelJabatan(jController.getAllJabatan());
        
        jController.addObserver(this);
        resetForm();
    } 

    private void setTabelJabatan (List<Jabatan> listJ)
    {
        if (listJ == null)
        {
            JOptionPane.showMessageDialog(this, "Daftar kosong",
                                          "Gagal koneksi", JOptionPane.ERROR_MESSAGE);
        }
            else
            {
                TableModel = new DefaultTableModel();
                TableModel.setColumnIdentifiers
                (
                    new String[]
                    {
                        "Kode Jabatan", "Nama Jabatan"
                    }
                );
                
                for (Jabatan j : listJ)
                {
                    Object o [] = new Object [3];
                    o[0] = j.getKode_jabatan();
                    o[1] = j.getNama_jabatan();
                    TableModel.addRow(o);
                }
                
                TabelJabatan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TabelJabatan.setModel(TableModel);
            }
    }
    
    private void resetForm()
    {
        KodeJ.setText(null);
        NamaJ.setText(null);
        
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
        
        KodeJ.requestFocus();
    }
    
    private void tabletoForm()
    {
        KodeJ.setText(TableModel.getValueAt(TabelJabatan.getSelectedRow(), 0) + "");
        NamaJ.setText(TableModel.getValueAt(TabelJabatan.getSelectedRow(), 1) + "");
        
        KodeJ.setEnabled(false);
        
        SaveB.setEnabled(false);
        EditB.setEnabled(true);
        DeleteB.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelJudul = new javax.swing.JLabel();
        Label_KodeJ = new javax.swing.JLabel();
        Label_NamaJ = new javax.swing.JLabel();
        KodeJ = new javax.swing.JTextField();
        NamaJ = new javax.swing.JTextField();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelJabatan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        LabelJudul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        LabelJudul.setForeground(new java.awt.Color(51, 51, 255));
        LabelJudul.setText("Data Jabatan");

        Label_KodeJ.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_KodeJ.setText("Kode Jabatan: ");

        Label_NamaJ.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_NamaJ.setText("Nama Jabatan:");

        KodeJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeJActionPerformed(evt);
            }
        });

        NamaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaJActionPerformed(evt);
            }
        });

        SaveB.setText("Save");
        SaveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBActionPerformed(evt);
            }
        });

        EditB.setText("Edit");
        EditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBActionPerformed(evt);
            }
        });

        DeleteB.setText("Delete");
        DeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBActionPerformed(evt);
            }
        });

        ExitB.setText("Exit");
        ExitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBActionPerformed(evt);
            }
        });

        TabelJabatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Jabatan", "Nama Jabatan"
            }
        ));
        TabelJabatan.getTableHeader().setReorderingAllowed(false);
        TabelJabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelJabatanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelJabatan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_KodeJ)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(SaveB)
                                    .addGap(18, 18, 18)
                                    .addComponent(EditB))
                                .addComponent(Label_NamaJ)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DeleteB)
                                .addGap(18, 18, 18)
                                .addComponent(ExitB))
                            .addComponent(KodeJ, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NamaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(LabelJudul)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LabelJudul)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_KodeJ)
                    .addComponent(KodeJ, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_NamaJ)
                    .addComponent(NamaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NamaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaJActionPerformed

    private void KodeJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeJActionPerformed

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        // TODO add your handling code here:
        if (KodeJ.getText() == null)
        {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        }
            else if (NamaJ.getText() == null)
            {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
            }
                else
                {
                    String kode_jabatan = KodeJ.getText();
                    String nama_jabatan = NamaJ.getText();

                    Jabatan j = new Jabatan(kode_jabatan, nama_jabatan);
                    jController.setDml(j, OperasiCRUD.INSERT);            
                }
    }//GEN-LAST:event_SaveBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        String kode_jabatan = KodeJ.getText();
        String nama_jabatan = NamaJ.getText();
        
        Jabatan j = new Jabatan(kode_jabatan, nama_jabatan);
        jController.setDml(j, OperasiCRUD.UPDATE);
    }//GEN-LAST:event_EditBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
        String kode_jabatan = KodeJ.getText();
        String nama_jabatan = NamaJ.getText();
        
        Jabatan j = new Jabatan (kode_jabatan, nama_jabatan);
        
        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?", 
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (hapus == JOptionPane.YES_OPTION)
        {
            jController.setDml(j, OperasiCRUD.DELETE);
        }
    }//GEN-LAST:event_DeleteBActionPerformed

    private void ExitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBActionPerformed
        // TODO add your handling code here:
        resetForm();
        
        try 
        {
            setClosed(true);
            setClosed(false);
        } 
        catch (PropertyVetoException ex) 
        {
            Logger.getLogger(JabatanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ExitBActionPerformed

    private void TabelJabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelJabatanMouseClicked
        // TODO add your handling code here:
        tabletoForm();
    }//GEN-LAST:event_TabelJabatanMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        setTabelJabatan(jController.getAllJabatan());
    }//GEN-LAST:event_formInternalFrameActivated

    @Override
    public void update(Observable o, Object arg)
    {
        if (o == jController)
        {
            Jabatan j = (Jabatan) arg;
            
            if (null != jController.getCRUDState())
            {
                switch (jController.getCRUDState()) 
                {
                    case INSERT:
                    {
                        JOptionPane.showMessageDialog(this, "Data tersimpan");
                        break;
                    }
                    
                    case UPDATE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terupdate");
                        KodeJ.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    case DELETE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terhapus");
                        KodeJ.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    default:
                    {
                        break;
                    }
                }                
            }
            
            setTabelJabatan(jController.getAllJabatan());
            resetForm();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(JabatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JabatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JabatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JabatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new JabatanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JTextField KodeJ;
    private javax.swing.JLabel LabelJudul;
    private javax.swing.JLabel Label_KodeJ;
    private javax.swing.JLabel Label_NamaJ;
    private javax.swing.JTextField NamaJ;
    private javax.swing.JButton SaveB;
    private javax.swing.JTable TabelJabatan;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}