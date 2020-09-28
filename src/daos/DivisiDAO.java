package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Divisi;
import interfaces.DivisiInterface;

public class DivisiDAO implements DivisiInterface
{
    @Override
    public boolean insert (Divisi d)
    {
    String sql = "INSERT INTO divisi values (?, ?)";
    //?1 = Kode divisi
    //?2 = Nama divisi
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, d.getKode_divisi());
            statement.setString(2, d.getNama_divisi());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Divisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }  
  
    @Override
    public boolean update (Divisi d)
    {
    String sql = "UPDATE divisi SET nama_divisi = ? WHERE kode_divisi = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, d.getNama_divisi());
            statement.setString(2, d.getKode_divisi());
            
            int row = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Divisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public boolean delete (Divisi d)
    {
    String sql = "DELETE FROM divisi WHERE kode_divisi = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, d.getKode_divisi());
            
            int row = statement.executeUpdate();
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Divisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public List<Divisi> getAllDivisi()
    {
    ArrayList<Divisi> listD = new ArrayList<>();
    String sql = "SELECT * FROM divisi";
    
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
                        Divisi d = new Divisi (rs.getString(1),
                                               rs.getString(2)
                                                );
                        
                        listD.add(d);
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Divisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listD;
    }    
    
    @Override
    public Divisi getByID(String id)
    {
    Divisi d = null;
    String sql = "SELECT * FROM divisi where kode_divisi = ?";
    
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
                
                    while (rs.next())
                    {
                        d = new Divisi (rs.getString(1), rs.getString(2));
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Divisi.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return d;
    }    
}