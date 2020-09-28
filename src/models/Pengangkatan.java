package models;

import java.sql.Date;

public class Pengangkatan extends Divisi
{
String kode_karyawan;
String sk;
Date tgl_angkat;

    public Pengangkatan (String kode_divisi,
                         String nama_divisi,
                         String kode_karyawan,
                         String sk,
                         Date tgl_angkat)
    {
        super(kode_divisi, nama_divisi);
        
        this.kode_karyawan = kode_karyawan;
        this.sk = sk;
        this.tgl_angkat = tgl_angkat;
    }

    public String getKode_karyawan() 
    {
        return kode_karyawan;
    }

    public void setKode_karyawan(String kode_karyawan) 
    {
        this.kode_karyawan = kode_karyawan;
    }

    public String getSk() 
    {
        return sk;
    }

    public void setSk(String sk) 
    {
        this.sk = sk;
    }

    public Date getTgl_angkat() 
    {
        return tgl_angkat;
    }

    public void setTgl_angkat(Date tgl_angkat) 
    {
        this.tgl_angkat = tgl_angkat;
    }
}