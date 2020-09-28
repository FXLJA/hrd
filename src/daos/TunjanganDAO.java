package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Tunjangan;
import interfaces.TunjanganInterface;

public class TunjanganDAO implements TunjanganInterface
{
    @Override
    public boolean insert (Tunjangan t)
    {
    String sql = "INSERT INTO tunjangan values (?, ?, ?)";
    //?1 = Kode tunjangan
    //?2 = Nama tunjangan
    //?3 = Nilai tunjangan
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, t.getKode_tunjangan());
            statement.setString(2, t.getNama_tunjangan());
            statement.setDouble(3, t.getNilai());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Tunjangan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }  
  
    @Override
    public boolean update (Tunjangan t)
    {
    String sql = "UPDATE tunjangan SET nama_tunjangan = ?,"
            +    "nilai = ?"
            +    "WHERE kode_tunjangan = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, t.getNama_tunjangan());
            statement.setDouble(2, t.getNilai());
            statement.setString(3, t.getKode_tunjangan());
            
            int row = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Tunjangan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public boolean delete (Tunjangan t)
    {
    String sql = "DELETE FROM tunjangan WHERE kode_tunjangan = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, t.getKode_tunjangan());
            
            int row = statement.executeUpdate();
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Tunjangan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }
    
    @Override
    public List<Tunjangan> getAllTunjangan()
    {
    ArrayList<Tunjangan> listT = new ArrayList<>();
    String sql = "SELECT * FROM tunjangan";
    
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
                        Tunjangan t = new Tunjangan (rs.getString(1),
                                                     rs.getString(2),
                                                     rs.getDouble(3));
                        
                        listT.add(t);
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Tunjangan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listT;
    }        
    
    @Override
    public Tunjangan getByID(String kode_tunjangan){
        String sql = "SELECT * from tunjangan where kode_tunjangan = ?";
        Tunjangan t = null;
        
        try{
            if (Koneksi.openConnection() == null)
                {
                    return null;
                }
                    else
                    {
                        PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
                        ResultSet rs = statement.executeQuery();

                        if (rs.next())
                        {
                            t = new Tunjangan (rs.getString(1),
                                                         rs.getString(2),
                                                         rs.getDouble(3));

                        }

                        statement.close();
                    }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Tunjangan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return t;
    }
}