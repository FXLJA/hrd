package views;

import java.sql.Date;
import java.util.List;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyVetoException;

import models.Pengangkatan;
import models.Divisi;
import main.OperasiCRUD;
import controllers.PengangkatanController;
import controllers.DivisiController;
import java.util.ArrayList;

public class PengangkatanForm extends javax.swing.JInternalFrame implements Observer
{
private final PengangkatanController peController = new PengangkatanController();
private final DivisiController dController = new DivisiController();
DefaultTableModel TableModel;

    public PengangkatanForm() 
    {
        initComponents();

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        List<String> listNamaDivisi = new ArrayList<>();
        
        for (Divisi d : dController.getAllDivisi())
        {
            listNamaDivisi.add(d.getNama_divisi());
        }
        
        setTabelDivisi(listNamaDivisi);
        setTabelPengangkatan(peController.getAllPengangkatan());
        
        peController.addObserver(this);
        resetForm();
    }
    
    private void setTabelDivisi(List<String> listJ)
    {
        if (listJ == null)
        {
            JOptionPane.showMessageDialog(this, "Data kosong",
                                          "Gagal koneksi", JOptionPane.ERROR_MESSAGE);
        }
            else
            {
                DivisiCbBox.setModel(new DefaultComboBoxModel(listJ.toArray()));
            }
    }
    
    private void setTabelPengangkatan (List<Pengangkatan> listPE)
    {
        if (listPE == null)
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
                        "Kode Karyawan", "Nama Divisi",
                        "Tanggal Pengangkatan", "Nomor SK"
                    }
                );
                                
                for (Pengangkatan pe : listPE)
                {
                    Divisi d = dController.getByID(pe.getKode_divisi());
                    String nama_divisi = null;

                    if(d != null)
                        nama_divisi = d.getNama_divisi();
                    
                    Object o [] = new Object [5];
                    o[0] = pe.getKode_karyawan();
                    o[1] = nama_divisi;
                    o[2] = pe.getTgl_angkat();
                    o[3] = pe.getSk();
                    TableModel.addRow(o);
                }
                
                TabelPengangkatan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TabelPengangkatan.setModel(TableModel);
            }
    }
    
    private void resetForm()
    {
        KodeK.setText(null);
        Tgl_angkat.setDate(null);
        NoSK.setText(null);
        
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
        
        KodeK.requestFocus();
    }
    
    private void tabletoForm()
    {
        KodeK.setText(TableModel.getValueAt(TabelPengangkatan.getSelectedRow(), 0) + "");
        DivisiCbBox.setSelectedItem(TableModel.getValueAt(TabelPengangkatan.getSelectedRow(), 1) + "");
        Tgl_angkat.setDate((Date)TableModel.getValueAt(TabelPengangkatan.getSelectedRow(), 2));
        NoSK.setText(TableModel.getValueAt(TabelPengangkatan.getSelectedRow(), 3) + "");
        
        KodeK.setEnabled(false);
        
        SaveB.setEnabled(false);
        EditB.setEnabled(true);
        DeleteB.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPengangkatan = new javax.swing.JTable();
        Label_KodeK = new javax.swing.JLabel();
        Label_Divisi = new javax.swing.JLabel();
        Label_Tanggal = new javax.swing.JLabel();
        Label_SK = new javax.swing.JLabel();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        Label_Judul = new javax.swing.JLabel();
        KodeK = new javax.swing.JTextField();
        NoSK = new javax.swing.JTextField();
        Tgl_angkat = new com.toedter.calendar.JDateChooser();
        DivisiCbBox = new javax.swing.JComboBox<>();

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

        TabelPengangkatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Karyawan", "Nama Divisi", "Tanggal Pengangkatan", "Nomor SK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelPengangkatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPengangkatanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPengangkatan);

        Label_KodeK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_KodeK.setText("Kode Karyawan");

        Label_Divisi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Divisi.setText("Nama Divisi");

        Label_Tanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Tanggal.setText("Tanggal Pengangkatan");

        Label_SK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_SK.setText("Nomor SK");

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

        Label_Judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        Label_Judul.setForeground(new java.awt.Color(204, 102, 0));
        Label_Judul.setText("Data Pengangkatan");

        NoSK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSKActionPerformed(evt);
            }
        });

        DivisiCbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADM", "CSH", "FIN", "HRD", "TRC"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(SaveB)
                                .addGap(18, 18, 18)
                                .addComponent(EditB)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteB)
                                .addGap(18, 18, 18)
                                .addComponent(ExitB))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_KodeK)
                                    .addComponent(Label_Divisi))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(KodeK, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(DivisiCbBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_Tanggal)
                                    .addComponent(Label_SK))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NoSK, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tgl_angkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Label_Judul)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Label_Judul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_KodeK)
                    .addComponent(KodeK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_Divisi)
                    .addComponent(DivisiCbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_Tanggal)
                    .addComponent(Tgl_angkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_SK)
                    .addComponent(NoSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
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
        if (KodeK.getText() == null)
        {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        }
            
            else if (Tgl_angkat.getCalendar() == null)
            {
                JOptionPane.showMessageDialog(null, "Harap isi tanggal pengangkatan Anda");
            }
            
            else if (NoSK == null)
            {
                JOptionPane.showMessageDialog(null, "Nomor SK tidak boleh kosong");
            }
                else
                {
                    String kode_karyawan = KodeK.getText();
                    String sk = NoSK.getText();
                    
                    Date tgl_angkat = new Date
                    (
                        Tgl_angkat.getDate().getYear(),
                        Tgl_angkat.getDate().getMonth(),
                        Tgl_angkat.getDate().getDate()
                    );

                    int indeks = DivisiCbBox.getSelectedIndex();
                    Divisi divisi = dController.getAllDivisi().get(indeks);  
                    
                    Pengangkatan pe = new Pengangkatan
                    (
                        divisi.getKode_divisi(),
                        divisi.getNama_divisi(),
                        kode_karyawan,
                        sk,
                        tgl_angkat
                    );  
                    
                    peController.setDml(pe, OperasiCRUD.INSERT);
                }
    }//GEN-LAST:event_SaveBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        String kode_karyawan = KodeK.getText();
        String sk = NoSK.getText();

        Date tgl_angkat = new Date
        (
            Tgl_angkat.getDate().getYear(),
            Tgl_angkat.getDate().getMonth(),
            Tgl_angkat.getDate().getDate()
        );

        int indeks = DivisiCbBox.getSelectedIndex();
        Divisi divisi = dController.getAllDivisi().get(indeks);  

        Pengangkatan pe = new Pengangkatan
                    (
                        divisi.getKode_divisi(),
                        divisi.getNama_divisi(),
                        kode_karyawan,
                        sk,
                        tgl_angkat
                    ); 
                    
        peController.setDml(pe, OperasiCRUD.UPDATE);
    }//GEN-LAST:event_EditBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
        String kode_karyawan = KodeK.getText();

        Pengangkatan pe = new Pengangkatan(null, null, kode_karyawan, null, null);

        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?",
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);

        if (hapus == JOptionPane.YES_OPTION)
        {
            peController.setDml(pe, OperasiCRUD.DELETE);
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

    private void NoSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSKActionPerformed

    private void TabelPengangkatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPengangkatanMouseClicked
        tabletoForm();
    }//GEN-LAST:event_TabelPengangkatanMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        List<String> listNamaDivisi = new ArrayList<>();
        
        for (Divisi d : dController.getAllDivisi())
        {
            listNamaDivisi.add(d.getNama_divisi());
        }
        
        setTabelDivisi(listNamaDivisi);
        setTabelPengangkatan(peController.getAllPengangkatan());
    }//GEN-LAST:event_formInternalFrameActivated

    @Override
    public void update(Observable o, Object arg)
    {
        if (o == peController)
        {
            Pengangkatan pe = (Pengangkatan) arg;
            
            if (null != peController.getCRUDState())
            {
                switch (peController.getCRUDState()) 
                {
                    case INSERT:
                    {
                        JOptionPane.showMessageDialog(this, "Data tersimpan");
                        break;
                    }
                    
                    case UPDATE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terupdate");
                        KodeK.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    case DELETE:
                    {
                        JOptionPane.showMessageDialog(this, "Data terhapus");
                        KodeK.setEnabled(true);
                        SaveB.setEnabled(true);
                        break;
                    }
                    
                    default:
                    {
                        break;
                    }
                }
            }
            
            setTabelPengangkatan(peController.getAllPengangkatan());
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
            java.util.logging.Logger.getLogger(PengangkatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengangkatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengangkatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengangkatanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new PengangkatanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteB;
    private javax.swing.JComboBox<String> DivisiCbBox;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JTextField KodeK;
    private javax.swing.JLabel Label_Divisi;
    private javax.swing.JLabel Label_Judul;
    private javax.swing.JLabel Label_KodeK;
    private javax.swing.JLabel Label_SK;
    private javax.swing.JLabel Label_Tanggal;
    private javax.swing.JTextField NoSK;
    private javax.swing.JButton SaveB;
    private javax.swing.JTable TabelPengangkatan;
    private com.toedter.calendar.JDateChooser Tgl_angkat;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}