package models;

import java.sql.Date;

public class Pegawai 
{
    String kode_pegawai;
    String nama;
    String kode_jabatan;
    Date tgl_lahir;
    Date tgl_masuk;
    String jenis_kelamin;
    String status;

    public Pegawai (
        String kode_pegawai, 
        String nama,
        String kode_jabatan,
        Date tgl_lahir, 
        String jenis_kelamin,
        Date tgl_masuk,
        String status
    ) {
        this.kode_pegawai = kode_pegawai;
        this.nama = nama;
        this.kode_jabatan = kode_jabatan;
        this.tgl_lahir = tgl_lahir;
        this.jenis_kelamin = jenis_kelamin;
        this.tgl_masuk = tgl_masuk;
        this.status = status;
    }

    public String getKode_pegawai() 
    {
        return kode_pegawai;
    }

    public void setKode_pegawai(String kode_pegawai) 
    {
        this.kode_pegawai = kode_pegawai;
    }

    public String getNama() 
    {
        return nama;
    }

    public void setNama(String nama) 
    {
        this.nama = nama;
    }

    public String getKode_jabatan() 
    {
        return kode_jabatan;
    }

    public void setKode_jabatan(String kode_jabatan) 
    {
        this.kode_jabatan = kode_jabatan;
    }

    public Date getTgl_lahir() 
    {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) 
    {
        this.tgl_lahir = tgl_lahir;
    }

    public Date getTgl_masuk() 
    {
        return tgl_masuk;
    }

    public void setTgl_masuk(Date tgl_masuk) 
    {
        this.tgl_masuk = tgl_masuk;
    }

    public String getJenis_kelamin() 
    {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) 
    {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }
}