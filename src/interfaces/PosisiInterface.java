package interfaces;

import java.util.List;

import models.Posisi;

public interface PosisiInterface 
{
    public boolean insert (Posisi po);
    public boolean update (Posisi po);
    public boolean delete (Posisi po);

    public List<Posisi> getAllPosisi(); 
    public Posisi getByID(String id);
}