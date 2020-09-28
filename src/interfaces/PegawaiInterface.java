package interfaces;

import java.util.List;

import models.Pegawai;
        
public interface PegawaiInterface 
{
    public boolean insert (Pegawai pt);
    public boolean update (Pegawai pt);
    public boolean delete (Pegawai pt);

    public List<Pegawai> getAllPegawaiTetap();
    public Pegawai getByID(String id);
}