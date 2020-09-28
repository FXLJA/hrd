package models;

public class Tunjangan 
{
private String kode_tunjangan;
private String nama_tunjangan;
private double nilai;

    public Tunjangan(String kode_tunjangan, String nama_tunjangan, double nilai) 
    {
        this.kode_tunjangan = kode_tunjangan;
        this.nama_tunjangan = nama_tunjangan;
        this.nilai = nilai;
    }

    public String getKode_tunjangan() 
    {
        return kode_tunjangan;
    }

    public void setKode_tunjangan(String kode_tunjangan) 
    {
        this.kode_tunjangan = kode_tunjangan;
    }

    public String getNama_tunjangan() 
    {
        return nama_tunjangan;
    }

    public void setNama_tunjangan(String nama_tunjangan) 
    {
        this.nama_tunjangan = nama_tunjangan;
    }

    public double getNilai() 
    {
        return nilai;
    }

    public void setNilai(double nilai) 
    {
        this.nilai = nilai;
    }
}