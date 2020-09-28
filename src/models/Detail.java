package models;

public class Detail 
{
    String kode_pegawai;
    String jumlah_anak;
    String nama_hw;

    public Detail(String kode_pegawai, String nama_hw, String jumlah_anak)
    {
        this.kode_pegawai = kode_pegawai;
        this.nama_hw = nama_hw;
        this.jumlah_anak = jumlah_anak;
    }

    public String getKode_pegawai() 
    {
        return kode_pegawai;
    }

    public void setKode_pegawai(String kode_pegawai) 
    {
        this.kode_pegawai = kode_pegawai;
    }

    public String getJumlah_anak() 
    {
        return jumlah_anak;
    }

    public void setJumlah_anak(String jumlah_anak) 
    {
        this.jumlah_anak = jumlah_anak;
    }

    public String getNama_hw() 
    {
        return nama_hw;
    }

    public void setNama_hw(String nama_hw) 
    {
        this.nama_hw = nama_hw;
    }
}