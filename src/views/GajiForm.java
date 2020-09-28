package views;

import java.util.List;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyVetoException;

import models.Gaji;
import models.Pengangkatan;
import models.Tunjangan;
import main.OperasiCRUD;
import controllers.GajiController;
import controllers.PengangkatanController;
import controllers.DivisiController;
import controllers.TunjanganController;
import javax.swing.DefaultComboBoxModel;
import models.Divisi;

public class GajiForm extends javax.swing.JInternalFrame implements Observer
{
private final GajiController gController = new GajiController();
private final PengangkatanController paController = new PengangkatanController();
private final DivisiController dController = new DivisiController();
private final TunjanganController tController = new TunjanganController();
DefaultTableModel TableModel;

final double GAJIPOKOK = 2500000.0;

int tgl_terima;
String kode_pegawai;
String kode_divisi;
String kode_tunjangan;
double total;

    public GajiForm() 
    {
        initComponents();

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        List<String> listJenisTunjangan = new ArrayList<>();
        
        for (Tunjangan t : tController.getAllTunjangan())
        {
            listJenisTunjangan.add(t.getNama_tunjangan());
        }
        
        setTabelTunjangan(listJenisTunjangan);
        
        setTabelGaji(gController.getAllGaji());
        
        gController.addObserver(this);
        resetForm();
    } 

    private void setTabelTunjangan(List<String> listT){
        if (listT == null)
        {
            JOptionPane.showMessageDialog(this, "Data kosong",
                                          "Gagal koneksi", JOptionPane.ERROR_MESSAGE);
        }
            else
            {
                TunjanganCbBox.setModel(new DefaultComboBoxModel(listT.toArray()));
            }
    }
    
    private void setTabelGaji (List<Gaji> listG)
    {
        if (listG == null)
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
                        "Tanggal Pengambilan",
                        "Kode Karyawan", "Nama Divisi", "Jenis Tunjangan",
                        "Total"
                    }
                );
                
                for (Gaji g : listG)
                {
                    Object o [] = new Object [6];
                    o[0] = g.getTgl_terima();
                    o[1] = g.getKode_pegawai();
                    o[2] = g.getKode_divisi();
                    o[3] = g.getKode_tunjangan();
                    o[4] = g.getTotal();
                    
                    TableModel.addRow(o);
                }
                
                TabelGaji.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TabelGaji.setModel(TableModel);
            }
    }
    
    private void updateData()
    {
        Pengangkatan pa = paController.getByID(KodeP.getText());
        
        kode_pegawai = pa.getKode_karyawan();
        kode_divisi = pa.getKode_divisi();
        
        Tunjangan t = tController.getAllTunjangan().get(TunjanganCbBox.getSelectedIndex());
        
        kode_tunjangan = t.getKode_tunjangan();
        tgl_terima = T_Ambil.getDay();
        
        total = Double.parseDouble(Total.getText());
    }
    
    private void resetForm()
    {
        KodeP.setText(null);
        NamaD.setText(null);
        TunjanganCbBox.setSelectedItem(null);
        Total.setText(null);
        
        EditB.setEnabled(false);
        DeleteB.setEnabled(false);
        
        KodeP.requestFocus();
    }
    
    private void tabletoForm()
    {
    int indeks = TabelGaji.getSelectedRow();
    
        T_Ambil.setDay((int) TableModel.getValueAt(TabelGaji.getSelectedRow(), 0));
        KodeP.setText(TableModel.getValueAt(TabelGaji.getSelectedRow(), 1) + "");
        NamaD.setText(TableModel.getValueAt(TabelGaji.getSelectedRow(), 2) + "");

        TunjanganCbBox.setSelectedItem
        (
            TabelGaji.getValueAt(indeks, 3)
        );
        
        KodeP.setEnabled(false);
        
        SaveB.setEnabled(false);
        EditB.setEnabled(true);
        DeleteB.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelGaji = new javax.swing.JTable();
        Label_Judul = new javax.swing.JLabel();
        Label_KodeK = new javax.swing.JLabel();
        Label_KodeD = new javax.swing.JLabel();
        Label_KodeT = new javax.swing.JLabel();
        Label_Tgl_terima = new javax.swing.JLabel();
        Label_Total = new javax.swing.JLabel();
        NamaD = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();
        KodeP = new javax.swing.JTextField();
        SaveB = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        T_Ambil = new com.toedter.calendar.JDayChooser();
        Label_isFound = new javax.swing.JLabel();
        BCari2 = new javax.swing.JButton();
        TunjanganCbBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TabelGaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal Pengambilan", "Kode Karyawan", "Nama Divisi", "Jenis Tunjangan", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelGaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelGajiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelGaji);

        Label_Judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        Label_Judul.setForeground(new java.awt.Color(204, 204, 0));
        Label_Judul.setText("Data Gaji");

        Label_KodeK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_KodeK.setText("Kode Karyawan");

        Label_KodeD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_KodeD.setText("Nama Divisi");

        Label_KodeT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_KodeT.setText("Jenis Tunjangan");

        Label_Tgl_terima.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Tgl_terima.setText("Tanggal Pengambilan");

        Label_Total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Total.setText("Total");

        NamaD.setEnabled(false);

        Total.setEnabled(false);

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

        BCari2.setText("Cari");
        BCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCari2ActionPerformed(evt);
            }
        });

        TunjanganCbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TunjanganCbBox.setEnabled(false);
        TunjanganCbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TunjanganCbBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_KodeT)
                            .addComponent(Label_KodeD)
                            .addComponent(Label_KodeK))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TunjanganCbBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KodeP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(BCari2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_isFound)
                        .addGap(160, 160, 160))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_Total)
                                .addGap(117, 117, 117)
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(Label_Judul))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_Tgl_terima)
                                .addGap(18, 18, 18)
                                .addComponent(T_Ambil, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(SaveB)
                                .addGap(18, 18, 18)
                                .addComponent(EditB)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteB)
                                .addGap(18, 18, 18)
                                .addComponent(ExitB)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Judul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KodeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCari2)
                    .addComponent(Label_KodeK))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_KodeD, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NamaD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_KodeT)
                    .addComponent(TunjanganCbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_isFound)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Tgl_terima)
                    .addComponent(T_Ambil, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Total))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        updateData();
 
        Gaji g = new Gaji(tgl_terima, kode_pegawai, kode_divisi, kode_tunjangan, total);
        gController.setDml(g, OperasiCRUD.INSERT);
    }//GEN-LAST:event_SaveBActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        updateData();
 
        Gaji g = new Gaji(tgl_terima, kode_pegawai, kode_divisi, kode_tunjangan, total);
        gController.setDml(g, OperasiCRUD.UPDATE);
    }//GEN-LAST:event_EditBActionPerformed

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        kode_pegawai = KodeP.getText();
        
        Gaji g = new Gaji(tgl_terima, kode_pegawai, kode_divisi, kode_tunjangan, total);

        int hapus = JOptionPane.showConfirmDialog(null, "Hapus data?", 
                                                  null, JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (hapus == JOptionPane.YES_OPTION)
        {
            gController.setDml(g, OperasiCRUD.DELETE);
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
            Logger.getLogger(GajiForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ExitBActionPerformed

    private void BCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCari2ActionPerformed
        // TODO add your handling code here:
        String id = KodeP.getText();
        
        Pengangkatan pa = paController.getByID(id);
        
        Label_isFound.setVisible(true);
        TunjanganCbBox.setEnabled(true);
        
        if(pa != null) 
        {
            Label_isFound.setText("Pegawai ditemukan");
            
            Divisi d = dController.getByID(pa.getKode_divisi());
            String nama_divisi = d.getNama_divisi();
            NamaD.setText(nama_divisi);
            return;
        } 
            else 
            {
                Label_isFound.setText("Situ siapa?");
            }
        
        TunjanganCbBox.setEnabled(false);
    }//GEN-LAST:event_BCari2ActionPerformed

    private void TunjanganCbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TunjanganCbBoxActionPerformed
        int indeks = TunjanganCbBox.getSelectedIndex();
        
        if(indeks != -1)
        {
            Tunjangan t = tController.getAllTunjangan().get(indeks);
            Total.setText(GAJIPOKOK + t.getNilai() +"");
        } 
            else 
            {
                Total.setText("");
            }
    }//GEN-LAST:event_TunjanganCbBoxActionPerformed

    private void TabelGajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGajiMouseClicked
        // TODO add your handling code here:
        tabletoForm();
    }//GEN-LAST:event_TabelGajiMouseClicked

    @Override
    public void update(Observable o, Object arg)
    {
        if (o == gController)
        {
            Gaji g = (Gaji) arg;
            
            if (null != gController.getCRUDState())
            {
                switch (gController.getCRUDState()) 
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
            
            setTabelGaji(gController.getAllGaji());
            resetForm();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(GajiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new GajiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCari2;
    private javax.swing.JButton DeleteB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton ExitB;
    private javax.swing.JTextField KodeP;
    private javax.swing.JLabel Label_Judul;
    private javax.swing.JLabel Label_KodeD;
    private javax.swing.JLabel Label_KodeK;
    private javax.swing.JLabel Label_KodeT;
    private javax.swing.JLabel Label_Tgl_terima;
    private javax.swing.JLabel Label_Total;
    private javax.swing.JLabel Label_isFound;
    private javax.swing.JTextField NamaD;
    private javax.swing.JButton SaveB;
    private com.toedter.calendar.JDayChooser T_Ambil;
    private javax.swing.JTable TabelGaji;
    private javax.swing.JTextField Total;
    private javax.swing.JComboBox<String> TunjanganCbBox;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}