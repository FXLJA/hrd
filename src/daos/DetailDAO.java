package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Detail;
import interfaces.DetailInterface;

public class DetailDAO implements DetailInterface
{
    @Override
    public boolean insert (Detail dt)
    {
    String sql = "INSERT INTO detail values (?, ?, ?)";
    //?1 = Kode pegawai
    //?2 = Nama suami / istri
    //?3 = Jumlah anak
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, dt.getKode_pegawai());
            statement.setString(2, dt.getNama_hw());
            statement.setString(3, dt.getJumlah_anak());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }  
  
    @Override
    public boolean update (Detail dt)
    {
    String sql = "UPDATE detail SET nama_hw = ?, jumlah_anak = ? WHERE kode_pegawai = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, dt.getNama_hw());
            statement.setString(2, dt.getJumlah_anak());
            statement.setString(3, dt.getKode_pegawai());
            
            int row = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public boolean delete (Detail dt)
    {
    String sql = "DELETE FROM detail WHERE kode_pegawai = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, dt.getKode_pegawai());
            
            int row = statement.executeUpdate();
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public List<Detail> getAllDetail()
    {
    ArrayList<Detail> listDt = new ArrayList<Detail>();
    String sql = "SELECT * from detail";
    
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
                        Detail dt = new Detail (rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3));
                        
                        listDt.add(dt);
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listDt;
    }    

    @Override
    public Detail getByID(String id) 
    {
    Detail dt = null;
    String sql = "SELECT * FROM detail WHERE kode_pegawai = ?";
    
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
                        dt = new Detail (rs.getString(1),
                                         rs.getString(2),
                                         rs.getString(3));                        
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return dt;
    }
}