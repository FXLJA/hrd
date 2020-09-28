package controllers;

import java.util.*;

import daos.TunjanganDAO;
import models.Tunjangan;
import main.OperasiCRUD;
import interfaces.TunjanganInterface;

public class TunjanganController extends Observable
{
private TunjanganInterface dao = new TunjanganDAO();
private OperasiCRUD crud;

    public void setDml (Tunjangan t, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(t);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(t);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(t);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(t);
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
    
    public List<Tunjangan> getAllTunjangan()
    {
        return dao.getAllTunjangan();
    }
    
    public Tunjangan getByID(String kode_tunjangan){
        return dao.getByID(kode_tunjangan);
    }
}