package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Pengangkatan;
import interfaces.PengangkatanInterface;

public class PengangkatanDAO implements PengangkatanInterface
{

    @Override
    public boolean insert(Pengangkatan pe) 
    {
    String sql = "INSERT INTO pengangkatan values (?, ?, ?, ?)";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, pe.getKode_karyawan());
            statement.setString(2, pe.getKode_divisi());
            statement.setDate(3, pe.getTgl_angkat());
            statement.setString(4, pe.getSk());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Pengangkatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public boolean update(Pengangkatan pe) 
    {
    String sql = "UPDATE pengangkatan SET kode_divisi = ?, tanggal = ?, nomor_sk = ?"
            +    "WHERE kode_karyawan = ?";

        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, pe.getKode_divisi());
            statement.setDate(2, pe.getTgl_angkat());
            statement.setString(3, pe.getSk());
            statement.setString(4, pe.getKode_karyawan());

            int row = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Pengangkatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public boolean delete(Pengangkatan pe) 
    {
    String sql = "DELETE FROM pengangkatan WHERE kode_karyawan = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, pe.getKode_karyawan());
            
            int row = statement.executeUpdate();
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Pengangkatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public List<Pengangkatan> getAllPengangkatan() 
    {
    List<Pengangkatan> listPE = new ArrayList<Pengangkatan>();
    String sql = "SELECT pengangkatan.kode_divisi, divisi.nama_divisi, "
            +    "pengangkatan.kode_karyawan, pengangkatan.nomor_sk, "
            +    "pengangkatan.tanggal FROM pengangkatan INNER JOIN divisi "
            +    "ON pengangkatan.kode_divisi = divisi.kode_divisi";

        try{
            if (Koneksi.openConnection() == null)
            {
                return null;
            }
                else
                {
                    PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
                    ResultSet rs = statement.executeQuery();
                    
                    while (rs.next())
                    { 
                        Pengangkatan pe = new Pengangkatan
                        (
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getDate(5)
                        );     
                        
                        listPE.add(pe);
                    }
                }
        }
        catch(SQLException sqle)
        {
            Logger.getLogger(Pengangkatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listPE;
    }        

    @Override
    public Pengangkatan getByID(String id) 
    {
    Pengangkatan pe = null;
    String sql = "SELECT pengangkatan.kode_divisi, divisi.nama_divisi, "
            +    "pengangkatan.kode_karyawan, pengangkatan.nomor_sk, "
            +    "pengangkatan.tanggal FROM pengangkatan INNER JOIN divisi "
            +    "ON pengangkatan.kode_divisi = divisi.kode_divisi "
            +    "WHERE kode_karyawan = ?";
    
        try
        {
            if (Koneksi.openConnection() == null)
            {
                return null;
            }
                else
                {
                    PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
                    statement.setString(1, id);
                    
                    ResultSet rs = statement.executeQuery();
                
                    if (rs.next())
                    {
                        pe = new Pengangkatan
                        (
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getDate(5)
                        );                       
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Pengangkatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return pe;
    }
}