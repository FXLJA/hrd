package views;

import java.sql.Date;
import java.util.List;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyVetoException;

import models.Posisi;
import models.Jabatan;
import models.Pegawai;
import main.OperasiCRUD;
import controllers.PosisiController;
import controllers.JabatanController;
import controllers.PegawaiController;

public class PosisiForm extends javax.swing.JInternalFrame implements Observer
{
private final PosisiController poController = new PosisiController();
private final PegawaiController ptController = new PegawaiController();
private final JabatanController jController = new JabatanController();
DefaultTableModel TableModel;

String kode_pegawai;
String kode_jabatan;
int periode;
Date tgl_mulai;
Date tgl_selesai;

    public PosisiForm() 
    {
        initComponents();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        poController.addObserver(this);
        
        setTabelPosisi(poController.getAllPosisi());
        
        resetForm();
    }
    
    private void setTabelPosisi (List<Posisi> listPo)
    {
        if (listPo == null)
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
                    "Kode Pegawai", "Jabatan",
                    "Tanggal Mulai", "Tanggal Selesai",
                    "Periode"
                }
            );

            for (Posisi po : listPo){
                Jabatan j = jController.getbyID(po.getKode_jabatan());
                String nama_jabatan = null;
                
                if(j != null)
                    nama_jabatan = j.getNama_jabatan();
                
                Object o [] = new Object [6];
                o[0] = po.getKode_pegawai();
                o[1] = nama_jabatan;
                o[2] = po.getTgl_mulai();
                o[3] = po.getTgl_selesai();
                o[4] = po.getPeriode();

                TableModel.addRow(o);
            }

            TabelPosisi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            TabelPosisi.setModel(TableModel);
        }
    }
    
    
    @Override
    public void update(Observable o, Object arg)
    {
        if (o == poController)
        {
            Posisi po = (Posisi) arg;
            
            if (null != poController.getCRUDState())
            {
                switch (poController.getCRUDState()) 
                {
                    case INSERT:
                    {
                        JOptionPane.showMessageDialog(this, "Data tersimpan");
                        break;
                    }
                    
                    case UPDATE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terupdate");
                        KodeP.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    case DELETE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terhapus");
                        KodeP.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    default:
                    {
                        break;
                    }
                }
            }
            
            setTabelPosisi(poController.getAllPosisi());
            resetForm();
        }
    }
    
    private void updateData()
    {
        kode_pegawai = KodeP.getText();

        Pegawai pt = this.ptController.getByID(kode_pegawai);
        Jabatan j = jController.getbyID(pt.getKode_jabatan());
        kode_jabatan = j.getKode_jabatan();
        
        tgl_mulai = new Date
        (
            MulaiPosisi.getDate().getYear(),
            MulaiPosisi.getDate().getMonth(),
            MulaiPosisi.getDate().getDate()
        );
        
        tgl_selesai = new Date
        (
            SelesaiPosisi.getDate().getYear(),
            SelesaiPosisi.getDate().getMonth(),
            SelesaiPosisi.getDate().getDate()
        ); 
    }
    
    private void tabletoForm(){
        int indeks = TabelPosisi.getSelectedRow();
        
        if(indeks != -1){
            SaveB.setEnabled(false);
            EditB.setEnabled(true); 
            DeleteB.setEnabled(true);
            KodeP.setEnabled(false);
            
            KodeP.setText((String) TabelPosisi.getValueAt(indeks, 0));
            JabatanP.setText((String) TabelPosisi.getValueAt(indeks, 1));
            
            MulaiPosisi.setDate
            (
                new java.util.Date
                (
                    ((Date)TabelPosisi.getValueAt(indeks,2)).getTime()
                )
            );

            SelesaiPosisi.setDate
            (
                new java.util.Date
                (
                    ((Date)TabelPosisi.getValueAt(indeks,3)).getTime()
                )
            );
            
            int p = (int) TabelPosisi.getValueAt(indeks, 4);
            
            if (p == 1)
            {
                Periode1.setSelected(true);
                Periode2.setSelected(false);
                periode = 1;
            } 
                else 
                {
                    Periode2.setSelected(true);
                    Periode1.setSelected(false);
                    periode = 2;
                }
        }
    }
    
    private void resetForm()
    {
        KodeP.setText(null);
        JabatanP.setText(null);
        
        Label_isFound.setVisible(false);
        
        MulaiPosisi.setCalendar(null);
        SelesaiPosisi.setCalendar(null);
        
        Periode1.setSelected(false);
        Periode2.setSelected(false);
        
        SaveB.setEnabled(true);
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
        
        KodeP.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Judul = new javax.swing.JLabel();
        Label_KodeP = new javax.swing.JLabel();
        Label_JabatanP = new javax.swing.JLabel();
        MulaiPosisi = new com.toedter.calendar.JDateChooser();
        KodeP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPosisi = new javax.swing.JTable();
        Label_Mulai = new javax.swing.JLabel();
        Label_Selesai = new javax.swing.JLabel();
        SelesaiPosisi = new com.toedter.calendar.JDateChooser();
        Label_Periode = new javax.swing.JLabel();
        Periode1 = new javax.swing.JRadioButton();
        Periode2 = new javax.swing.JRadioButton();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        CariB = new javax.swing.JButton();
        Label_isFound = new javax.swing.JLabel();
        JabatanP = new javax.swing.JTextField();

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

        Label_Judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        Label_Judul.setForeground(new java.awt.Color(0, 153, 153));
        Label_Judul.setText("Data Posisi");

        Label_KodeP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_KodeP.setText("Kode Pegawai");

        Label_JabatanP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_JabatanP.setText("Jabatan");

        KodeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodePActionPerformed(evt);
            }
        });

        TabelPosisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Pegawai", "Jabatan", "Tanggal Mulai", "Tanggal Selesai", "Periode"
            }
        ));
        TabelPosisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPosisiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPosisi);

        Label_Mulai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Mulai.setText("Tanggal Mulai");

        Label_Selesai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Selesai.setText("Tanggal Selesai");

        Label_Periode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Periode.setText("Periode");

        Periode1.setText("1");
        Periode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Periode1ActionPerformed(evt);
            }
        });

        Periode2.setText("2");
        Periode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Periode2ActionPerformed(evt);
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

        CariB.setText("Cari");
        CariB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariBActionPerformed(evt);
            }
        });

        Label_isFound.setText("Pegawai ditemukan");

        JabatanP.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Label_Judul, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Label_KodeP)
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Label_isFound)
                                            .addComponent(KodeP, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(CariB))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_Mulai)
                                    .addComponent(Label_Periode)
                                    .addComponent(Label_JabatanP)
                                    .addComponent(Label_Selesai))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SelesaiPosisi, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(MulaiPosisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Periode1)
                                        .addGap(41, 41, 41)
                                        .addComponent(Periode2))
                                    .addComponent(JabatanP)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(SaveB)
                        .addGap(18, 18, 18)
                        .addComponent(EditB)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteB)
                        .addGap(18, 18, 18)
                        .addComponent(ExitB)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Judul)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_KodeP)
                    .addComponent(KodeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CariB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_isFound)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_JabatanP)
                    .addComponent(JabatanP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Mulai)
                    .addComponent(MulaiPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Selesai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SelesaiPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Periode)
                    .addComponent(Periode1)
                    .addComponent(Periode2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KodePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodePActionPerformed

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        // TODO add your handling code here:
        if (KodeP.getText() == null)
        {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        } 
            else if (MulaiPosisi.getCalendar() == null) 
            {
                JOptionPane.showMessageDialog(null, "Pilih tanggal mulai");
            } 

            else if (SelesaiPosisi.getCalendar() == null)
            {
                JOptionPane.showMessageDialog(null, "Pilih tanggal selesai");
            } 

            else if (!Periode1.isSelected() && !Periode2.isSelected()) 
            {
                JOptionPane.showMessageDialog(null, "Pilih jumlah periode");
            } 
                else 
                {
                    updateData();

                    Posisi po = new Posisi(
                            kode_pegawai,
                            kode_jabatan,
                            tgl_mulai,
                            tgl_selesai,
                            periode
                    );

                    poController.setDml(po, OperasiCRUD.INSERT);
                }
    }//GEN-LAST:event_SaveBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        updateData();       
        
        Posisi po = new Posisi 
        (
            kode_pegawai,
            kode_jabatan,
            tgl_mulai,
            tgl_selesai,
            periode
        );
        
        poController.setDml(po, OperasiCRUD.UPDATE);
    }//GEN-LAST:event_EditBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
        updateData();  
        
        Posisi po = new Posisi
        (
            kode_pegawai,
            kode_jabatan,
            tgl_mulai,
            tgl_selesai,
            periode
        );

        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?", 
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (hapus == JOptionPane.YES_OPTION)
        {
            poController.setDml(po, OperasiCRUD.DELETE);
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

    private void Periode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Periode1ActionPerformed
        // TODO add your handling code here:
        Periode2.setSelected(false);
        periode = 1;
    }//GEN-LAST:event_Periode1ActionPerformed

    private void Periode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Periode2ActionPerformed
        // TODO add your handling code here:
        Periode1.setSelected(false);
        periode = 2;
    }//GEN-LAST:event_Periode2ActionPerformed

    private void CariBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariBActionPerformed
        // TODO add your handling code here:
        String id = KodeP.getText();

        Pegawai pt = this.ptController.getByID(id);

        if (pt != null)
        {
            Label_isFound.setVisible(true);
            Label_isFound.setText("Pegawai ditemukan");
            
            Jabatan j = jController.getbyID(pt.getKode_jabatan());
            String nama_jabatan = j.getNama_jabatan();
            
            JabatanP.setText(nama_jabatan);

            MulaiPosisi.setEnabled(true);
            SelesaiPosisi.setEnabled(true);
        }
            else
            {
                Label_isFound.setVisible(true);
                Label_isFound.setText("Situ siapa?");
                
                MulaiPosisi.setEnabled(false);
                SelesaiPosisi.setEnabled(false);
            }
    }//GEN-LAST:event_CariBActionPerformed

    private void TabelPosisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPosisiMouseClicked
        tabletoForm();
    }//GEN-LAST:event_TabelPosisiMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        setTabelPosisi(poController.getAllPosisi());
    }//GEN-LAST:event_formInternalFrameActivated

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PosisiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new PosisiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CariB;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JTextField JabatanP;
    private javax.swing.JTextField KodeP;
    private javax.swing.JLabel Label_JabatanP;
    private javax.swing.JLabel Label_Judul;
    private javax.swing.JLabel Label_KodeP;
    private javax.swing.JLabel Label_Mulai;
    private javax.swing.JLabel Label_Periode;
    private javax.swing.JLabel Label_Selesai;
    private javax.swing.JLabel Label_isFound;
    private com.toedter.calendar.JDateChooser MulaiPosisi;
    private javax.swing.JRadioButton Periode1;
    private javax.swing.JRadioButton Periode2;
    private javax.swing.JButton SaveB;
    private com.toedter.calendar.JDateChooser SelesaiPosisi;
    private javax.swing.JTable TabelPosisi;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}