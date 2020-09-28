package interfaces;

import java.util.List;

import models.Divisi;

public interface DivisiInterface 
{
    public boolean insert (Divisi d);
    public boolean update (Divisi d);
    public boolean delete (Divisi d);

    public List<Divisi> getAllDivisi();
    public Divisi getByID(String id);
}