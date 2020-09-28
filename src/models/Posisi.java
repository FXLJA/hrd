package models;

import java.sql.Date;

public class Posisi
{
    String kode_pegawai;
    String kode_jabatan;
    Date tgl_mulai;
    Date tgl_selesai;
    int periode;

    public Posisi (String kode_pegawai, 
                   String kode_jabatan, 
                   Date tgl_mulai, 
                   Date tgl_selesai,
                   int periode)
    {
        this.kode_pegawai = kode_pegawai;
        this.kode_jabatan = kode_jabatan;
        this.periode = periode;
        this.tgl_mulai = tgl_mulai;
        this.tgl_selesai = tgl_selesai;
    }

    public String getKode_pegawai() {
        return kode_pegawai;
    }

    public void setKode_pegawai(String kode_pegawai) {
        this.kode_pegawai = kode_pegawai;
    }

    public String getKode_jabatan() {
        return kode_jabatan;
    }

    public void setKode_jabatan(String kode_jabatan) {
        this.kode_jabatan = kode_jabatan;
    }
    
    public int getPeriode() 
    {
        return periode;
    }

    public void setPeriode(int periode) 
    {
        this.periode = periode;
    }    
    
    public Date getTgl_mulai() 
    {
        return tgl_mulai;
    }

    public void setTgl_mulai(Date tgl_mulai) 
    {
        this.tgl_mulai = tgl_mulai;
    }

    public Date getTgl_selesai() 
    {
        return tgl_selesai;
    }

    public void setTgl_selesai(Date tgl_selesai) 
    {
        this.tgl_selesai = tgl_selesai;
    }
}