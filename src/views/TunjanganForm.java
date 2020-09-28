package views;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyVetoException;

import main.OperasiCRUD;
import models.Tunjangan;
import controllers.TunjanganController;

public class TunjanganForm extends javax.swing.JInternalFrame implements Observer
{
private final TunjanganController tController = new TunjanganController();
DefaultTableModel TableModel;

    public TunjanganForm() 
    {
        initComponents();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setTabelTunjangan(tController.getAllTunjangan());
        
        tController.addObserver(this);
        resetForm();
    }

    private void setTabelTunjangan (List<Tunjangan> listT)
    {
        if (listT == null)
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
                        "Kode Tunjangan", "Nama Tunjangan", "Nilai"
                    }
                );
                
                for (Tunjangan t : listT)
                {
                    Object o [] = new Object [4];
                    o[0] = t.getKode_tunjangan();
                    o[1] = t.getNama_tunjangan();
                    o[2] = t.getNilai();
                    TableModel.addRow(o);
                }
                
                TabelTunjangan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TabelTunjangan.setModel(TableModel);
            }
    }
    
    private void resetForm()
    {
        KodeT.setText(null);
        NamaT.setText(null);
        NilaiT.setText(null);
        
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
        
        KodeT.requestFocus();
    }
    
    private void tabletoForm()
    {
        KodeT.setText(TableModel.getValueAt(TabelTunjangan.getSelectedRow(), 0) + "");
        NamaT.setText(TableModel.getValueAt(TabelTunjangan.getSelectedRow(), 1) + "");
        NilaiT.setText(TableModel.getValueAt(TabelTunjangan.getSelectedRow(), 2) + "");
        
        KodeT.setEnabled(false);
        
        SaveB.setEnabled(false);
        EditB.setEnabled(true);
        DeleteB.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelTunjangan = new javax.swing.JTable();
        Label_Judul = new javax.swing.JLabel();
        Label_KodeT = new javax.swing.JLabel();
        Label_NamaT = new javax.swing.JLabel();
        Label_NilaiT = new javax.swing.JLabel();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        KodeT = new javax.swing.JTextField();
        NamaT = new javax.swing.JTextField();
        NilaiT = new javax.swing.JTextField();

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

        TabelTunjangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Tunjangan", "Nama Tunjangan", "Nilai Tunjangan"
            }
        ));
        TabelTunjangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelTunjanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelTunjangan);

        Label_Judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        Label_Judul.setForeground(new java.awt.Color(153, 0, 153));
        Label_Judul.setText("Data Tunjangan");

        Label_KodeT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_KodeT.setText("Kode Tunjangan:");

        Label_NamaT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_NamaT.setText("Nama Tunjangan:");

        Label_NilaiT.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_NilaiT.setText("Nilai:");

        SaveB.setText("Save");
        SaveB.setPreferredSize(new java.awt.Dimension(55, 35));
        SaveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBActionPerformed(evt);
            }
        });

        EditB.setText("Edit");
        EditB.setPreferredSize(new java.awt.Dimension(51, 35));
        EditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBActionPerformed(evt);
            }
        });

        DeleteB.setText("Delete");
        DeleteB.setPreferredSize(new java.awt.Dimension(65, 35));
        DeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBActionPerformed(evt);
            }
        });

        ExitB.setText("Exit");
        ExitB.setPreferredSize(new java.awt.Dimension(51, 35));
        ExitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBActionPerformed(evt);
            }
        });

        KodeT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeTActionPerformed(evt);
            }
        });

        NamaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaTActionPerformed(evt);
            }
        });

        NilaiT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NilaiTActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Label_Judul)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_KodeT)
                                    .addComponent(Label_NamaT)
                                    .addComponent(Label_NilaiT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(NamaT, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(KodeT)
                                    .addComponent(NilaiT))))
                        .addGap(55, 55, 55)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Label_Judul)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KodeT)
                            .addComponent(Label_KodeT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_NamaT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_NilaiT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NilaiT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KodeTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeTActionPerformed

    private void NamaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaTActionPerformed

    private void NilaiTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NilaiTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NilaiTActionPerformed

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        // TODO add your handling code here:
        if (KodeT.getText() == null)
        {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        }
            else if (NamaT.getText() == null)
            {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
            }
                else
                {
                    String kode_tunjangan = KodeT.getText();
                    String nama_tunjangan = NamaT.getText();
                    double nilai = Double.parseDouble(NilaiT.getText());

                    Tunjangan t = new Tunjangan(kode_tunjangan, nama_tunjangan, nilai);
                    tController.setDml(t, OperasiCRUD.INSERT);            
                }        
    }//GEN-LAST:event_SaveBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        String kode_tunjangan = KodeT.getText();
        String nama_tunjangan = NamaT.getText();
        double nilai = Double.parseDouble(NilaiT.getText());
        
        Tunjangan t = new Tunjangan(kode_tunjangan, nama_tunjangan, nilai);
        tController.setDml(t, OperasiCRUD.UPDATE);        
    }//GEN-LAST:event_EditBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
        String kode_tunjangan = KodeT.getText();
        String nama_tunjangan = NamaT.getText();
        double nilai = Double.parseDouble(NilaiT.getText());
        
        Tunjangan t = new Tunjangan(kode_tunjangan, nama_tunjangan, nilai);
        tController.setDml(t, OperasiCRUD.UPDATE);
        
        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?", 
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (hapus == JOptionPane.YES_OPTION)
        {
            tController.setDml(t, OperasiCRUD.DELETE);
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

    private void TabelTunjanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelTunjanganMouseClicked
        // TODO add your handling code here:
        tabletoForm();
    }//GEN-LAST:event_TabelTunjanganMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
       setTabelTunjangan(tController.getAllTunjangan());
    }//GEN-LAST:event_formInternalFrameActivated

    @Override
    public void update(Observable o, Object arg)
    {
        if (o == tController)
        {
            Tunjangan t = (Tunjangan) arg;
            
            if (null != tController.getCRUDState())
            {
                switch (tController.getCRUDState()) 
                {
                    case INSERT:
                    {
                        JOptionPane.showMessageDialog(this, "Data tersimpan");
                        break;
                    }
                    
                    case UPDATE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terupdate");
                        KodeT.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    case DELETE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terhapus");
                        KodeT.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    default:
                    {
                        break;
                    }
                }
            }
            
            setTabelTunjangan(tController.getAllTunjangan());
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
            java.util.logging.Logger.getLogger(TunjanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TunjanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TunjanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TunjanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new TunjanganForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JTextField KodeT;
    private javax.swing.JLabel Label_Judul;
    private javax.swing.JLabel Label_KodeT;
    private javax.swing.JLabel Label_NamaT;
    private javax.swing.JLabel Label_NilaiT;
    private javax.swing.JTextField NamaT;
    private javax.swing.JTextField NilaiT;
    private javax.swing.JButton SaveB;
    private javax.swing.JTable TabelTunjangan;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}