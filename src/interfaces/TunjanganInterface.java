package interfaces;

import java.util.List;

import models.Tunjangan;

public interface TunjanganInterface
{
    public boolean insert (Tunjangan t);
    public boolean update (Tunjangan t);
    public boolean delete (Tunjangan t);   
    
    public List<Tunjangan> getAllTunjangan();
    public Tunjangan getByID(String kode_tunjangan);
}