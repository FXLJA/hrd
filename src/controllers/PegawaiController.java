package controllers;

import java.util.List;
import java.util.Observable;

import daos.PegawaiDAO;
import models.Pegawai;
import main.OperasiCRUD;
import interfaces.PegawaiInterface;

public class PegawaiController extends Observable
{
private PegawaiInterface dao = new PegawaiDAO();
private OperasiCRUD crud;

    public void setDAO (PegawaiInterface pt)
    {
        dao = pt;
    }
    
    public void setDml (Pegawai pt, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(pt);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(pt);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(pt);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(pt);

       }
            else
            {
                notifyObservers();
            }
    }
    
    public OperasiCRUD getCRUDState()
    {
        return crud;
    }

    public List<Pegawai> getAllPegawaiTetap()
    {
        return dao.getAllPegawaiTetap();
    }
    
    public Pegawai getByID(String id)
    {
        return dao.getByID(id);
    }
}