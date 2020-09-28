package models;

public class Divisi
{
private String kode_divisi;
private String nama_divisi;

    public Divisi(String kode_divisi, String nama_divisi) 
    {
        this.kode_divisi = kode_divisi;
        this.nama_divisi = nama_divisi;
    }

    public String getKode_divisi() 
    {
        return kode_divisi;
    }

    public void setKode_divisi(String kode_divisi) 
    {
        this.kode_divisi = kode_divisi;
    }

    public String getNama_divisi()
    {
        return nama_divisi;
    }

    public void setNama_divisi(String nama_divisi)
    {
        this.nama_divisi = nama_divisi;
    }
}