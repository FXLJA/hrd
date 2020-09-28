package models;

public class Gaji
{
int tgl_terima;
String kode_pegawai;
String kode_divisi;
String kode_tunjangan;
double total;

    public Gaji(int tgl_terima, String kode_pegawai, 
                String kode_divisi, String kode_tunjangan, double total) 
    {
        this.tgl_terima = tgl_terima;
        this.kode_pegawai = kode_pegawai;
        this.kode_divisi = kode_divisi;
        this.kode_tunjangan = kode_tunjangan;
        this.total = total;
    }

    public int getTgl_terima() 
    {
        return tgl_terima;
    }

    public void setTgl_terima(int tgl_terima) 
    {
        this.tgl_terima = tgl_terima;
    }

    public String getKode_pegawai() 
    {
        return kode_pegawai;
    }

    public void setKode_pegawai(String kode_pegawai)
    {
        this.kode_pegawai = kode_pegawai;
    }

    public String getKode_divisi() {
        return kode_divisi;
    }

    public void setKode_divisi(String kode_divisi)
    {
        this.kode_divisi = kode_divisi;
    }

    public String getKode_tunjangan() 
    {
        return kode_tunjangan;
    }

    public void setKode_tunjangan(String kode_tunjangan)
    {
        this.kode_tunjangan = kode_tunjangan;
    }

    public double getTotal() 
    {
        return total;
    }

    public void setTotal(double total) 
    {
        this.total = total;
    }
}