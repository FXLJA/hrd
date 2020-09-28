package interfaces;

import java.util.List;

import models.Pengangkatan;
        
public interface PengangkatanInterface 
{
    public boolean insert (Pengangkatan pt);
    public boolean update (Pengangkatan pt);
    public boolean delete (Pengangkatan pt);

    public List<Pengangkatan> getAllPengangkatan();
    public Pengangkatan getByID(String id);
}