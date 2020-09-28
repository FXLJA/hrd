package controllers;

import java.util.*;

import daos.PosisiDAO;
import models.Posisi;
import main.OperasiCRUD;
import interfaces.PosisiInterface;

public class PosisiController extends Observable
{
private PosisiInterface dao = new PosisiDAO();
private OperasiCRUD crud;

    public void setDml (Posisi po, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(po);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(po);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(po);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(po);
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
    
    public List<Posisi> getAllPosisi()
    {
        return dao.getAllPosisi();
    }
    
    public Posisi getByID(String id)
    {
        return dao.getByID(id);
    }
}