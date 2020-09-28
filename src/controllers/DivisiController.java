package controllers;

import java.util.*;

import daos.DivisiDAO;
import models.Divisi;
import main.OperasiCRUD;
import interfaces.DivisiInterface;

public class DivisiController extends Observable
{
private DivisiInterface dao = new DivisiDAO();
private OperasiCRUD crud;

    public void setDml (Divisi d, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(d);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(d);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(d);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(d);
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
    
    public List<Divisi> getAllDivisi()
    {
        return dao.getAllDivisi();
    }
    
    public Divisi getByID(String id)
    {
        return dao.getByID(id);
    }
}