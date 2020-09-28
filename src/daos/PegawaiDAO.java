package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Jabatan;
import models.Pegawai;
import interfaces.PegawaiInterface;

public class PegawaiDAO implements PegawaiInterface
{
    @Override
    public boolean insert(Pegawai pt)
    {
    String sql = "INSERT INTO pegawai values (?, ?, ?, ?, ?, ?, ?)";
    //?1 = Kode pegawai
    //?2 = Nama pegawai
    //?3 = Kode jabatan
    //?4 = Tanggal lahir
    //?5 = Jenis kelamin
    //?6 = Tanggal masuk
    //?7 = Status
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, pt.getKode_pegawai());
            statement.setString(2, pt.getNama());
            statement.setString(3, pt.getKode_jabatan());
            statement.setDate(4, pt.getTgl_lahir());
            statement.setString(5, pt.getJenis_kelamin());
            statement.setDate(6, pt.getTgl_masuk());
            statement.setString(7, pt.getStatus());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public boolean update(Pegawai pt)
    {
    String sql = "UPDATE pegawai SET nama = ?, tgl_lahir = ?,"
            +                       "jenis_kelamin = ?, status = ?,"
            +                       "kode_jabatan = ?, tgl_masuk = ?"
            +    "WHERE kode_pegawai = ?";

        try
        {

            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, pt.getNama());
            statement.setDate(2, pt.getTgl_lahir());
            statement.setString(3, pt.getJenis_kelamin());
            statement.setString(4, pt.getStatus());
            statement.setString(5, pt.getKode_jabatan());
            statement.setDate(6, pt.getTgl_masuk());
            statement.setString(7, pt.getKode_pegawai());

            int row = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Jabatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public boolean delete(Pegawai pt)
    {
    String sql = "DELETE FROM pegawai WHERE kode_pegawai = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, pt.getKode_pegawai());
            
            int row = statement.executeUpdate();
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public List<Pegawai> getAllPegawaiTetap()
    {
    List<Pegawai> listPT = new ArrayList<Pegawai>();
    String sql = "SELECT * FROM pegawai";

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
                        Pegawai pt = new Pegawai
                        (
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getDate(6),
                            rs.getString(7)
                        );
                        
                        listPT.add(pt);
                    }
                }
        }
        catch(SQLException sqle)
        {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listPT;
    }
    
    @Override
    public Pegawai getByID(String id) 
    {
    Pegawai pt = null;
    String sql = "SELECT * FROM pegawai WHERE kode_pegawai = ?";
    
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
                        pt = new Pegawai
                        (
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getDate(6),
                            rs.getString(7)
                        );                      
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return pt;
    }
}