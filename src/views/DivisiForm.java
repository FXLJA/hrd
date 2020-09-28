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

import models.Divisi;
import main.OperasiCRUD;
import controllers.DivisiController;

public class DivisiForm extends javax.swing.JInternalFrame implements Observer
{
private final DivisiController dController = new DivisiController();
DefaultTableModel TableModel;

    public DivisiForm() 
    {
        initComponents();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setTabelDivisi(dController.getAllDivisi());
        
        dController.addObserver(this);
        resetForm();
    }

    private void setTabelDivisi (List<Divisi> listD)
    {
        if (listD == null)
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
                        "Kode Divisi", "Nama Divisi"
                    }
                );
                
                for (Divisi d : listD)
                {
                    Object o [] = new Object [3];
                    o[0] = d.getKode_divisi();
                    o[1] = d.getNama_divisi();
                    TableModel.addRow(o);
                }
                
                TabelDivisi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TabelDivisi.setModel(TableModel);
            }
    }

    private void resetForm()
    {
        KodeD.setText(null);
        NamaD.setText(null);
        
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
        
        KodeD.requestFocus();
    }
    
    private void tabletoForm()
    {
        KodeD.setText(TableModel.getValueAt(TabelDivisi.getSelectedRow(), 0) + "");
        NamaD.setText(TableModel.getValueAt(TabelDivisi.getSelectedRow(), 1) + "");
        
        KodeD.setEnabled(false);
        
        SaveB.setEnabled(false);
        EditB.setEnabled(true);
        DeleteB.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelDivisi = new javax.swing.JTable();
        Label_Judul = new javax.swing.JLabel();
        Label_KodeD = new javax.swing.JLabel();
        Label_NamaD = new javax.swing.JLabel();
        KodeD = new javax.swing.JTextField();
        NamaD = new javax.swing.JTextField();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();

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

        TabelDivisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Divisi", "Nama Divisi"
            }
        ));
        TabelDivisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDivisiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelDivisi);

        Label_Judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        Label_Judul.setForeground(new java.awt.Color(255, 0, 51));
        Label_Judul.setText("Data Divisi");

        Label_KodeD.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_KodeD.setText("Kode Divisi:");

        Label_NamaD.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_NamaD.setText("Nama Divisi:");

        KodeD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeDActionPerformed(evt);
            }
        });

        NamaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaDActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(Label_Judul))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_KodeD, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(KodeD, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_NamaD)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SaveB)
                                        .addGap(18, 18, 18)
                                        .addComponent(EditB)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DeleteB)
                                        .addGap(20, 20, 20)
                                        .addComponent(ExitB))
                                    .addComponent(NamaD, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Label_Judul)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_KodeD)
                    .addComponent(KodeD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_NamaD)
                    .addComponent(NamaD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KodeDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeDActionPerformed

    private void NamaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaDActionPerformed

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        // TODO add your handling code here:
        if (KodeD.getText() == null)
        {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        }
            else if (NamaD.getText() == null)
            {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
            }
                else
                {
                    String kode_divisi = KodeD.getText();
                    String nama_divisi = NamaD.getText();

                    Divisi d = new Divisi(kode_divisi, nama_divisi);
                    dController.setDml(d, OperasiCRUD.INSERT);            
                }        
    }//GEN-LAST:event_SaveBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        String kode_divisi = KodeD.getText();
        String nama_divisi = NamaD.getText();
        
        Divisi d = new Divisi(kode_divisi, nama_divisi);
        dController.setDml(d, OperasiCRUD.UPDATE);        
    }//GEN-LAST:event_EditBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
        String kode_divisi = KodeD.getText();
        String nama_divisi = NamaD.getText();
        
        Divisi d = new Divisi(kode_divisi, nama_divisi);
        
        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?", 
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (hapus == JOptionPane.YES_OPTION)
        {
            dController.setDml(d, OperasiCRUD.DELETE);
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

    private void TabelDivisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDivisiMouseClicked
        // TODO add your handling code here:
        tabletoForm();
    }//GEN-LAST:event_TabelDivisiMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        setTabelDivisi(dController.getAllDivisi());
    }//GEN-LAST:event_formInternalFrameActivated
    
    @Override
    public void update(Observable o, Object arg)
    {
        if (o == dController)
        {
            Divisi d = (Divisi) arg;
            
            if (null != dController.getCRUDState())
            {
                switch (dController.getCRUDState()) 
                {
                    case INSERT:
                    {
                        JOptionPane.showMessageDialog(this, "Data tersimpan");
                        break;
                    }
                    
                    case UPDATE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terupdate");
                        KodeD.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    case DELETE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terhapus");
                        KodeD.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    default:
                    {
                        break;
                    }
                }
            }
            
            setTabelDivisi(dController.getAllDivisi());
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
            java.util.logging.Logger.getLogger(DivisiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DivisiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DivisiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DivisiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new DivisiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JTextField KodeD;
    private javax.swing.JLabel Label_Judul;
    private javax.swing.JLabel Label_KodeD;
    private javax.swing.JLabel Label_NamaD;
    private javax.swing.JTextField NamaD;
    private javax.swing.JButton SaveB;
    private javax.swing.JTable TabelDivisi;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}