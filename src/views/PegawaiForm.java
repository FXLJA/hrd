package views;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyVetoException;

import models.Jabatan;
import models.Pegawai;
import main.OperasiCRUD;
import controllers.JabatanController;
import controllers.PegawaiController;

public class PegawaiForm extends javax.swing.JInternalFrame implements Observer
{
private final PegawaiController ptController = new PegawaiController();
private final JabatanController jController = new JabatanController();
DefaultTableModel tableModel;

String kode_jabatan;
Date tgl_lahir;
Date tgl_masuk;
String jenis_kelamin;
String status;

    public PegawaiForm() 
    {
        initComponents();
        
        ptController.addObserver(this);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        List<String> listNamaJabatan = new ArrayList<>();
        
        for (Jabatan j : jController.getAllJabatan())
        {
            listNamaJabatan.add(j.toString());
        }
        
        setTabelJabatan(listNamaJabatan);
        setTabelPegawai(ptController.getAllPegawaiTetap());

        resetForm();
    }
    
    private void setTabelJabatan(List<String> listJ)
    {
        if (listJ == null)
        {
            JOptionPane.showMessageDialog(this, "Data kosong",
                                          "Gagal koneksi", JOptionPane.ERROR_MESSAGE);
        }
            else
            {
                JabatanCbBox.setModel(new DefaultComboBoxModel(listJ.toArray()));
            }
    }
    
    private void setTabelPegawai(List<Pegawai> listPT)
    {
        if (listPT == null)
        {
            JOptionPane.showMessageDialog(this, "Data kosong", 
                                          "Gagal koneksi", JOptionPane.ERROR_MESSAGE);
        }
            else
            {
                tableModel = new DefaultTableModel();
                tableModel.setColumnIdentifiers
                (
                    new String[]
                    {
                        "Kode Pegawai", "Nama pegawai", "Jabatan",
                        "Tanggal Lahir", "Jenis Kelamin", 
                        "Status", "Tanggal Masuk"
                    }
                );
                
                for (Pegawai pt : listPT)
                {
                    Jabatan j = jController.getbyID(pt.getKode_jabatan());
                    String nama_jabatan=null;
                    if(j != null)
                        nama_jabatan = j.getNama_jabatan();
                    
                    Object[] o = new Object[8];
                    o[0] = pt.getKode_pegawai(); 
                    o[1] = pt.getNama();
                    o[2] = nama_jabatan;
                    o[3] = pt.getTgl_lahir();
                    o[4] = pt.getJenis_kelamin();
                    o[5] = pt.getStatus();
                    o[6] = pt.getTgl_masuk();
                    
                    tableModel.addRow(o);
                }
                
                TabelP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TabelP.setModel(tableModel);
            }
    }
    
    private void resetForm()
    {
        KodeP.setText("");
        KodeP.setEditable(true);
        
        NamaP.setText("");
        NamaP.setEditable(true);
        
        TanggalP.setCalendar(null);
        MasukP.setCalendar(null);
        
        BPria.setSelected(false);
        BWanita.setSelected(false);
        BMenikah.setSelected(false);
        BBelum_Menikah.setSelected(false);
        
        SaveB.setEnabled(true);
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
    }
    
    private void tabletoform(){
        int indeks = TabelP.getSelectedRow();
        
        if(indeks != -1)
        {
            SaveB.setEnabled(false);
            EditB.setEnabled(true); 
            DeleteB.setEnabled(true);
            KodeP.setEnabled(false);
            
            KodeP.setText((String) TabelP.getValueAt(indeks, 0));
            NamaP.setText((String) TabelP.getValueAt(indeks, 1));
            
            TanggalP.setDate
            (
                new java.util.Date
                (
                    ((Date)TabelP.getValueAt(indeks,3)).getTime()
                )
            );
            
            String jk = (String) TabelP.getValueAt(indeks, 4);
            
            if (jk.equals("Pria"))
            {
                BPria.setSelected(true);
                BWanita.setSelected(false);
                jenis_kelamin = "Pria";
            } 
                else 
                {
                    BWanita.setSelected(true);
                    BPria.setSelected(false);
                    jenis_kelamin = "Wanita";
                }
            
            status = (String) TabelP.getValueAt(indeks, 5);
            
            if ("Menikah".equals(status))
            {
                BMenikah.setSelected(true);
                BBelum_Menikah.setSelected(false);
                status = "Menikah";
            } 
                else 
                {
                    BBelum_Menikah.setSelected(true);
                    BMenikah.setSelected(false);
                    status = "Belum Menikah";
                }
            
            JabatanCbBox.setSelectedItem
            (
                TabelP.getValueAt(indeks,2)
            );
            
            MasukP.setDate
            (
                new java.util.Date
                (
                    ((Date)TabelP.getValueAt(indeks,6)).getTime()
                )
            );
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_KodeP = new javax.swing.JLabel();
        Label_NamaP = new javax.swing.JLabel();
        Label_JabatanP = new javax.swing.JLabel();
        Label_JenisP = new javax.swing.JLabel();
        Label_StatusP = new javax.swing.JLabel();
        Label_TanggalP = new javax.swing.JLabel();
        Label_MasukP = new javax.swing.JLabel();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        KodeP = new javax.swing.JTextField();
        NamaP = new javax.swing.JTextField();
        BPria = new javax.swing.JRadioButton();
        BWanita = new javax.swing.JRadioButton();
        BMenikah = new javax.swing.JRadioButton();
        BBelum_Menikah = new javax.swing.JRadioButton();
        JabatanCbBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelP = new javax.swing.JTable();
        TanggalP = new com.toedter.calendar.JDateChooser();
        MasukP = new com.toedter.calendar.JDateChooser();

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

        Label_KodeP.setText("Kode Pegawai");

        Label_NamaP.setText("Nama Pegawai");

        Label_JabatanP.setText("Jabatan");

        Label_JenisP.setText("Jenis Kelamin");

        Label_StatusP.setText("Status");

        Label_TanggalP.setText("Tanggal Lahir");

        Label_MasukP.setText("Tanggal Masuk");

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

        KodeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodePActionPerformed(evt);
            }
        });

        NamaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaPActionPerformed(evt);
            }
        });

        BPria.setText("Pria");
        BPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPriaActionPerformed(evt);
            }
        });

        BWanita.setText("Wanita");
        BWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BWanitaActionPerformed(evt);
            }
        });

        BMenikah.setText("Menikah");
        BMenikah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMenikahActionPerformed(evt);
            }
        });

        BBelum_Menikah.setText("Belum Menikah");
        BBelum_Menikah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBelum_MenikahActionPerformed(evt);
            }
        });

        JabatanCbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Akuntan", "Manager", "Direktur", "IT Support" , "Personalia", "Supervisor" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Data Pegawai");

        TabelP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Pegawai", "Nama Pegawai", "Kode Jabatan", "Tanggal Lahir", "Jenis Kelamin", "Status", "Tanggal Masuk"
            }
        ));
        TabelP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_KodeP)
                                    .addComponent(Label_NamaP)
                                    .addComponent(Label_StatusP)
                                    .addComponent(Label_JabatanP)
                                    .addComponent(Label_MasukP)
                                    .addComponent(SaveB)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(Label_TanggalP)))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(EditB)
                                        .addGap(29, 29, 29)
                                        .addComponent(DeleteB)
                                        .addGap(23, 23, 23)
                                        .addComponent(ExitB))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(KodeP, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NamaP, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TanggalP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(BMenikah)
                                                .addGap(2, 2, 2)
                                                .addComponent(BBelum_Menikah))
                                            .addComponent(JabatanCbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MasukP, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Label_JenisP)
                                .addGap(35, 35, 35)
                                .addComponent(BPria)
                                .addGap(18, 18, 18)
                                .addComponent(BWanita)))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(KodeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(NamaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(Label_KodeP)
                                .addGap(29, 29, 29)
                                .addComponent(Label_NamaP)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_TanggalP)
                            .addComponent(TanggalP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(Label_JenisP))
                            .addComponent(BPria)
                            .addComponent(BWanita))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(Label_StatusP)
                                .addGap(41, 41, 41)
                                .addComponent(Label_JabatanP)
                                .addGap(33, 33, 33)
                                .addComponent(Label_MasukP)
                                .addGap(18, 18, 18)
                                .addComponent(SaveB))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BMenikah)
                                    .addComponent(BBelum_Menikah))
                                .addGap(32, 32, 32)
                                .addComponent(JabatanCbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(MasukP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EditB)
                                    .addComponent(DeleteB)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(ExitB)))))))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BBelum_MenikahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBelum_MenikahActionPerformed
        // TODO add your handling code here:
        BMenikah.setSelected(false);
        status = "Belum Menikah";
    }//GEN-LAST:event_BBelum_MenikahActionPerformed

    private void BMenikahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMenikahActionPerformed
        // TODO add your handling code here:
        BBelum_Menikah.setSelected(false);
        status = "Menikah";
    }//GEN-LAST:event_BMenikahActionPerformed

    private void BWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BWanitaActionPerformed
        // TODO add your handling code here:
        BPria.setSelected(false);
        jenis_kelamin = "Wanita";
    }//GEN-LAST:event_BWanitaActionPerformed

    private void BPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPriaActionPerformed
        // TODO add your handling code here:
        BWanita.setSelected(false);
        jenis_kelamin = "Pria";
    }//GEN-LAST:event_BPriaActionPerformed

    private void NamaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaPActionPerformed

    private void KodePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodePActionPerformed

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

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
        String kode_pegawai = KodeP.getText();
         
        Pegawai pt = new Pegawai(kode_pegawai, null, null, null, null, null, null);

        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?", 
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (hapus == JOptionPane.YES_OPTION)
        {
            ptController.setDml(pt, OperasiCRUD.DELETE);
        }        
    }//GEN-LAST:event_DeleteBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        String kode_pegawai = KodeP.getText();
        String nama_pegawai = NamaP.getText();
        
        tgl_lahir = new Date(
            TanggalP.getDate().getYear(),
            TanggalP.getDate().getMonth(),
            TanggalP.getDate().getDate()
        );
        
        tgl_masuk = new Date(
            MasukP.getDate().getYear(),
            MasukP.getDate().getMonth(),
            MasukP.getDate().getDate()
        );

        int indeks = JabatanCbBox.getSelectedIndex();
        Jabatan jabatan = jController.getAllJabatan().get(indeks);
         
        Pegawai pt = new Pegawai
        (
            kode_pegawai, 
            nama_pegawai,
            jabatan.getKode_jabatan(),
            tgl_lahir,
            jenis_kelamin,
            tgl_masuk,
            status
        );
        
        ptController.setDml(pt, OperasiCRUD.UPDATE);        
    }//GEN-LAST:event_EditBActionPerformed

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        // TODO add your handling code here:
        if (KodeP.getText() == null)
        {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        }
            else if (NamaP.getText() == null)
            {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
            }
            
            else if (!BPria.isSelected() &&
                     !BWanita.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Pilih jenis kelamin anda");
            }
            
            else if (!BMenikah.isSelected() &&
                     !BBelum_Menikah.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Pilih status anda");
            }
                else
                {
                    String kode_pegawai = KodeP.getText();
                    String nama_pegawai = NamaP.getText();

                    tgl_lahir = new Date
                    (
                        TanggalP.getDate().getYear(),
                        TanggalP.getDate().getMonth(),
                        TanggalP.getDate().getDate()
                    );

                    tgl_masuk = new Date
                    (
                        MasukP.getDate().getYear(),
                        MasukP.getDate().getMonth(),
                        MasukP.getDate().getDate()
                    );

                    int indeks = JabatanCbBox.getSelectedIndex();
                    Jabatan jabatan = jController.getAllJabatan().get(indeks);

                    Pegawai pt = new Pegawai
                    (
                        kode_pegawai, 
                        nama_pegawai,
                        jabatan.getKode_jabatan(),
                        tgl_lahir,
                        jenis_kelamin,
                        tgl_masuk,
                        status
                    );

                    ptController.setDml(pt, OperasiCRUD.INSERT);
                }
    }//GEN-LAST:event_SaveBActionPerformed

    private void TabelPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPMouseClicked
        tabletoform();
    }//GEN-LAST:event_TabelPMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        List<String> listNamaJabatan = new ArrayList<>();
        
        for (Jabatan j : jController.getAllJabatan())
        {
            listNamaJabatan.add(j.toString());
        }
        
        setTabelJabatan(listNamaJabatan);
        setTabelPegawai(ptController.getAllPegawaiTetap());
    }//GEN-LAST:event_formInternalFrameActivated
    
    @Override
    public void update(Observable o, Object arg)
    {
        if (o == ptController)
        {
            Pegawai pt = (Pegawai) arg;
            
            if (null != ptController.getCRUDState())
            {
                switch (ptController.getCRUDState()) 
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
            
            setTabelPegawai(ptController.getAllPegawaiTetap());
            resetForm();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(PegawaiForm.class.getName())
            .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new PegawaiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BBelum_Menikah;
    private javax.swing.JRadioButton BMenikah;
    private javax.swing.JRadioButton BPria;
    private javax.swing.JRadioButton BWanita;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JComboBox<String> JabatanCbBox;
    private javax.swing.JTextField KodeP;
    private javax.swing.JLabel Label_JabatanP;
    private javax.swing.JLabel Label_JenisP;
    private javax.swing.JLabel Label_KodeP;
    private javax.swing.JLabel Label_MasukP;
    private javax.swing.JLabel Label_NamaP;
    private javax.swing.JLabel Label_StatusP;
    private javax.swing.JLabel Label_TanggalP;
    private com.toedter.calendar.JDateChooser MasukP;
    private javax.swing.JTextField NamaP;
    private javax.swing.JButton SaveB;
    private javax.swing.JTable TabelP;
    private com.toedter.calendar.JDateChooser TanggalP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}