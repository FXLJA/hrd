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
import models.Detail;
import models.Pegawai;
import controllers.DetailController;
import controllers.PegawaiController;


public class DetailForm extends javax.swing.JInternalFrame implements Observer
{
private final DetailController dtController = new DetailController();
private final PegawaiController ptController = new PegawaiController();
DefaultTableModel TableModel;

    public DetailForm() 
    {
        initComponents();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setTabelDetail(dtController.getAllDetail());
        
        dtController.addObserver(this);
        
        resetForm();
    }

    private void setTabelDetail (List<Detail> listDt)
    {
        if (listDt == null)
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
                        "Kode Pegawai", "Nama Istri / Suami", "Jumlah Anak"
                    }
                );
                
                for (Detail dt : listDt)
                {
                    Object o [] = new Object [3];
                    o[0] = dt.getKode_pegawai();
                    o[1] = dt.getNama_hw();
                    o[2] = dt.getJumlah_anak();
                    TableModel.addRow(o);
                }
                
                TabelDetail.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TabelDetail.setModel(TableModel);
            }
    }

    private void resetForm()
    {
        Label_isFound.setVisible(false);
        
        KodeDt.setText(null);
        
        NamaHW.setText(null);
        NamaHW.setEnabled(false);
        
        JumlahDt.setText(null);
        JumlahDt.setEnabled(false);
        
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
        
        KodeDt.requestFocus();
    }
    
    private void tabletoForm()
    {
        KodeDt.setText(TableModel.getValueAt(TabelDetail.getSelectedRow(), 0) + "");
        NamaHW.setText(TableModel.getValueAt(TabelDetail.getSelectedRow(), 1) + "");
        JumlahDt.setText(TableModel.getValueAt(TabelDetail.getSelectedRow(), 2) + "");
        
        KodeDt.setEnabled(false);
        
        SaveB.setEnabled(false);
        EditB.setEnabled(true);
        DeleteB.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelDetail = new javax.swing.JTable();
        Label_Judul = new javax.swing.JLabel();
        Label_KodeDt = new javax.swing.JLabel();
        Label_NamaHW = new javax.swing.JLabel();
        Label_JumlahDt = new javax.swing.JLabel();
        KodeDt = new javax.swing.JTextField();
        NamaHW = new javax.swing.JTextField();
        JumlahDt = new javax.swing.JTextField();
        Label_isFound = new javax.swing.JLabel();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        BCari = new javax.swing.JButton();

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

        TabelDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Pegawai", "Nama Istri/Suami", "Jumlah Anak"
            }
        ));
        TabelDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelDetail);

        Label_Judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        Label_Judul.setForeground(new java.awt.Color(0, 204, 51));
        Label_Judul.setText("Data Detail Pegawai");

        Label_KodeDt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_KodeDt.setText("Kode Pegawai");

        Label_NamaHW.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_NamaHW.setText("Nama Istri/Suami");

        Label_JumlahDt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_JumlahDt.setText("Jumlah Anak");

        Label_isFound.setText("Pegawai ditemukan");

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

        BCari.setText("Cari");
        BCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCariActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_JumlahDt)
                                    .addComponent(Label_NamaHW))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NamaHW, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(JumlahDt)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_KodeDt)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_isFound)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(KodeDt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BCari)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Judul)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SaveB)
                                .addGap(18, 18, 18)
                                .addComponent(EditB)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteB)
                                .addGap(18, 18, 18)
                                .addComponent(ExitB)))
                        .addGap(53, 53, 53)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Judul)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_KodeDt)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(KodeDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BCari)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_isFound)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_NamaHW)
                    .addComponent(NamaHW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_JumlahDt)
                    .addComponent(JumlahDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        // TODO add your handling code here:        
        if (KodeDt.getText() == null)
        {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        }
            else if (NamaHW.getText() == null)
            {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
            }
                else
                {
                    String kode_pegawai = KodeDt.getText();
                    String nama_hw = NamaHW.getText();
                    String jumlah_anak = JumlahDt.getText();

                    Detail dt = new Detail(kode_pegawai, nama_hw, jumlah_anak);
                    dtController.setDml(dt, OperasiCRUD.INSERT);
                }
    }//GEN-LAST:event_SaveBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        String kode_pegawai = KodeDt.getText();
        String nama_hw = NamaHW.getText();
        String jumlah_anak = JumlahDt.getText();
        
        Detail dt = new Detail(kode_pegawai, nama_hw, jumlah_anak);
        dtController.setDml(dt, OperasiCRUD.UPDATE);
    }//GEN-LAST:event_EditBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
        String kode_pegawai = KodeDt.getText();
        String nama_hw = NamaHW.getText();
        String jumlah_anak = JumlahDt.getText();
        
        Detail dt = new Detail(kode_pegawai, nama_hw, jumlah_anak);

        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?",
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);

        if (hapus == JOptionPane.YES_OPTION)
        {
            dtController.setDml(dt, OperasiCRUD.DELETE);
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

    private void BCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCariActionPerformed
        // TODO add your handling code here:        
        String id = KodeDt.getText();
        
        Pegawai dt = ptController.getByID(id);
        
        Label_isFound.setVisible(true);
        NamaHW.setEnabled(true);
        JumlahDt.setEnabled(true);
        
        if(dt != null) 
        {
        String status = dt.getStatus();
            
            if (status.equals("Menikah"))
            {
                Label_isFound.setText("Pegawai ditemukan");
                return;
            }
                else 
                {
                    Label_isFound.setText("Pegawai belum menikah");
                }
        } 
            else 
            {
                Label_isFound.setText("Situ siapa?");
            }
        
        NamaHW.setEnabled(false);
        JumlahDt.setEnabled(false);
    }//GEN-LAST:event_BCariActionPerformed

    private void TabelDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDetailMouseClicked
        // TODO add your handling code here:
        tabletoForm();
        NamaHW.setEnabled(true);
        JumlahDt.setEnabled(true);
    }//GEN-LAST:event_TabelDetailMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        setTabelDetail(dtController.getAllDetail());
    }//GEN-LAST:event_formInternalFrameActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracleLabel_Judulvase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
                 javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | 
                 InstantiationException | 
                 IllegalAccessException | 
                 javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(DetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCari;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JTextField JumlahDt;
    private javax.swing.JTextField KodeDt;
    private javax.swing.JLabel Label_Judul;
    private javax.swing.JLabel Label_JumlahDt;
    private javax.swing.JLabel Label_KodeDt;
    private javax.swing.JLabel Label_NamaHW;
    private javax.swing.JLabel Label_isFound;
    private javax.swing.JTextField NamaHW;
    private javax.swing.JButton SaveB;
    private javax.swing.JTable TabelDetail;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg)
    {
        if (o == dtController)
        {
            Detail dt = (Detail) arg;
            
            if (null != dtController.getCRUDState())
            {
                switch (dtController.getCRUDState()) 
                {
                    case INSERT:
                    {
                        JOptionPane.showMessageDialog(this, "Data tersimpan");
                        break;
                    }
                    
                    case UPDATE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terupdate");
                        KodeDt.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    case DELETE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terhapus");
                        KodeDt.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    default:
                    {
                        break;
                    }
                }

                setTabelDetail(dtController.getAllDetail());
                resetForm();
            }
        }
    }
}