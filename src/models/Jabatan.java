package models;

public class Jabatan
{
private String kode_jabatan;
private String nama_jabatan;

    public Jabatan(String kode_jabatan, String nama_jabatan) 
    {
        this.kode_jabatan = kode_jabatan;
        this.nama_jabatan = nama_jabatan;
    }

    public String getKode_jabatan()
    {
        return kode_jabatan;
    }

    public void setKode_jabatan(String kode_jabatan) 
    {
        this.kode_jabatan = kode_jabatan;
    }

    public String getNama_jabatan() 
    {
        return nama_jabatan;
    }

    public void setNama_jabatan(String nama_jabatan) 
    {
        this.nama_jabatan = nama_jabatan;
    }

    @Override
    public String toString()
    {
        return this.nama_jabatan;
    }
}