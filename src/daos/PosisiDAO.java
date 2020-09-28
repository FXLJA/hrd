package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Posisi;
import models.Jabatan;
import interfaces.PosisiInterface;

public class PosisiDAO implements PosisiInterface
{
    @Override
    public boolean insert (Posisi po)
    {
    String sql = "INSERT INTO posisi values (?, ?, ?, ?, ?)";
    //?1 = Kode pegawai
    //?1 = Kode jabatan
    //?1 = Tanggal mulai
    //?1 = Tanggal selesai
    //?1 = Periode
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, po.getKode_pegawai());
            statement.setString(2, po.getKode_jabatan());
            statement.setDate(3, po.getTgl_mulai());
            statement.setDate(4, po.getTgl_selesai());
            statement.setInt(5, po.getPeriode());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Posisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public boolean update (Posisi po)
    {
    String sql = "UPDATE posisi SET "
            + "kode_jabatan = ?, tgl_mulai = ?, "
            + "tgl_selesai = ?, periode = ?"
            + " WHERE kode_pegawai = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, po.getKode_jabatan());
            statement.setDate(2, po.getTgl_mulai());
            statement.setDate(3, po.getTgl_selesai());
            statement.setInt(4, po.getPeriode());
            statement.setString(5, po.getKode_pegawai());
            
            int row = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Posisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public boolean delete (Posisi po)
    {
    String sql = "DELETE FROM posisi WHERE kode_pegawai = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, po.getKode_pegawai());
            
            int row = statement.executeUpdate();
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Posisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public List<Posisi> getAllPosisi()
    {
    ArrayList<Posisi> listPo = new ArrayList<>();
    String sql = "SELECT * FROM posisi";
    
        try
        {
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
                        Posisi po = new Posisi (rs.getString(1), 
                                                rs.getString(2),
                                                rs.getDate(3),
                                                rs.getDate(4),
                                                rs.getInt(5));
                        listPo.add(po);
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Posisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listPo;
    }    

    @Override
    public Posisi getByID(String id) 
    {
        Posisi po = null;
        String sql = "SELECT * FROM posisi WHERE kode_pegawai = ?";
    
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
                        po = new Posisi (rs.getString(1), 
                                        rs.getString(2),
                                        rs.getDate(3),
                                        rs.getDate(4),
                                        rs.getInt(5));                     
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Posisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return po;
    }
}