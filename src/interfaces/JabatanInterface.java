package interfaces;

import java.util.List;

import models.Jabatan;

public interface JabatanInterface 
{
    public boolean insert (Jabatan j);
    public boolean update (Jabatan j);
    public boolean delete (Jabatan j);

    public List<Jabatan> getAllJabatan();
    public Jabatan getbyID(String kode_jabatan);
}