package controllers;

import java.util.*;
import java.util.Observable;

import daos.GajiDAO;
import models.Gaji;
import main.OperasiCRUD;
import interfaces.GajiInterface;

public class GajiController extends Observable
{
private GajiInterface dao = new GajiDAO();
private OperasiCRUD crud;

    public void setDml (Gaji ga, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(ga);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(ga);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(ga);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(ga);
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
    
    public List<Gaji> getAllGaji()
    {
        return dao.getAllGaji();
    }
    
    public Gaji getByID(String id)
    {
        return dao.getByID(id);
    }
}