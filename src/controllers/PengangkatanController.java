package controllers;

import java.util.List;
import java.util.Observable;

import daos.PengangkatanDAO;
import models.Pengangkatan;
import main.OperasiCRUD;
import interfaces.PengangkatanInterface;

public class PengangkatanController extends Observable
{
private PengangkatanInterface dao = new PengangkatanDAO();
private OperasiCRUD crud;

    public void setDAO (PengangkatanInterface pe)
    {
        dao = pe;
    }
    
    public void setDml (Pengangkatan pe, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(pe);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(pe);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(pe);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(pe);

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

    public List<Pengangkatan> getAllPengangkatan()
    {
        return dao.getAllPengangkatan();
    }
    
    public Pengangkatan getByID(String id)
    {
        return dao.getByID(id);
    }
}