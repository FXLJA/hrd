package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Koneksi;
import models.Gaji;
import interfaces.GajiInterface;

public class GajiDAO implements GajiInterface
{
    @Override
    public boolean insert(Gaji ga) 
    {
    String sql = "INSERT INTO gaji values (?, ?, ?, ?, ?)";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setInt(1, ga.getTgl_terima());
            statement.setString(2, ga.getKode_pegawai());
            statement.setString(3, ga.getKode_divisi());
            statement.setString(4, ga.getKode_tunjangan());
            statement.setDouble(5, ga.getTotal());
            
            int row = statement.executeUpdate();
            
            if (row > 0)
            {
                return true;
            }
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public boolean update(Gaji ga) 
    {
    String sql = "UPDATE gaji SET "
            + "tanggal = ?, kode_divisi = ?, "
            + "kode_tunjangan = ?, total = ?"
            + " WHERE kode_pegawai = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setInt(1, ga.getTgl_terima());
            statement.setString(2, ga.getKode_divisi());
            statement.setString(3, ga.getKode_tunjangan());
            statement.setDouble(4, ga.getTotal());
            statement.setString(5, ga.getKode_pegawai());
            
            int row = statement.executeUpdate();
            statement.close();
        }
        catch(SQLException sqle)
        {
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public boolean delete(Gaji ga) 
    {
    String sql = "DELETE FROM gaji WHERE kode_pegawai = ?";
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, ga.getKode_pegawai());
            
            int row = statement.executeUpdate();
            
            statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return false;
    }

    @Override
    public List<Gaji> getAllGaji() 
    {
        String sql = "SELECT * FROM gaji";
        List<Gaji> listG = new ArrayList<>();
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
                
                    while(rs.next()){
                        Gaji ga = new Gaji (rs.getInt(1), 
                                       rs.getString(2),
                                       rs.getString(3),
                                       rs.getString(4),
                                       rs.getDouble(5)
                        );
                        listG.add(ga);
                    }

                    statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return listG;
    }

    @Override
    public Gaji getByID(String kode_pegawai){
        String sql = "SELECT * FROM gaji WHERE kode_pegawai = ?";
        Gaji ga = null;
    
        try
        {
            PreparedStatement statement = Koneksi.openConnection().prepareStatement(sql);
            statement.setString(1, kode_pegawai);
            
            ResultSet rs = statement.executeQuery();
                
                    if(rs.next())
                        ga = new Gaji (rs.getInt(1), 
                                       rs.getString(2),
                                       rs.getString(3),
                                       rs.getString(4),
                                       rs.getDouble(5)
                        );

                    statement.close();
        }
        catch (SQLException sqle)
        {
            Logger.getLogger(Gaji.class.getName()).log(Level.SEVERE, null, sqle);
        }
        
        return ga;
    }
}