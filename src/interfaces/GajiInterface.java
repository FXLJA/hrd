package interfaces;

import java.util.List;

import models.Gaji;

public interface GajiInterface 
{
    public boolean insert (Gaji ga);
    public boolean update (Gaji ga);
    public boolean delete (Gaji ga);

    public List<Gaji> getAllGaji();
    public Gaji getByID(String kode_pegawai);
}