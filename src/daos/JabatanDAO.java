package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Jabatan;
import interfaces.JabatanInterface;

public class JabatanDAO implements JabatanInterface
{
    @Override
    public boolean insert (Jabatan j)
    {
    String sql = "INSERT INTO jabatan values (?, ?)";
    //?1 = Kode jabatan
    //?2 = Nama jabatan
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, j.getKode_jabatan());
            statement.setString(2, j.getNama_jabatan());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Jabatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }  
  
    @Override
    public boolean update (Jabatan j)
    {
    String sql = "UPDATE jabatan SET nama_jabatan = ? WHERE kode_jabatan = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, j.getNama_jabatan());
            statement.setString(2, j.getKode_jabatan());
            
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
    public boolean delete (Jabatan j)
    {
    String sql = "DELETE FROM jabatan WHERE kode_jabatan = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, j.getKode_jabatan());
            
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
    public List<Jabatan> getAllJabatan()
    {
    ArrayList<Jabatan> listJ = new ArrayList<>();
    String sql = "SELECT * FROM jabatan";
    
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
                        Jabatan j = new Jabatan (rs.getString(1),
                                                 rs.getString(2));
                        
                        listJ.add(j);
                    }
                    
                    statement.close();
                }
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Jabatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listJ;
    }
    
    @Override
    public Jabatan getbyID(String kode_jabatan){
    String sql = "SELECT * FROM jabatan WHERE kode_jabatan = ?";
    Jabatan j = null;
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, kode_jabatan);
            
            ResultSet rs = statement.executeQuery();
                
                    if(rs.next())
                        j = new Jabatan (rs.getString(1), rs.getString(2));

                    statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Jabatan.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return j;
    }
}