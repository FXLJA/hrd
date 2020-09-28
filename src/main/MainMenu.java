package main;

import java.io.*;
import java.awt.Desktop;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

import views.DetailForm;
import views.DivisiForm;
import views.JabatanForm;
import views.PegawaiForm;
import views.PengangkatanForm;
import views.TunjanganForm;
import views.PosisiForm;
import views.GajiForm;

public class MainMenu extends javax.swing.JFrame 
{
JabatanForm Jform = new JabatanForm();
PegawaiForm PTform = new PegawaiForm();
DivisiForm Dform = new DivisiForm();
TunjanganForm Tform = new TunjanganForm();
PosisiForm Poform = new PosisiForm();
DetailForm Dtform = new DetailForm();
PengangkatanForm Peform = new PengangkatanForm();
GajiForm Gform = new GajiForm();

String username;
String password;
        
    public MainMenu() 
    {
        initComponents();
        
        menuBar.setEnabled(false);
        InputMenu.setEnabled(false);
        ModifyMenu.setEnabled(false);
        HelpMenu.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        LoginPanel = new javax.swing.JInternalFrame();
        Label_Judul = new javax.swing.JLabel();
        Label_Username = new javax.swing.JLabel();
        Label_Password = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        LoginB = new javax.swing.JButton();
        ExitB = new javax.swing.JButton();
        MainBackground = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        InputMenu = new javax.swing.JMenu();
        InputPegawai = new javax.swing.JMenuItem();
        InputJabatan = new javax.swing.JMenuItem();
        InputDivisi = new javax.swing.JMenuItem();
        InputTunjangan = new javax.swing.JMenuItem();
        ModifyMenu = new javax.swing.JMenu();
        ModifAngkat = new javax.swing.JMenuItem();
        ModifPosisi = new javax.swing.JMenuItem();
        ModifDetail = new javax.swing.JMenuItem();
        ModifGaji = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        Readme = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        desktopPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desktopPane.setName(""); // NOI18N
        desktopPane.setPreferredSize(new java.awt.Dimension(1280, 720));

        LoginPanel.setVisible(true);

        Label_Judul.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        Label_Judul.setText("LOGIN");

        Label_Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Username.setText("Username");

        Label_Password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Password.setText("Password");

        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        LoginB.setText("Sign in");
        LoginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBActionPerformed(evt);
            }
        });

        ExitB.setText("Exit");
        ExitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel.getContentPane());
        LoginPanel.getContentPane().setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Username)
                    .addComponent(Label_Password))
                .addGap(37, 37, 37)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(Password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(LoginB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(ExitB)
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label_Judul)
                .addGap(156, 156, 156))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Judul)
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Username)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Password)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        desktopPane.add(LoginPanel);
        LoginPanel.setBounds(470, 210, 460, 260);

        MainBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/MainBG.jpg"))); // NOI18N
        desktopPane.add(MainBackground);
        MainBackground.setBounds(0, 0, 1350, 1050);

        InputMenu.setMnemonic('f');
        InputMenu.setText("Input Data");

        InputPegawai.setMnemonic('o');
        InputPegawai.setText("Tambah Pegawai");
        InputPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPegawaiActionPerformed(evt);
            }
        });
        InputMenu.add(InputPegawai);

        InputJabatan.setMnemonic('s');
        InputJabatan.setText("Tambah Jabatan");
        InputJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputJabatanActionPerformed(evt);
            }
        });
        InputMenu.add(InputJabatan);

        InputDivisi.setMnemonic('a');
        InputDivisi.setText("Tambah Divisi");
        InputDivisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputDivisiActionPerformed(evt);
            }
        });
        InputMenu.add(InputDivisi);

        InputTunjangan.setMnemonic('x');
        InputTunjangan.setText("Tambah Tunjangan");
        InputTunjangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTunjanganActionPerformed(evt);
            }
        });
        InputMenu.add(InputTunjangan);

        menuBar.add(InputMenu);

        ModifyMenu.setMnemonic('e');
        ModifyMenu.setText("Modifikasi Data");

        ModifAngkat.setMnemonic('t');
        ModifAngkat.setText("Angkat Pegawai");
        ModifAngkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifAngkatActionPerformed(evt);
            }
        });
        ModifyMenu.add(ModifAngkat);

        ModifPosisi.setMnemonic('y');
        ModifPosisi.setText("Atur Posisi Pegawai");
        ModifPosisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifPosisiActionPerformed(evt);
            }
        });
        ModifyMenu.add(ModifPosisi);

        ModifDetail.setMnemonic('p');
        ModifDetail.setText("Atur Status Detail Pegawai");
        ModifDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifDetailActionPerformed(evt);
            }
        });
        ModifyMenu.add(ModifDetail);

        ModifGaji.setMnemonic('d');
        ModifGaji.setText("Atur Gaji Pegawai");
        ModifGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifGajiActionPerformed(evt);
            }
        });
        ModifyMenu.add(ModifGaji);

        menuBar.add(ModifyMenu);

        HelpMenu.setMnemonic('h');
        HelpMenu.setText("Bantuan");

        Readme.setMnemonic('c');
        Readme.setText("View Readme");
        Readme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadmeActionPerformed(evt);
            }
        });
        HelpMenu.add(Readme);

        About.setMnemonic('a');
        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        HelpMenu.add(About);

        menuBar.add(HelpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputTunjanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTunjanganActionPerformed
        desktopPane.add(Tform);
        Tform.setVisible(true);
    }//GEN-LAST:event_InputTunjanganActionPerformed

    private void ReadmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadmeActionPerformed
        // TODO add your handling code here:
        if(Desktop.isDesktopSupported())
        {
            try 
            {
                Desktop.getDesktop()
                       .open(new File(getClass()
                       .getClassLoader()
                       .getResource("main/Readme.txt").toURI()));
            } 
            catch (IOException | URISyntaxException ex) 
            {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ReadmeActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
        if(Desktop.isDesktopSupported())
        {
            try 
            {
                Desktop.getDesktop().open(new File(getClass()
                       .getClassLoader().getResource("main/About.txt").toURI()));
            } 
            catch (IOException | URISyntaxException ex) 
            {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_AboutActionPerformed

    private void InputJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputJabatanActionPerformed
        // TODO add your handling code here:
        desktopPane.add(Jform);
        Jform.setVisible(true);
    }//GEN-LAST:event_InputJabatanActionPerformed

    private void InputPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPegawaiActionPerformed
        // TODO add your handling code here:
        desktopPane.add(PTform);
        PTform.setVisible(true);
    }//GEN-LAST:event_InputPegawaiActionPerformed

    private void InputDivisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputDivisiActionPerformed
        // TODO add your handling code here:
        desktopPane.add(Dform);
        Dform.setVisible(true);        
    }//GEN-LAST:event_InputDivisiActionPerformed

    private void ModifPosisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifPosisiActionPerformed
        // TODO add your handling code here:
        desktopPane.add(Poform);
        Poform.setVisible(true);
    }//GEN-LAST:event_ModifPosisiActionPerformed

    private void ModifDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifDetailActionPerformed
        // TODO add your handling code here:
        desktopPane.add(Dtform);
        Dtform.setVisible(true);
    }//GEN-LAST:event_ModifDetailActionPerformed

    private void ModifAngkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifAngkatActionPerformed
        // TODO add your handling code here:
        desktopPane.add(Peform);
        Peform.setVisible(true);
    }//GEN-LAST:event_ModifAngkatActionPerformed

    private void ModifGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifGajiActionPerformed
        // TODO add your handling code here:
        desktopPane.add(Gform);
        Gform.setVisible(true);
    }//GEN-LAST:event_ModifGajiActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void LoginBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBActionPerformed
        // TODO add your handling code here:       
        menuBar.setEnabled(false);
        InputMenu.setEnabled(false);
        ModifyMenu.setEnabled(false);
        HelpMenu.setEnabled(false);
        
        username = Username.getText();
        password = Password.getText();
        
        if ("user".equals(Username.getText()) &&
            "pass".equals(Password.getText()))
        {
            LoginPanel.dispose();
            menuBar.setEnabled(true);
            InputMenu.setEnabled(true);
            ModifyMenu.setEnabled(true);
            HelpMenu.setEnabled(true);
        }
            else
            {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
    }//GEN-LAST:event_LoginBActionPerformed

    private void ExitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater
        (new Runnable() 
            {
                public void run() 
                {
                    new MainMenu().setVisible(true);
                }
            }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JButton ExitB;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem InputDivisi;
    private javax.swing.JMenuItem InputJabatan;
    private javax.swing.JMenu InputMenu;
    private javax.swing.JMenuItem InputPegawai;
    private javax.swing.JMenuItem InputTunjangan;
    private javax.swing.JLabel Label_Judul;
    private javax.swing.JLabel Label_Password;
    private javax.swing.JLabel Label_Username;
    private javax.swing.JButton LoginB;
    private javax.swing.JInternalFrame LoginPanel;
    private javax.swing.JLabel MainBackground;
    private javax.swing.JMenuItem ModifAngkat;
    private javax.swing.JMenuItem ModifDetail;
    private javax.swing.JMenuItem ModifGaji;
    private javax.swing.JMenuItem ModifPosisi;
    private javax.swing.JMenu ModifyMenu;
    private javax.swing.JPasswordField Password;
    private javax.swing.JMenuItem Readme;
    private javax.swing.JTextField Username;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}